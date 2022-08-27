package com.worldance.test.algorithm;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * 该加密工具兼容PHP
 */
public class DesEcbCompatiblePhpUtil {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "DES";

    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_STR = "DES/ECB/NoPadding";

    private static final String CHARSET = "UTF-8";

    /**
     * 填充内容
     */
    private static final String PAD_STR = "\0";

    public static void main(String[] args) throws Exception {
        String clearText = "123";

        String key = "123";
        System.out.println("明文：" + clearText + "\n密钥：" + key);
        String encryptText = encrypt(clearText, key);
        System.out.println("加密后：" + encryptText);
        String decryptText = decrypt(encryptText, key);
        System.out.println("解密后：" + decryptText);

        System.out.println(decryptText.trim().equals("123456"));
    }

    public static String encrypt(String souce, String key) {
        try {
            return encryptByDes(pkcs5Pad(souce), pkcs5Pad(key));
        }
        catch (Exception e) {
            System.out.println("加密数据:" + souce + " 异常,原因：" + e.getMessage());
        }

        return "";
    }

    public static String decrypt(final String souce, final String key) {
        try {
            return decryptByDes(souce, pkcs5Pad(key)).trim();
        }
        catch (Exception e) {
            System.out.println("加密数据:" + souce + " 异常,原因：" + e.getMessage());
        }

        return "";
    }

    private static String encryptByDes(final String souce, final String key)
        throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
        IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key.getBytes(CHARSET));
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key1 = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, key1, sr);
        // 现在，获取数据并加密
        byte encryptedData[] = cipher.doFinal(souce.getBytes(CHARSET));
        // 通过BASE64位编码成字符创形式
        String base64Str = new BASE64Encoder().encode(encryptedData);

        return base64Str;
    }

    private static String decryptByDes(final String souce, final String key)
        throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
        IOException, IllegalBlockSizeException, BadPaddingException {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key.getBytes(CHARSET));
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key1 = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, key1, sr);
        // 将加密报文用BASE64算法转化为字节数组
        byte[] encryptedData = new BASE64Decoder().decodeBuffer(souce);
        // 用DES算法解密报文
        byte decryptedData[] = cipher.doFinal(encryptedData);
        return new String(decryptedData, CHARSET);
    }

    private static String pkcs5Pad(final String souce) {
        //密文和密钥的长度必须是8的倍数
        if (0 == souce.length() % 8) {
            return souce;
        }

        StringBuffer tmp = new StringBuffer(souce);

        while (0 != tmp.length() % 8) {
            tmp.append(PAD_STR);
        }
        return tmp.toString();
    }
}