package org.yangmy.tide.common.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.UUID;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class TokenUtils {

    public static String generateToken(UserInfo userInfo){
        String sessionId=UUID.randomUUID().toString();
        JSONObject o=new JSONObject();
        o.put("sessionId",sessionId);
        o.put("userInfo",userInfo);
        String token=JSON.toJSONString(o);
        return Base64Utils.encode(token);
    }

    public static String parseSessionId(String token){
        JSONObject o= (JSONObject) JSON.parse(Base64Utils.decode(token));
        return o.getObject("sessionId",String.class);
    }

    public static UserInfo parseUserInfo(String token){
        JSONObject o= (JSONObject) JSON.parse(Base64Utils.decode(token));
        return o.getObject("userInfo",UserInfo.class);
    }
}
