package top.hellonine.novel.novelapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import top.hellonine.novel.novelapi.entity.UserEntity;

import java.util.Date;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午4:01
 */


public class JwtUtil {

    //    设置过期时间
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    public static String getToken(UserEntity user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create()
                .withClaim("id", user.getId())
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(user.getOpenId()));
    }

    public static boolean verify(UserEntity user, String token) {
        Algorithm algorithm = Algorithm.HMAC256(user.getOpenId());
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("id", user.getId())
                .build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return true;
    }

    public static long getUserId(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("id").asLong();
    }

}
