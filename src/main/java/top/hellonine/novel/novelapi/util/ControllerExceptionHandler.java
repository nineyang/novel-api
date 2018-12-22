package top.hellonine.novel.novelapi.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.hellonine.novel.novelapi.exception.AuthException;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午5:48
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AuthException.class)
    public Object handlerAuth(Exception e) {
//        todo 这里的response 需要统一封装
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 401);
        jsonObject.put("message", e.getMessage());
        return jsonObject;
    }

}
