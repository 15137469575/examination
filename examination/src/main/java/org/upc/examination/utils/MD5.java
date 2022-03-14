package org.upc.examination.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 * 用于对一些敏感信息进行加密操作
 */
public final class MD5 {

    // 加密操作
    public static String encrypt(String data){
        if (null != data) return md5(data);
        return "数据错误";
    }

    /**
     * 将数据进行MD5加密 ,并转换为16进制字符串返回
     * @param data
     * @return
     */
    private static String md5(String data){
        try {
            byte[] bytes = md5(data.getBytes("utf-8"));
            return toHexString(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字节数组进行MD5加密
     * @param data
     * @return
     */
    private static byte[] md5(byte[] data){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    /**
     * 将加密后的字节数组，转换成16进制的字符串
     * @param data
     * @return
     */
    private static String toHexString(byte[] data){
        StringBuilder sb = new StringBuilder();
        for (byte b : data){
            // 4位为一个16进制字符
            sb.append(Integer.toHexString(b & 0XFF));
        }
        return sb.toString();
    }

}
