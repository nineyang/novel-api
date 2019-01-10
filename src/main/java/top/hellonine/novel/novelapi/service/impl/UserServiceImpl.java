package top.hellonine.novel.novelapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hellonine.novel.novelapi.entity.UserEntity;
import top.hellonine.novel.novelapi.mapper.UserMapper;
import top.hellonine.novel.novelapi.service.UserService;
import top.hellonine.novel.novelapi.util.JwtUtil;
import top.hellonine.novel.novelapi.util.WxopenUtil;

import java.io.IOException;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午10:50
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getByOpenId(String openid) {
        return userMapper.getByOpenId(openid);
    }

    @Override
    public UserEntity getById(Long id) {
        return userMapper.getById(id);
    }


    public String loginUser(UserEntity user, String code) {
        String openId = null;
        try {
            openId = WxopenUtil.getOpenId(code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserEntity userEntity = getByOpenId(openId);
        if (userEntity == null) {
            user.setOpenId(openId);
            user.setCreatedAt(System.currentTimeMillis());
            user.setUpdatedAt(System.currentTimeMillis());
            int id = userMapper.insert(user);
            userEntity = user;
        }
        return JwtUtil.getToken(userEntity);
    }
}
