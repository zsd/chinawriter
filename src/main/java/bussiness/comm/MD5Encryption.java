package bussiness.comm;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * MD5加密解密.
 * @author zhousd
 */
public final class MD5Encryption {

    /**
     * 加密方法.
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        if (StringUtils.isBlank(str)) {
            return str;
        }
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //加密后的字符串
        return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
    }

    /**
     * 解密方法.
     * @param newPassword 输入的字符串
     * @param oldPassword 数据库存储的字符串
     * @return 是否一致
     */
    public static boolean checkpassword(String newPassword, String oldPassword)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return EncoderByMd5(newPassword).equals(oldPassword);
    }
}
