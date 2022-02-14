lexer grammar SSLexer;

INTEGER: ('-')?DIGIT+;
DIGIT : [0-9];
NEWLINE:'\r'? '\n' ;//return newlinesto parser(end-statement signal)
WS : [ \t]+ -> skip ;

Opertion: ADD
        |MINUS
        |STAR
        |DIV
        |MOD
        ;
OP : GREATER_THAN
   | LESS_THAN
   | EQUALS
   | NOT_EQ_1
   | NOT_EQ_2
   | GT_EQ
   | LT_EQ
   | 'like'
   | 'not like'
   ;

LESS_THAN : '<';
GREATER_THAN : '>';
EQUALS : '==';
GT_EQ : '>=';
LT_EQ : '<=';
NOT_EQ_1 : '<>';
NOT_EQ_2 : '!=';

STAR : '*';
ADD : '+';
MINUS : '-';
DIV : '/';
MOD : '%';

AND : 'and' | '&&' ;
OR : 'or' | '||' ;

fragment
StartChar
            :   [a-zA-Z]
            |   '\u2070'..'\u218F'
            |   '\u2C00'..'\u2FEF'
            |   '\u3001'..'\uD7FF'
            |   '\uF900'..'\uFDCF'
            |   '\uFDF0'..'\uFFFD'
            ;
STRING : STRING_LITERAL;

STRING_LITERAL
 : ( [rR] | [uU] | [fF] | ( [fF] [rR] ) | ( [rR] [fF] ) )? ( SHORT_STRING | LONG_STRING )
 ;
fragment SHORT_STRING
 : '\'' ( STRING_ESCAPE_SEQ | ~[\\\r\n\f'] )* '\''
 | '"' ( STRING_ESCAPE_SEQ | ~[\\\r\n\f"] )* '"'
 ;
/// longstring      ::=  "'''" longstringitem* "'''" | '"""' longstringitem* '"""'
fragment LONG_STRING
 : '\'\'\'' LONG_STRING_ITEM*? '\'\'\''
 | '"""' LONG_STRING_ITEM*? '"""'
 ;
/// longstringitem  ::=  longstringchar | stringescapeseq
fragment LONG_STRING_ITEM
 : LONG_STRING_CHAR
 | STRING_ESCAPE_SEQ
 ;
/// stringescapeseq ::=  "\" <any source character>
fragment STRING_ESCAPE_SEQ
 : '\\' .
 | '\\' NEWLINE
 ;

/// longstringchar  ::=  <any source character except "\">
fragment LONG_STRING_CHAR
 : ~'\\'
 ;

fragment
STRING_CONTENT :
	( EscapeSequence | ~('"'|'\''))*
;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;
fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
:
	'\\' 'u' HEX HEX HEX HEX
;
fragment
HEX
:
	[0-9a-fA-F]
;

LETTER : [A-Z]+ ;
NUMBER
:
	'-'? DIGIT+ '.' DIGIT+ EXP? // ('-'? INT '.' INT EXP?)1.35, 1.35E-9, 0.3, -4.5
	| '-'? DIGIT+ EXP // 1e10 -3e4
	| '-'? DIGIT+ // -3, 45
;
INT : [0-9]+ ; // match integers
EXP
:
	[Ee] [+\-]? DIGIT+
;
Char    :   StartChar
            |   '-' | '_' | DIGIT
            |   '\u00B7'
            |   '\u0300'..'\u036F'
            |   '\u203F'..'\u2040'
            ;

NULL : 'null';
LeftParen : '(' ;
RightParen : ')' ;
LEFTBLOCK: '{' ;
RIGHTBLOCK: '}' ;
ARROW:'->';
BOOLEAN : 'true' | 'false' ;
Identifier : StartChar Char* ;
IMAG_NUMBER
 : ( NUMBER | INTEGER ) [jJ]
 ;
ORDER : 'desc' | 'asc' ;

SKIP_
 : ( SPACES | COMMENT | LINE_JOINING ) -> skip
 ;
fragment SPACES
 : [ \t]+
 ;
fragment LINE_JOINING
 : '\\' SPACES? ( '\r'? '\n' | '\r' | '\f')
 ;
fragment COMMENT
 : '//' ~[\r\n\f]*
 | '/*' .*? '*/'
 ;
