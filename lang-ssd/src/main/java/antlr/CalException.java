package antlr;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.SettingUtil;

import java.util.Map;

public class CalException extends RuntimeException{

    private static final String postUrl = SettingUtil.get("db").getStr("wsUrl");

    public static void log(String tag,String msg){
        Map param = MapUtil.newHashMap();
        param.put("tag",tag);
        param.put("msg",msg);
        String body = JSONUtil.toJsonStr(param);
        String ret = "";
        try {
            ret = HttpUtil.post(postUrl, body, 5000);
            System.out.println(postUrl + ":" + ret);
        }catch(Exception ex){
            //ex.printStackTrace();
            System.out.println("#######msg:" + msg);
        }

    }

    public CalException(String msg) {
        super(msg);
        log("error",msg);
    }
    public CalException(Exception ex) {
        super(ex);
        log("error", ExceptionUtil.getMessage(ex));
    }
}
