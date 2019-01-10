package top.hellonine.novel.novelapi.service;

import org.springframework.stereotype.Service;
import top.hellonine.novel.novelapi.entity.UserEntity;
import top.hellonine.novel.novelapi.mapper.UserMapper;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午10:38
 */
@Service
public interface UserService {


    UserEntity getByOpenId(String openid);

    UserEntity getById(Long id);

    String loginUser(UserEntity user, String code);
}
