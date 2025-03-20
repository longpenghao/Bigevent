package bigevent.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        // 生成jwt token
        // 1. 导入依赖
        // 2. 生成jwt token
        // 3. 解析jwt token
        String token = JWT.create()
                .withClaim("user", claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//设置过期时间
                .sign(Algorithm.HMAC256("bigevent"));//指定算法，配置密钥
        System.out.println(token);
    }

//    @Test
//    public void testParse(){
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MzU4Mjc3OTF9.Xd-gaaa9fobbLDfew3oAq0WAsmrtUTZbMpH2Lk-jC_I";
//        // 解析jwt token
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("bigevent")).build();
//
//        // 验证token
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);
//        Map<String, Claim> claims = decodedJWT.getClaims();
//        System.out.println( claims.get("user"));
//
//        // 如果篡改了头部和载荷部分的数据，那么验证失败
//        // 如果密钥改了，验证失败
//        // 如果token过期了，验证失败
//    }
}
