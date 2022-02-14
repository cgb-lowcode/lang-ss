package antlr.expr;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.json.JSONObject;
import cn.hutool.setting.SettingUtil;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataUtil {
    public final static String key_identifier = "GJKCODE";
    public final static Cache<String, Set<String>> IdentifierCache = CacheUtil.newFIFOCache(10000);
    public static void init(){
//        ScheduledExecutorService min5 = Executors.newScheduledThreadPool(1);
//        min5.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },0,5, TimeUnit.MINUTES);
        System.out.println("5 min job execute start ******");
        try{
            List<Entity> codes = Db.use("macro").query("select gjk_code from macro_base_index where is_publish='1'");
            Set<String> gjkcodes = IdentifierCache.get(key_identifier);
            if(gjkcodes == null){
                gjkcodes = CollUtil.newHashSet();
            }
            for(Entity row : codes){
                gjkcodes.add(row.getStr("gjk_code"));
            }
            IdentifierCache.put(key_identifier,gjkcodes);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("5 min job execute end ******");
    }

    public static boolean isGjkCode(String var){
        Set<String> gjkcodes = IdentifierCache.get(key_identifier);
        if(gjkcodes!=null){
            return gjkcodes.contains(var);
        }
        return false;
    }
    public static List getDataByGjkCode(String gjkCode){
        return getDataByGjkCode(gjkCode,"*",null,null);
    }

    public static List getDataByGjkCode(String gjkCode,String fields,String where,String order){
        try{
            Entity row = Db.use("macro").queryOne("select db_mod from macro_base_index where gjk_code=? and is_publish='1'",gjkCode);
            if(row!=null){
                int dbMod = row.getInt("db_mod");
                if(StrUtil.isNotEmpty(where)){
                    List list = Db.use("macro").query("select "+fields+" from macro_base_index_values_" + dbMod + " where gjk_code=? and "+where+" " + (StrUtil.isNotEmpty(order)?(" order by " + order):""),gjkCode);
                    return list;
                }else {
                    return Db.use("macro").query("select "+fields+" from macro_base_index_values_" + dbMod + " where gjk_code=? "+  (StrUtil.isNotEmpty(order)?(" order by " + order):""),gjkCode);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static int removeDataByGjkCode(String gjkCode,String where){
        try{
            Entity row = Db.use("macro").queryOne("select db_mod from macro_base_index where gjk_code=? and is_publish='1'",gjkCode);
            if(row!=null){
                int dbMod = row.getInt("db_mod");
                if(StrUtil.isNotEmpty(where)){
                    return Db.use("macro").execute("delete from macro_base_index_values_" + dbMod + " where gjk_code=? and "+where,gjkCode);
                }else {
                    return Db.use("macro").execute("delete from macro_base_index_values_" + dbMod + " where gjk_code=?",gjkCode);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public static int insertDataByGjkCode(String gjkCode, JSONObject params){
       //TODO:暂不实现
        return 0;
    }

    public static int  updateDataByGjkCode(String gjkCode, JSONObject params,String where){
        //TODO:暂不实现
        return 0;
    }

    public static List<Entity> query(String dsName,String sql,Object... params) throws SQLException {
        return Db.use(getDataSource(dsName)).query(sql,params);
    }

    public static Entity one(String dsName,String sql,Object... params) throws SQLException {
        return Db.use(getDataSource(dsName)).queryOne(sql,params);
    }

    public static int execute(String dsName,String sql,Object... params) throws SQLException {
        return Db.use(getDataSource(dsName)).execute(sql,params);
    }

    public static DataSource getDataSource(String name){
        if(Tools.dynaDataSources.containsKey(name)){
            return Tools.dynaDataSources.get(name);
        }
        if(DSFactory.get(name)!=null){
            return DSFactory.get(name);
        }
        return DSFactory.get("default");
    }
}
