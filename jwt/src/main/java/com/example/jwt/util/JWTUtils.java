package com.example.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jwt.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class JWTUtils {
    /*
     * 获取token
     * */
    public static String createToken(String userId, String realName, String userName) {
        Calendar nowTime = Calendar.getInstance();
        //有效时间10分钟
        nowTime.add(Calendar.MINUTE, 10);
        Date expiresDate = nowTime.getTime();
        return JWT.create().withAudience(userId)  //签发对象
                .withIssuedAt(new Date())  //发行时间
                .withExpiresAt(expiresDate) // 有效时间
                .withClaim("username", userName) //载荷，随便写几个
                .withClaim("realName", realName)
                .sign(Algorithm.HMAC256(userId + "hello xq")); //加密

    }

    /*
     * 验证token合法性
     * secret 用户id
     * */
    public static void verifyToken(String token, String secret) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret + "hello xq")).build();
            jwt = verifier.verify(token);

        } catch (Exception e) {
            log.error("签名异常", e);
        }
    }

    /*
     *获取签发对象
     * */
    public static String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            log.error("解析失败", e);
        }
        return audience;
    }

    /*
     * 通过载荷名字获取载荷的值
     * */
    public static Claim getClaimByName(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }


}
