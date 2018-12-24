package top.hellonine.novel.novelapi.util;

import com.alibaba.fastjson.JSONObject;
import top.hellonine.novel.novelapi.config.ResponseStatus;

/**
 * User: Nine
 * Date: 2018/12/24
 * Time: 上午11:05
 */


public class Response {


    private static JSONObject jsonObject;

    private static int code;

    private static Object data;

    static {
        jsonObject = new JSONObject();
    }

    public static Response factory() {
        return new Response();
    }

    public Response set(String key, Object value) {
        jsonObject.clear();
        jsonObject.put(key, value);
        return this;
    }

    public static JSONObject succeed(Object data) {
        jsonObject.clear();
        jsonObject.put("code", ResponseStatus.SUCCEED.getCode());
        jsonObject.put("data", data);
        return jsonObject;
    }

    public static JSONObject failed(String message) {
        jsonObject.put("code", ResponseStatus.FAILED.getCode());
        jsonObject.put("msg", message);
        return jsonObject;
    }

    public static JSONObject response(ResponseStatus status, Object object) {
        jsonObject.clear();
        jsonObject.put("code", status.getCode());
        jsonObject.put("data", object);
        return jsonObject;
    }


}
