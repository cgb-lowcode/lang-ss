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