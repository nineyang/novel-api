package top.hellonine.novel.novelapi.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Nine
 * Date: 2019/1/9
 * Time: 下午3:13
 */


public class WxopenUtil {

    private static final String appId = "wx199f6d62b445e262";

    private static final String appSecret = "822e30ec5e8d25e910df3912a3248724";

    private static final String sessionApi = "https://api.weixin.qq.com/sns/jscode2session";

    public static String getOpenId(String code) throws Exception {
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("appid", appId);
        paramters.put("secret", appSecret);
        paramters.put("js_code", code);
        String content = CurlUtil.get(sessionApi, paramters);
        JSONObject jsonObject = JSON.parseObject(content);
        if (jsonObject.containsKey("errcode")) {
            throw new Exception(jsonObject.getString("errmsg"));
        }
        return jsonObject.getString("openid");
    }

}
