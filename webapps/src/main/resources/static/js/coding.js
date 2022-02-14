//var wsUrl = "ws://192.168.10.32:7778/websocket";
var wsUrl = "ws://coding.sumslack.com/websocket";
var editor;
var wsTimer = null;
var REGX_HTML_ENCODE = /"|&|'|<|>|[\x00-\x20]|[\x7F-\xFF]|[\u0100-\u2700]/g;
var REGX_HTML_DECODE = /&\w+;|&#(\d+);/g;
function loadDemo(fileName){
    get('/mock/' + fileName + ".js",text =>{
        editor.setValue(text);
    });;
}
function encodeHtml(s) {
    return (typeof s != "string") ? s :
    s.replace(REGX_HTML_ENCODE,
        function($0){
            var c = $0.charCodeAt(0), r = ["&#"];
            c = (c == 0x20) ? 0xA0 : c;
            r.push(c); r.push(";");
            return r.join("");
        });
}
function decodeHtml(s){
    return (typeof s != "string") ? s :
        s.replace(REGX_HTML_DECODE,
            function($0,$1){
                var c = this.HTML_ENCODE[$0]; // 尝试查表
                if(c === undefined){
                    // Maybe is Entity Number
                    if(!isNaN($1)){
                        c = String.fromCharCode(($1 == 160) ? 32 : $1);
                    }else{
                        // Not Entity Number
                        c = $0;
                    }
                }
                return c;
            });
}
//控制台输出结果
function showResult(msg,tag){
    if(typeof(tag) === "undefined") tag = "";
    var log = document.getElementById("log_result");
    var p=document.createElement('li');
    var timeStr = new Date().toLocaleTimeString();
    p.innerHTML = timeStr + "： " + encodeHtml(msg);
    var color = "#111";
    if(tag === "error"){
        color = "#dc3545";
    }else if(tag === "info"){
        color = "#04cafa";
    }else if(tag === "result"){
        color = "#499c54;font-weight:bold";
    }else if(tag === "print"){
        color = "#8d8e3e";
    }else if(tag === "warning"){
        color = "#ffc107";
    }else{
        color = "#000";
    }
    p.setAttribute("style","color:" + color + "");
    log.appendChild(p);
    log.scrollTop = log.scrollHeight;
}

function post(url, data, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(data));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            callback(xhr.responseText);
        }
    }
}

function get(url,callback) {
    var xhr=null;
    if(XMLHttpRequest){
        xhr=new XMLHttpRequest();
    }else{
        xhr=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhr.open('get',url,true);
    //发出请求
    xhr.send(null);
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status == 200) {
            if(typeof callback != "undefined"){
                callback(xhr.responseText);
            }
        }
    }
}

function validation(callback){
    if(editor && editor.doc) {
        var vv = editor.getValue();
        post('/coding/validation', {code: vv}, function (data) {
            if (typeof (data) === "string") {
                data = JSON.parse(data);
            }
            if(typeof(callback)!="undefined"){
                callback(data);
            }
        });
    }
}

function _buildLintFunction(){
    return function (text, updateLinting, options, editor){
        if(text===''){
            updateLinting(editor,[]);
            return;
        }
        if(!text || text===''){
            return;
        }
        validation(data => {
            var result = data.result;
            if(result){
                for(let item of result){
                    item.from={line:item.line-1};
                    item.to={line:item.line-1};
                }
                updateLinting(editor,result);
            }else{
                updateLinting(editor,[]);
            }
        });

    };
}

function run(){
    document.getElementById("log_result").innerHTML = '';
    var vv = editor.getValue();
    post('/coding/run', {code:vv,params:document.getElementById("context_vars").value}, function (data) {
        if(typeof(data) === "string"){
            data = JSON.parse(data);
        }
        if(data.code == 200 && data.success){
            if(data.result === null){
                showResult("输出结果：null",'result');
            }else{
                var res = data.result.data;
                if(typeof(res) === "object"){
                    res = JSON.stringify(res);
                }
                res = "输出结果：" + res;
                showResult(res,'result');
            }
        }else{
            showResult(data.message,'error');
        }
    });
}

document.body.onload = function(){
    //接入WS
    var websocket = new WebSocket(wsUrl);
    websocket.onopen = function(evt) {
        showResult("连接上websocket，可以正常调试运行程序了!!!");
        // clearInterval(wsTimer);
        // wsTimer = null;
    };
    websocket.onclose = function(evt) {
        showResult("断开了websocket，脚本运行期错误和打印功能将无法使用！","warning");
        //5秒重连
        // if(wsTimer == null){
        //     wsTimer = setInterval(()=>{
        //         websocket = new WebSocket(wsUrl);
        //     },5000);
        // }
    };
    websocket.onmessage = function(evt) {
        var data = JSON.parse(evt.data);
        showResult(data.msg + "",data.tag+ "","info");
    };
    websocket.onerror = function(evt) {
        showResult("websocket错误，脚本运行期错误和打印功能将无法使用！","warning");
    };

    setTimeout(()=>{
        editor = CodeMirror(document.getElementById("code"), {
            theme: "idea",
            extraKeys: { "Alt-/": "autocomplete" },
            lineNumbers: true,
            gutters: ["CodeMirror-linenumbers", "CodeMirror-lint-markers"],
            matchBrackets: true,
            mode: "text/x-ssd",
            lint: {
                getAnnotations:_buildLintFunction(),
                async:true
            }
        });

        //设置为只读
        //editor.setOption("readOnly", true);
        var hh = screen.availHeight - 350;
        editor.setSize('100%', hh + 'px');
        editor.on('change',function(cm,changes){
            let expr=cm.getValue();
        });

        //editor.setValue("print(1)\nprint(2)\n1+2");
        loadDemo('dataset');
    },100);
}