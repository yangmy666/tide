package org.yangmy.tide.service.system.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.yangmy.tide.service.system.entity.SysUser;

import java.util.UUID;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class TokenUtils {

    public static String generateToken(SysUser sysUser){
        JSONObject o=new JSONObject();
        o.put("id",UUID.randomUUID().toString());
        sysUser.setPassword(null);
        o.put("userInfo",sysUser);
        return JSON.toJSONString(o);
    }

    public static String parseId(String token) throws Exception{
        JSONObject o= (JSONObject) JSON.parse(token);
        return o.getObject("id",String.class);
    }

    public static SysUser parseUserInfo(String token) throws Exception{
        JSONObject o= (JSONObject) JSON.parse(token);
        return o.getObject("userInfo",SysUser.class);
    }
}
