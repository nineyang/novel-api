package top.hellonine.novel.novelapi.mapper;

import org.apache.ibatis.annotations.*;
import top.hellonine.novel.novelapi.entity.UserEntity;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午10:45
 */

@Mapper
public interface UserMapper {

    @Select("select * from users where open_id = #{openid}")
    @Results({
            @Result(property = "openId", column = "open_id"),
            @Result(property = "unionId", column = "union_id"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    UserEntity getByOpenId(String openid);


    @Insert("insert into users(open_id , name , avatar , created_at , updated_at) values(#{openId} , #{name} , " +
            "#{avatar} , #{createdAt} , #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserEntity userEntity);

}
