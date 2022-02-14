import antlr.CalException;
import antlr.expr.DataUtil;
import antlr.expr.ParseExprUtil;
import antlr.expr.expr.ElCompute;
import antlr.expr.expr.Expr;
import antlr.expr.listens.PurviewListener;
import antlr.model.ErrorInfo;
import antlr.model.data.ExprData;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import main.MyExprContext;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExprTest extends TestCase {
    private static Map<String,Object> params = new HashMap();
    private static MyExprContext context = new MyExprContext();

    @Override
    protected void setUp() throws Exception {
        params.put("title","外部变量值测试");
        context.setParameters(params);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    //通过语法树解析出对应元素，可以供前端做代码自动提示用
    @Test
    public void testTree(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        //最后一条语句作为返回值
        ParseExprUtil.walkTree("aa=1\nbb=2\nmath('aa')\ntest23.select('f1')");
        System.out.println(CollUtil.join(PurviewListener.vars,","));
        System.out.println(CollUtil.join(PurviewListener.functions,","));
        System.out.println(CollUtil.join(PurviewListener.aggregations,","));
    }

    //四则运算
    @Test
    public void testExprBase()  {
        Expr expression= null;
        ExprData result = null;
        String data = null;
        //最后一条语句作为返回值
        expression= ParseExprUtil.parseExpression("//单行测试\n1+2*3");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals("7",data);

        expression = ParseExprUtil.parseExpression("(1+2)*3%4");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals("1",data);

        expression = ParseExprUtil.parseExpression("\n\n\n3+2*5+(2+1)*2");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("result:" + data);
        assertEquals("19",data);
    }

    //逻辑运算
    @Test
    public void testExprLogic(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("true and (3>2)");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals("true",data);
        expression=ParseExprUtil.parseExpression("2<4 and 3>2");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals("true",data);
        expression=ParseExprUtil.parseExpression("2>4 and 3>2");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals("false",data);
    }

    //测试常亮表
    @Test
    public void testConsts(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("PI/2");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("pi/2:"+data);
        expression=ParseExprUtil.parseExpression("EE");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("EE:"+data);
        expression=ParseExprUtil.parseExpression("EB");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("EB:"+data);
        expression=ParseExprUtil.parseExpression("MIU");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("MIU:"+data);
    }

    //自加运算
    @Test
    public void testReAssign(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        String expr = "测试=2\n测试+=3\n测试";
        expression=ParseExprUtil.parseExpression(expr);
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("reAssignTest:"+data);
    }
    //测试自定义函数
    @Test
    public void testFuncs(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("math('sin',PI/6)");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("result:"+data);
    }

    //if和三元运算符测试
    @Test
    public void testIf(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("测试=3"+"\n"+
                                                      "if(测试>2){\n" +
                                                            "3+2\n" +
                                                      "}else if(测试<5){\n" +
                "                                           5\n" +
                "                                     }else {\n" +
                "                                           3\n" +
                                                      "}");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals("5",data);

        expression=ParseExprUtil.parseExpression("测试=3"+"\n测试<2?'<2':'>=2'");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        assertEquals(">=2",data);
    }
    @Test
    public void testForIn(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("result = '开始'\n" +
                "for(item in list('a','b','c')){" +
                    "result = result + '=>' + item\n" +
                "}\nresult");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("result:"+data);
    }

    @Test
    public void testEach(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("result=0\nlist(11,22,33).each(item -> result=result+item)\nresult");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("result:"+data);
        assertEquals("66",data);
    }
    @Test
    public void testComplex(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("2*math('sin',PI/6)+(1 - 2)*3");
        result = expression.run(context);
        data =  Convert.toStr(result.getData());
        System.out.println("result:"+data);
    }

    @Test
    public void testJson(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
//        expression=ParseExprUtil.parseExpression("{\"a\":12,\"b\":\"aa\"}");
//        result = expression.run(context);
//        JSONObject json = (JSONObject)result.getData();
//        assertEquals("aa",json.getStr("b"));
        //访问属性值
        expression=ParseExprUtil.parseExpression("测试 = {\"aa\":12,\"dd\":{\"test\":1},\"b\":\"aa\"}\n测试.dd.test");
        result = expression.run(context);
        System.out.println(result.getData().toString());
        assertEquals("1",result.getData().toString());
    }

    @Test
    public void testJsonArray(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("[1,2,3]");
        result = expression.run(context);
        JSONArray arr = (JSONArray)result.getData();
        assertTrue(2==Convert.toInt(arr.get(1)));
        expression=ParseExprUtil.parseExpression("[{\"a\":12,\"b\":\"aa\"},{\"a\":15}]");
        result = expression.run(context);
        arr = (JSONArray)result.getData();
        assertEquals(15,arr.getJSONObject(1).getInt("a").intValue());
        //访问某个元素
        expression=ParseExprUtil.parseExpression("测试=[{\"aa\":12,\"b\":\"aa\"},{\"aa\":15}]\n测试[0].aa");
        result = expression.run(context);
        System.out.println("result:" + JSONUtil.toJsonStr(result));
        //assertEquals("{\"a\":15}",result.getData().toString());
    }

    @Test
    public void testEI(){
        long start=System.currentTimeMillis();
        String expr="3+2*5+(2+1)*2";
        ElCompute el=new ElCompute();
        Object data=el.doCompute(expr);
        System.out.println("result:" + data);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    @Test
    public void testValidation(){
        List<ErrorInfo> errors = ParseExprUtil.validation("aa!");
        assertNotNull(errors);
        System.out.println(JSONUtil.toJsonStr(errors));
    }

    @Test
    public void testDataset(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("test23.select('id',ii>10 and delflag=='1')");
        result = expression.run(context);
        System.out.println("reulst:" + JSONUtil.toJsonStr(result.getData()));
    }

    @Test
    public void testMacroIndex() throws Exception{
        DataUtil.init();

        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("CSE2D00102");
        result = expression.run(context);
        System.out.println("result 1:" + StrUtil.brief(JSONUtil.toJsonStr(result.getData()),100));

        expression=ParseExprUtil.parseExpression("CSE2D00102.select('index_date,index_value',index_value<>null)");
        result = expression.run(context);
        System.out.println("result 2:" + StrUtil.brief(JSONUtil.toJsonStr(result.getData()),100));

        expression=ParseExprUtil.parseExpression("CSE2D00102.one('index_date,index_value',index_date=='1998-10-06').index_value");
        result = expression.run(context);
        System.out.println("result 3:" + result.getData());
    }

    @Test
    public void testDatasetDML() throws Exception{
        Expr expression= null;
        ExprData result = null;
        String data = null;

        expression=ParseExprUtil.parseExpression("test23.delete({},id=='aaa')");
        result = expression.run(context);
        System.out.println("result 1:" + result.getData());
        expression=ParseExprUtil.parseExpression("test23.insert({'id':'aaa','f1':'abcd'})");
        result = expression.run(context);
        System.out.println("result 2:" + result.getData());
        expression=ParseExprUtil.parseExpression("test23.update({'f1':'dddd'},id=='aaa')");
        result = expression.run(context);
        System.out.println("result 3:" + result.getData());
        expression=ParseExprUtil.parseExpression("default.execute(\"update test23 set f1='eeee' where id='aaa'\")");
        result = expression.run(context);
        System.out.println("result 4:" + result.getData());

    }

    @Test
    public void testJsonpath(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("测试=test23.select('*')\njsonpath(测试,'$..ii')");
        result = expression.run(context);
        System.out.println("reulst:" + JSONUtil.toJsonStr(result.getData()));
    }

    @Test
    public void testIncDec(){
        Expr expression= null;
        ExprData result = null;
        String data = null;
        expression=ParseExprUtil.parseExpression("测试=10\n测试++");
        result = expression.run(context);
        assertEquals("11",Convert.toStr(result.getData()));
        expression=ParseExprUtil.parseExpression("aaa=true\n!aaa");
        result = expression.run(context);
        assertEquals("false",Convert.toStr(result.getData()));
    }

    @Test
    public void testSave(){
        String expr = "range(1,10).each(item -> test23.insert({\"id\":(\"bb测试\"+item)}))";
        Expr expression= null;
        ExprData result = null;

        expression=ParseExprUtil.parseExpression("test23.delete({},id like 'bb测试%')");
        result = expression.run(context);
        System.out.println("result 1:" + result.getData());

        expression=ParseExprUtil.parseExpression(expr);
        result = expression.run(context);
        System.out.println("reulst:" + JSONUtil.toJsonStr(result.getData()));
    }

}
