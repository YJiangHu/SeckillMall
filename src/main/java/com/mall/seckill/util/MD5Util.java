package com.mall.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5工具类，用于将指定字符串生成MD5加密后的字符串
 */
public class MD5Util {

    private static final String salt = "4d8a9d4adc"; //md5盐值

    /**
     * 将输入串和盐值进行md5加密并返回
     * @param s 输入的字符串
     * @return md5加密后的字符串
     */
    public static String md5(String s) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + s +salt.charAt(5) + salt.charAt(4);
        return DigestUtils.md5Hex(str);
    }

    public static void main(String[] args) {
        System.out.println(md5(md5("hyj911")));
    }
}
