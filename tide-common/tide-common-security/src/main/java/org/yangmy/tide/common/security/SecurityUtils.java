package org.yangmy.tide.common.security;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class SecurityUtils {

    private static final ThreadLocal<UserInfo> userInfo=new ThreadLocal<>();

    public static UserInfo getUserInfo(){
        return userInfo.get();
    }

    public static void setUserInfo(UserInfo user){
        userInfo.set(user);
    }

}
