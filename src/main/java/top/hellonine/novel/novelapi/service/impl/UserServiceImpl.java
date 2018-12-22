package top.hellonine.novel.novelapi.service.impl;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hellonine.novel.novelapi.entity.UserEntity;
import top.hellonine.novel.novelapi.mapper.UserMapper;
import top.hellonine.novel.novelapi.service.UserService;
import top.hellonine.novel.novelapi.util.JwtUtil;

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


    public String loginUser(UserEntity user) {
        UserEntity userEntity = getByOpenId(user.getOpenId());
        if (userEntity == null) {
            int id = userMapper.insert(user);
            userEntity = user;
        }
        return JwtUtil.getToken(userEntity);
    }
}
