package com.my.servermvc.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.my.servermvc.entity.User;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Author: lh
 * @Date 2020/11/30
 * @Version: 1.0
 **/
@Service
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUserId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
