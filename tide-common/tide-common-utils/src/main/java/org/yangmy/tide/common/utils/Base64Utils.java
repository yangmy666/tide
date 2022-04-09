package org.yangmy.tide.common.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class Base64Utils {

    /**
     * 对给定的字符串进行base64编码操作
     */
    public static String encode(String input) {
        return new String(Base64.encodeBase64(input.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    /**
     * 对给定的字符串进行base64解码操作
     */
    public static String decode(String input) {
        return new String(Base64.decodeBase64(input.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

}
