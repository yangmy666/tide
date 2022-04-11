package org.yangmy.tide.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Component
public class SecurityUtils {

    private static final ThreadLocal<String> token=new ThreadLocal<>();

    public static String getToken(){
        return token.get();
    }

    public static void setToken(String t){
        token.set(t);
    }

    public static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public SecurityUtils(StringRedisTemplate stringRedisTemplate){
        SecurityUtils.stringRedisTemplate=stringRedisTemplate;
    }

    public static final String REDIS_TOKEN_MAPPING_DIR="loginUser:";

    /**
     * 验证token是否有效
     * @param token token
     * @return true有效 false无效
     */
    public static boolean checkToken(String token){
        try {
            Long userId=TokenUtils.parseUserInfo(token).getId();
            String key=REDIS_TOKEN_MAPPING_DIR+userId;
            String sessionId=stringRedisTemplate.opsForValue().get(key);
            if(!Objects.equals(sessionId, TokenUtils.parseTokenId(token))){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 登录
     * @param userInfo 用户信息
     * @return 有效token
     */
    public static String login(UserInfo userInfo){
        String token=TokenUtils.generateToken(userInfo);
        String key = REDIS_TOKEN_MAPPING_DIR + userInfo.getId();
        stringRedisTemplate.opsForValue().set(key, TokenUtils.parseTokenId(token));
        return token;
    }

    /**
     * 退出登录
     * @return true false
     */
    public static boolean logout(){
        String token=SecurityUtils.getToken();
        if(checkToken(token)){
            Long userId=TokenUtils.parseUserInfo(token).getId();
            return forcedOffline(String.valueOf(userId));
        }
        return false;
    }

    /**
     * 强制下线
     * @param userId 用户id
     * @return true false
     */
    public static boolean forcedOffline(String userId){
        String key = REDIS_TOKEN_MAPPING_DIR + userId;
        return Boolean.TRUE.equals(stringRedisTemplate.delete(key));
    }
}
