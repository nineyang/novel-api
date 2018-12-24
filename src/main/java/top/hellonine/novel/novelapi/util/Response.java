package top.hellonine.novel.novelapi.util;

import com.alibaba.fastjson.JSONObject;
import top.hellonine.novel.novelapi.config.ResponseStatus;

/**
 * User: Nine
 * Date: 2018/12/24
 * Time: 上午11:05
 */


public class Response {


    private JSONObject jsonObject = new JSONObject();


    public static Response factory() {
        return new Response();
    }

    public Response set(String key, Object value) {
        jsonObject.put(key, value);
        return this;
    }

    public JSONObject succeed() {
        jsonObject.put("code", ResponseStatus.SUCCEED.getCode());
        return jsonObject;
    }

    public JSONObject failed(String message) {
        jsonObject.put("code", ResponseStatus.FAILED.getCode());
        jsonObject.put("msg", message);
        return jsonObject;
    }

    public JSONObject failed(ResponseStatus status, String message) {
        jsonObject.put("code", status.getCode());
        jsonObject.put("msg", message);
        return jsonObject;
    }


    public JSONObject response(ResponseStatus status, Object object) {
        jsonObject.put("code", status.getCode());
        jsonObject.put("data", object);
        return jsonObject;
    }


}
