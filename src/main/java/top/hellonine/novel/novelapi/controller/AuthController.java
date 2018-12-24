package top.hellonine.novel.novelapi.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.hellonine.novel.novelapi.entity.UserEntity;
import top.hellonine.novel.novelapi.mapper.UserMapper;
import top.hellonine.novel.novelapi.service.UserService;
import top.hellonine.novel.novelapi.util.Response;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午10:23
 */

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object login(@RequestBody UserEntity userEntity) {

        String token = userService.loginUser(userEntity);
        return Response.factory()
                .set("token", token)
                .succeed();
    }

}
