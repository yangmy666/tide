package org.yangmy.tide.service.system.utils;

import org.yangmy.tide.service.system.entity.SysUser;

import java.util.UUID;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class SecurityUtils {

    public static String generateToken(){
        return UUID.randomUUID().toString();
    }

    public static SysUser getUserInfo(){
        //todo
        return new SysUser();
    }
}
