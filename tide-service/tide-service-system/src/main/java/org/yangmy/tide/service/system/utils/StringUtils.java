package org.yangmy.tide.service.system.utils;

import java.util.Random;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public class StringUtils {

    public static String generateRandomStr(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(str.length());    //从62个字符中随机取其中一个
            sb.append(str.charAt(number));  //用取到的数当索引取字符加到length个数的字符串
        }
        return sb.toString();  //返回字符串
    }

}
