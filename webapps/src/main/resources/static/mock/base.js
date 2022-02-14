//注释测试
aa = (5+1)*2+(1+3)
print(aa)
bb = (1+2)*3%4
print(bb)
cc = true and 4>2
print(cc)
// 支持JSON和JSON数组
var json = {'a':1}
print(json)
var jsonArr = [{'aa':1},{'aa':2}]
print(jsonArr,jsonArr[1].aa)
// 逻辑运算，支持三元运算符
dd = (3>2?"3>2":"2<=3")
print(dd)
// 常量
print(PI,EB,EE,MIU)
测试 = 2
测试 += 3
print(测试)
// 函数调用
ff = math('sin',PI/6)
print(ff)
gg = 12.23
// 支持if-else if-else语法
if(gg >10){
    if(gg<=12){
        print("10<gg<=12")
    }else if(gg<=13){
        print("10<gg<=13")
    }else{
        print("10<gg")
    }
}else{
    print("gg<=10")
}
// 支持循环
for(item in list('a','b',3.12,{"xx":12})){
    print(item)
}
list('a','b',3.12,{"xx":12}).each(item -> {
    print("item:",item)
})
range(1,10,2).each(item -> print(item))
