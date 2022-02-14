// 正则解析
var rere = '''
RegExr was created by gskinner.com and is proudly hosted by Media Temple.
    Edit the Expression & Text to see matches. Roll over matches or the expression for details. PCRE & JavaScript flavors of RegEx are supported. Validate your expression with Tests mode.
    The side bar includes a Cheatsheet, full Reference, and Help. You can also Save & Share with the Community and view patterns you create or favorite in My Patterns.
    Explore results with the Tools below. Replace & List output custom results. Details lists capture groups. Explain describes your expression in plain English.
'''
// 正则查找
re(rere,'(?<aaa>x.*?n)')
// 字符串替换
re(rere,'(?<aaa>x.*?n)','aaaaaaa')
// xpath解析
html = '''
<div id="test">
    <span>hello</span>
    <span>hello2</span>
    <table id="t1"><tr><td>00</td><td>01</td></tr><tr><td>10</td><td>11</td></tr></table>
<table id="t2"><tr><td colspan="2">00000</td></tr><tr><td>10</td><td>11</td></tr></table>
</div>
'''
print(xpath(html,"//div/span")[1])
print(xpath(html,{
    "target":"table",
    "xpath":"//table[@id='t2']"
})[1][1])
JSON对象 = {
    "store": {
        "book": [{
            "category": "reference",
            "author": "Nigel Rees",
            "title": "Sayings of the Century",
            "price": 8.95
        }, {
            "category": "fiction",
            "author": "J. R. R. Tolkien",
            "title": "The Lord of the Rings",
            "isbn": "0-395-19395-8",
            "price": 22.99
        }
        ],
        "bicycle": {
            "color": "red",
            "price": 19.95
        }
    }
}
//所有book的author节点
print(jsonpath(JSON对象,'$.store.book[*].author'))
//所有author节点
print(jsonpath(JSON对象,'$..author'))
//store下的所有节点，book数组和bicycle节点
print(jsonpath(JSON对象,'$.store.*'))
//匹配第3个book节点
print(jsonpath(JSON对象,'$..book[2]'))
//匹配倒数第1个book节点
print(jsonpath(JSON对象,'$..book[-1:]'))
//	过滤含isbn字段的节点
print(jsonpath(JSON对象,'$..book[?(@.isbn)]'))
//过滤price<10的节点
print(jsonpath(JSON对象,'$..book[?(@.price<10)]'))