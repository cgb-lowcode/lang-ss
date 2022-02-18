### 概述
`ss语言`是一门针对数据操作的脚本语言，可以方便的操控数据集。在线测试地址：http://coding.sumslack.com/

### 语法
#### 基础语法

- 类型：字符串，整数，浮点数，布尔值，JSON对象，数组
```
//JSON的灵活操控
aaa = {"aa":12,"bb":"bb","cc":{"xx":12}}
aaa['aa'] = "hhhh"
print(aaa)
aaa.aa = "iiiii"
print(aaa)
aaa.cc.xx = "2222"
print(aaa)
bb = [{"aa":12,"bb":"bb","cc":{"xx":12}},{"aa":13,"bb":"34342","cc":{"xx":23}}]
bb[0].aa='hhh'
print(bb)
bb[0]={"hh":12}
print(bb)
/***
下午2:40:00： {"aa":"hhhh","bb":"bb","cc":{"xx":12}}
下午2:40:00： {"aa":"iiiii","bb":"bb","cc":{"xx":12}}
下午2:40:00： {"aa":"iiiii","bb":"bb","cc":{"xx":"2222"}}
下午2:40:00： [{"aa":12,"bb":"bb","cc":{"xx":12},"0":"hhh"},{"aa":13,"bb":"34342","cc":{"xx":23}}]
下午2:40:00： [{"hh":12},{"aa":13,"bb":"34342","cc":{"xx":23}}]
***/
```
- 字符串可以是单引号或双引号，或多行`'''多行内容'''，"""多行内容"""`
- 常量：**PI**，**EB**，**EE**，**MIU**
- 运算符：**+**，**-**，*****，**/**，**%**(取余)
- 空处理运算符：`a.b.c??"aa"`，如果`a`或`a.b`为空时返回aa字符串
- 赋值：**+=**，**-=**，***/**，**%/**，**++**，**--**
- 逻辑判断：**==**，**!=**，**<**，**<=**，**>**，**>=**，**in**，**like**，**not in**，**not like**
```
//in，not in逻辑判断可以用在JSON对象上
aa = {"a":11}
//输出true
print("a" in aa)
```
- 逻辑运算：**&&**(**and**)，**||**(**or**)，**!**(**not**)
- 三元运算：条件判定?"为真返回":"为假返回"
- 基础语法：**if**-**else if**-**else**，**for** **([变量,]?变量 **:** 列表){代码块}，列表.**each**(变量 -> {代码块})
```
arr = [1,2,3]
if(1 in aaa){
	print("1 is in [1,2,3]")
}else{
	print("1 is not in [1,2,3]")
}
//输出1,2,3
for(item : arr){
	print(item)
}
//输出0==>1,1==>2,2==>3
for(index,item : arr){
	print(index,"==>",item)
}
```
- 内置函数：**print**，**list**，**range**，**math**，**jsonpath**，**xpath**等

#### 解析数据
提供解析函数：
- re函数：针对字符串：`re(字符串,正则表达式)，如re('hello,xin','(?<aaa>x.*?n)')`
- jsonpath：针对JSON对象或JSON数组或任意Java对象（会自动转JSON格式）：如：`jsonpath(JSON对象,'$.store.book[*].author')`
- xpath：针对HTML字符串，如：`xpath(html,"//div/span")[1]`

#### 数据集
以下**数据源名**部分可省略不写，表示从默认数据源中查找。
- 返回表名信息或指标信息：
```
数据源名.表名.info()
```
- 查找数据：
```
数据源名.表名.[select,查询,查找,query,find]('字段列表',条件列表，'排序列表')
```
- 分页查找数据：**其中页码从0开始**
```
数据源名.表名.[page,paginate,分页]('字段列表',条件列表，'排序列表'，页码，每页记录数)
```
- 单行超找数据：
```
数据源名.表名.[one,queryOne]('字段列表',条件列表，'排序列表')
```
- 行业指标数据：直接输入指标代码，如`CSE2D00102`，也可以使用select函数获取指定结果：
```
CSE2D00102.select('index_date,index_value',index_value<>null)
CSE2D00102.one('index_date,index_value',index_date=='1998-10-06').index_value
```
- 数据源数据DML操作：
```
//删除test23表id为aaa的数据
test23.[delete,删除](id=='aaa')
//插入test23表一行数据
test23.[insert,插入,新增]({'id':'aaa','f1':'abcd'})
//更新test23表id为aaa的数据
test23.[update,更新,保存]({'f1':'dddd'},id=='aaa')
```
- 执行SQL：
```
数据源名.表名.[execute,执行](SQL语句，参数列表)
```

