(function(mod) {
    if (typeof exports == "object" && typeof module == "object") // CommonJS
        mod(require("../../lib/codemirror"));
    else if (typeof define == "function" && define.amd) // AMD
        define(["../../lib/codemirror"], mod);
    else // Plain browser env
        mod(CodeMirror);
})(function(CodeMirror) {
    "use strict";

    function wordRegexp(words) {
        return new RegExp("^((" + words.join(")|(") + "))\\b");
    }
    //内置函数
    var wordOperators = wordRegexp(["and", "or", "not"]);
    var commonKeywords = ["for", "each", "in", "not", "like",
        "return", "if", "else", "PI", "MIU",
        "EB", "EE", "and", "or", "true",
        "false", "null", "desc", "asc"];
    var commonBuiltins = ["math", "select","one","jsonpath","xpath","execute","update","insert","delete"];
    CodeMirror.registerHelper("hintWords", "ssd", commonKeywords.concat(commonBuiltins));

    CodeMirror.defineMode("ssd", function(config, parserConfig) {
        var jsonldMode = parserConfig.jsonld;
        var isOperatorChar = /[+\-*&%=<>!?|~^@]/;
        var delimiters = parserConfig.delimiters || parserConfig.singleDelimiters || /^[\(\)\[\]\{\}@,:`=;\.\\]/;
        var operators = [parserConfig.singleOperators, parserConfig.doubleOperators, parserConfig.doubleDelimiters, parserConfig.tripleDelimiters,
            parserConfig.operators || /^([-+*/%\/&|^]=?|[<>=]+|\/\/=?|\*\*=?|!=)/]

        //字符串判定
        var stringPrefixes = new RegExp("^('{3}|\"{3}|['\"])", "i");
        // 标识符，可以是中文
        var identifiers = parserConfig.identifiers|| /^[_A-Za-z\u00A1-\uFFFF][_A-Za-z0-9\u00A1-\uFFFF]*/;
        var type, content;

        var myKeywords = commonKeywords, myBuiltins = commonBuiltins;

        function ret(tp, style, cont) {
            type = tp;
            content = cont;
            return style;
        }

        function tokenStringFactory(delimiter, tokenOuter) {
            var singleline = delimiter != "''";
            var OUTCLASS = "string";
            function tokenString(stream, state) {
                while (!stream.eol()) {
                    stream.eatWhile(/[^'"\\]/);
                    if (stream.eat("\\")) {
                        stream.next();
                        if (singleline && stream.eol())
                            return OUTCLASS;
                    } else if (stream.match(delimiter)) {
                        state.tokenize = tokenOuter;
                        return OUTCLASS;
                    } else {
                        stream.eat(/['"]/);
                    }
                }
                if (singleline) {
                    if (parserConfig.singleLineStringErrors)
                        return "error";
                    else
                        state.tokenize = tokenOuter;
                }
                return OUTCLASS;
            }
            tokenString.isString = true;
            return tokenString;
        }

        var keywords = wordRegexp(myKeywords);
        var builtins = wordRegexp(myBuiltins);

        function tokenBase(stream, state) {
            if (stream.eatSpace()) return null;
            var beforeParams = state.beforeParams;
            state.beforeParams = false;
            var ch = stream.next();
            // Handle Comments
            if (stream.match(/^\/\/.*/)) {
                return "comment";
            }
            if (ch == "/") {
                if (stream.eat("/")) {
                    stream.skipToEnd();
                    return ret("comment", "comment");
                }
            }

            // Handle Number Literals
            if (stream.match(/^[0-9\.]/, false)) {
                var floatLiteral = false;
                // Floats
                if (stream.match(/^[\d_]*\.\d+(e[\+\-]?\d+)?/i)) { floatLiteral = true; }
                if (stream.match(/^[\d_]+\.\d*/)) { floatLiteral = true; }
                if (stream.match(/^\.\d+/)) { floatLiteral = true; }
                if (floatLiteral) {
                    // Float literals may be "imaginary"
                    stream.eat(/J/i);
                    return "number";
                }
                // Integers
                var intLiteral = false;
                // Hex
                if (stream.match(/^0x[0-9a-f_]+/i)) intLiteral = true;
                // Binary
                if (stream.match(/^0b[01_]+/i)) intLiteral = true;
                // Octal
                if (stream.match(/^0o[0-7_]+/i)) intLiteral = true;
                // Decimal
                if (stream.match(/^[1-9][\d_]*(e[\+\-]?[\d_]+)?/)) {
                    // Decimal literals may be "imaginary"
                    stream.eat(/J/i);
                    // TODO - Can you have imaginary longs?
                    intLiteral = true;
                }
                // Zero by itself with no other piece of number.
                if (stream.match(/^0(?![\dx])/i)) intLiteral = true;
                if (intLiteral) {
                    // Integer literals may be "long"
                    stream.eat(/L/i);
                    return "number";
                }
            }
            // Handle Strings
            if (stream.match(stringPrefixes)) {
                state.tokenize = tokenStringFactory(stream.current(), state.tokenize);
                return state.tokenize(stream, state);
            }
            for (var i = 0; i < operators.length; i++)
                if (stream.match(operators[i])) return "operator"

            if (stream.match(delimiters)) return "punctuation";

            if (state.lastToken == "." && stream.match(identifiers))
                return "property";

            if (stream.match(keywords) || stream.match(wordOperators))
                return "keyword";

            if (stream.match(builtins))
                return "builtin";

            //处理标识符
            if (stream.match(identifiers)) {
                return "variable";
            }

            // Handle non-detected items
            stream.next();
            return "error";
        }

        function tokenLexer(stream, state) {
            if (stream.sol()) {
                state.beginningOfLine = true;
                state.dedent = false;
            }

            var style = state.tokenize(stream, state);
            var current = stream.current();

            if (/\S/.test(current)) state.beginningOfLine = false;

            if ((style == "variable" || style == "builtin")
                && state.lastToken == "meta")
                style = "meta";

            return style;
        }

        return {
            startState: function(basecolumn) {
                return {
                    tokenize: tokenBase,
                    scopes: [{offset: basecolumn || 0, type: "ssd", align: null}],
                    indent: basecolumn || 0,
                    lastToken: null,
                    lambda: false,
                    dedent: 0
                };
            },
            token: function(stream, state) {
                var addErr = state.errorToken;
                if (addErr) state.errorToken = false;
                var style = tokenLexer(stream, state);

                if (style && style != "comment")
                    state.lastToken = (style == "keyword" || style == "punctuation") ? stream.current() : style;
                if (style == "punctuation") style = null;
                return addErr ? style + " " + "error" : style;
            },
            lineComment: "//"
        };

    });

    CodeMirror.registerHelper("hint", "ssd", function(cm) {
        var hintList = commonKeywords.concat(commonBuiltins);

        var cur = cm.getCursor(),
            token = cm.getTokenAt(cur);
        var start = token.start,
            end = cur.ch
        var str = token.string

        var list = hintList.filter(function(item) {
            return item.indexOf(str) === 0
        })

        if (list.length) return {
            list: list,
            from: CodeMirror.Pos(cur.line, start),
            to: CodeMirror.Pos(cur.line, end)
        };
    });

    CodeMirror.defineMIME("text/x-ssd", "ssd");

});