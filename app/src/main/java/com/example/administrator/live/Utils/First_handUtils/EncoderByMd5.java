package com.example.administrator.live.Utils.First_handUtils;

import java.security.MessageDigest;

/**
 * @类的用途:
 * @作者: 任正威
 * @date: 2017/5/25.
 */

public class EncoderByMd5 {
    /**
     * 获取MD5加密字符串
     *
     * @param pass
     * @return
     */
    //加密
    public static String md5Password(String pass) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("md5");
            byte[] bytes = messageDigest.digest(pass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : bytes) {
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //拼接参数
    public static String appFistHandAddPwd(StringBuffer sign) {
        return sign.toString();
    }
    //转大写
    public static String appFistHandToUpperCase(String msg) {
        String toUpperCase = msg.toUpperCase();
        return toUpperCase;
    }
}
