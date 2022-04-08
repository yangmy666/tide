package org.yangmy.tide.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Component
public class LoginTemplate implements LoginOperations{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private TideSecurityConfiguration configuration;

    @Override
    public String login(UserInfo userInfo){
        String token=TokenUtils.generateToken(userInfo);
        String key = "session" + ":" + userInfo.getId();
        stringRedisTemplate.opsForValue().set(key, TokenUtils.parseSessionId(token));
        return token;
    }

    @Override
    public boolean logout(HttpServletRequest request){
        String token=request.getHeader(configuration.getTokenHeader());
        Long userId=TokenUtils.parseUserInfo(token).getId();
        return forcedOffline(String.valueOf(userId));
    }

    @Override
    public boolean forcedOffline(String userId){
        String key = "session" + ":" + userId;
        return Boolean.TRUE.equals(stringRedisTemplate.delete(key));
    }
}
