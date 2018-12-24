package top.hellonine.novel.novelapi.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.hellonine.novel.novelapi.config.ResponseStatus;
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
        return Response.factory().failed(ResponseStatus.UNAUTHORIZED, e.getMessage());
    }

}
