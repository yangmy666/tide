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
public class LoginTemplate {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private TideSecurityConfiguration configuration;

    /**
     * 在确定登录用户名密码正确之后调用此方法为用户生成有效token
     * @param userInfo
     * @return token
     */
    public String login(UserInfo userInfo){
        String token=TokenUtils.generateToken(userInfo);
        String key = "session" + ":" + userInfo.getId();
        stringRedisTemplate.opsForValue().set(key, TokenUtils.parseSessionId(token));
        return token;
    }

    /**
     * 退出登录
     * @param request
     */
    public void logout(HttpServletRequest request){
        String token=request.getHeader(configuration.getTokenHeader());
        Long userId=TokenUtils.parseUserInfo(token).getId();
        forcedOffline(String.valueOf(userId));
    }

    /**
     * 强制下线
     * @param userId
     */
    public void forcedOffline(String userId){
        String key = "session" + ":" + userId;
        stringRedisTemplate.delete("session"+":"+key);
    }
}
