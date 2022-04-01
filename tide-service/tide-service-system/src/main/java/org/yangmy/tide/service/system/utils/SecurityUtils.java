package org.yangmy.tide.service.system.utils;

import org.yangmy.tide.service.system.entity.SysUser;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class SecurityUtils {

    private static ThreadLocal<SysUser> userInfo=new ThreadLocal<>();

    public static SysUser getUserInfo(){
        return userInfo.get();
    }

    public static void setUserInfo(SysUser sysUser){
        userInfo.set(sysUser);
    }
}
