## 概述

在线体验地址：http://coding.sumslack.com

有时，我们需要自定义语法，比如做一个聪明的搜索，中间层查询语句，特定领域语法等。我们希望在SDP**智能搜索**中实现以下功能：
- 如果你输入的关键字：直接跳转到查询结果，如：进出口
- 如果你输入的是一个计算表达式：直接给出计算结果，如3+sin(PI/6)，输出3.5
- ......

ss语言基于`antlr4`实现，可以在此基础上方便的扩展语法，ss语言为数据处理量身打造：

1. 为组件/低代码平台做基础：有了简洁的数据处理语法，实现组件可视化才会变得更加容易；
1. 为业务量身打造，简化语法，更面向自然语言，为形成自己业务文法规则提供无限可能
1. 更安全，将潜在安全问题在语法树中解决，不用等到运行期

在线体验地址：http://coding.sumslack.com

```
//直接拉取指标数据
CSE2D00102
//筛选指标数据的字段列表和条件
CSE2D00102.select('index_date,index_value',index_value<>null)
//获取一条指标数据
CSE2D00102.one('index_date,index_value',index_date=='1998-10-06').index_value
//删除test23表id为aaa的数据
test23.delete({},id=='aaa')
//插入test23表一行数据
test23.insert({'id':'aaa','f1':'abcd'})
//更新test23表id为aaa的数据
test23.update({'f1':'dddd'},id=='aaa')
//多数据源，default数据源下test23表id为aaa的数据
default.execute("update test23 set f1='eeee' where id='aaa'")
print(test23.select('*',id=='aaa'))
```