package top.hellonine.novel.novelapi.interceptor;

import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.hellonine.novel.novelapi.annotation.LoginRequired;
import top.hellonine.novel.novelapi.entity.UserEntity;
import top.hellonine.novel.novelapi.exception.AuthException;
import top.hellonine.novel.novelapi.service.UserService;
import top.hellonine.novel.novelapi.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午6:08
 */


public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();
        if (!(method.isAnnotationPresent(LoginRequired.class))) {
            return true;
        }

        String token = request.getHeader("token");
        if (token == null) {
            throw new AuthException("token is not found.");
        }

        Long userId = JwtUtil.getUserId(token);
        UserEntity user = userService.getById(userId);
        if (user == null) {
            throw new AuthException("user not found.");
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
