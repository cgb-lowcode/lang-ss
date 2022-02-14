package antlr.expr;

import antlr.CalException;
import antlr.expr.antlr4.SSTree;
import antlr.expr.builder.Assertor;
import antlr.expr.builder.ExpressionBuilder;
import antlr.expr.func.Function;
import antlr.model.Op;
import antlr.model.Operator;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.*;

public class Tools {
    public static List<ExpressionBuilder> expressionBuilders;
    public static List<SSTree> antlr_expressions =new ArrayList<SSTree>();
    public static Map<Op, Assertor> assertorsMap=new HashMap<Op,Assertor>();
    //初始化内置函数列表
    public static Map<String, Function> functions=new HashMap<String,Function>();
    //动态数据源源名
    public static Map<String, DataSource> dynaDataSources = new HashMap();
    static{
        expressionBuilders =new ArrayList<ExpressionBuilder>();
        Set<Class<?>> buildClasses = ClassUtil.scanPackage("antlr.expr.builder.impl");
        for(Class cls : buildClasses){
            expressionBuilders.add((ExpressionBuilder) ReflectUtil.newInstance(cls));
        }

        Set<Class<?>> buildClasses2 = ClassUtil.scanPackage("antlr.expr.builder.op");
        for(Class cls : buildClasses2){
            Assertor a = (Assertor) ReflectUtil.newInstance(cls);
            assertorsMap.put(a.getName(),a);
        }

        Set<Class<?>> funcClasses = ClassUtil.scanPackage("antlr.expr.func.impl");
        for(Class cls : funcClasses){
            Function f = (Function)ReflectUtil.newInstance(cls);
            functions.put(f.name(),f);
        }

        Set<Class<?>> ssTreeClasses = ClassUtil.scanPackage("antlr.expr.antlr4.impl");
        for(Class cls : ssTreeClasses){
            SSTree f = (SSTree)ReflectUtil.newInstance(cls);
            antlr_expressions.add(f);
        }

        //加载动态数据源
        try {
            List<Entity> datasourceList = Db.use("datacoding").query("select name,db_user,db_pass,db_url from ss_data_source where deflag<>1");
            for(Entity row : datasourceList){
                DruidDataSource ds2 = new DruidDataSource();
                ds2.setUrl(Convert.toStr(row.get("db_url")));
                ds2.setUsername(Convert.toStr(row.get("db_user")));
                ds2.setPassword(Convert.toStr(row.get("db_pass")));
                dynaDataSources.put(Convert.toStr(row.get("name")),ds2);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static BigDecimal toBigDecimal(Object obj)  {
        if(obj==null){
            return null;
        }
        if(obj instanceof BigDecimal){
            return (BigDecimal)obj;
        }else if(obj instanceof String){
            if(obj.toString().trim().equals("")){
                return new BigDecimal(0);
            }
            try{
                String str=obj.toString().trim();
                return new BigDecimal(str);
            }catch(Exception ex){
                throw new CalException("Can not convert "+obj+" to BigDecimal.");
            }
        }else if(obj instanceof Number){
            Number n=(Number)obj;
            return new BigDecimal(n.doubleValue());
        }
        throw new CalException("Can not convert "+obj+" to BigDecimal.");
    }

    public static boolean conditionEval(Op op,Object left,Object right)  {
        Assertor assertor=assertorsMap.get(op);
        boolean result=assertor.eval(left, right);
        return result;
    }

    public static Object operatorObj(Object obj, Object obj1, Operator op)  {
        if(obj==null || obj1==null) return null;
        if(op == Operator.Add){
            if(obj instanceof String || obj1 instanceof String){
                return Convert.toStr(obj) + Convert.toStr(obj1);
            }else if(obj instanceof Integer || obj1 instanceof Integer){
                return Convert.toInt(obj) + Convert.toInt(obj1);
            }else{
                try{
                    return Convert.toDouble(obj) + Convert.toDouble(obj1);
                }catch(Exception ex){
                    throw new CalException("不支持的运算符！！！" + Convert.toStr(obj) + op.toString() + Convert.toStr(obj1));
                }
            }
        }else if(op == Operator.Subtract){
            if(obj instanceof Integer || obj1 instanceof Integer){
                return Convert.toInt(obj) - Convert.toInt(obj1);
            }else{
                try{
                    return Convert.toDouble(obj) - Convert.toDouble(obj1);
                }catch(Exception ex){
                    throw new CalException("不支持的运算符！！！" + Convert.toStr(obj) + op.toString() + Convert.toStr(obj1));
                }
            }
        }else if(op == Operator.Multiply){
            if(obj instanceof Integer || obj1 instanceof Integer){
                return Convert.toInt(obj) * Convert.toInt(obj1);
            }else{
                try{
                    return Convert.toDouble(obj) * Convert.toDouble(obj1);
                }catch(Exception ex){
                    throw new CalException("不支持的运算符！！！" + Convert.toStr(obj) + op.toString() + Convert.toStr(obj1));
                }
            }
        }else if(op == Operator.Divide){
            if(obj instanceof Integer || obj1 instanceof Integer){
                return Convert.toInt(obj) / Convert.toInt(obj1);
            }else{
                try{
                    return Convert.toDouble(obj) / Convert.toDouble(obj1);
                }catch(Exception ex){
                    throw new CalException("不支持的运算符！！！" + Convert.toStr(obj) + op.toString() + Convert.toStr(obj1));
                }
            }
        }else if(op == Operator.Complementation){
            if(obj instanceof Integer || obj1 instanceof Integer){
                return Convert.toInt(obj) % Convert.toInt(obj1);
            }else{
                throw new CalException("不支持的运算符！！！" + Convert.toStr(obj) + op.toString() + Convert.toStr(obj1));
            }
        }
        throw new CalException("不支持的运算符！！！" + Convert.toStr(obj) + op.toString() + Convert.toStr(obj1));
    }
}
