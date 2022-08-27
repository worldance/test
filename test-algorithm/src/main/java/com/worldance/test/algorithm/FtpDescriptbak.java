package com.worldance.test.algorithm;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName FtpDescript
 * @Description
 * @Author 唐诗
 * @Date 2020/9/10 14:57
 * @Version 1.0
 */
public class FtpDescriptbak {

    /**
     * 偏移变量，固定占8位字节
     */
    private final static String IV_PARAMETER = "12345678";

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "DES";

    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM = "DES/ECB/NoPadding";

    /**
     * 默认编码
     */
    private static final String CHARSET = "utf-8";

    public static void main1(String[] args) {
        char a[] = "微软被收购".toCharArray();
        int n, m;

        File file = new File("c://mi.txt");
        for (int i = 0; i < file.length(); i++) {
            a[i] = (char) (a[i] ^ 'R');
        }
        try {
            FileWriter out = new FileWriter(file);
            out.write(a, 0, a.length);
            out.close();
            FileReader in = new FileReader(file);
            char tom[] = new char[10];
            System.out.println("密文：");
            n = in.read(tom, 0, 10);
            if (n != -1) {
                String s = new String(tom, 0, n);
                System.out.println(s);
            }
            in.close();
            in = new FileReader(file);
            System.out.println("开始解密：");
            System.out.println("明文：");
            n = in.read(tom, 0, 10);
            if (n != -1) {
                for (int i = 0; i < n; i++) {
                    tom[i] = (char) (tom[i] ^ 'R');
                }
                String s = new String(tom, 0, n);
                System.out.println(s);
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * DES解密文件
     *
     * @param srcFile  已加密的文件
     * @param destFile 解密后存放的文件路径
     * @return 解密后的文件路径
     */
    public static String decryptFile(String password, String srcFile, String destFile) {
        /*if (password== null || password.length() < 8) {
            throw new RuntimeException("加密失败，key不能小于8位");
        }*/
        try {
            File file = new File(destFile);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //            cipher.init(Cipher.DECRYPT_MODE, generateKey(password), iv);
            cipher.init(Cipher.DECRYPT_MODE, generateKey(password), new SecureRandom());

            InputStream is = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(destFile);
            CipherOutputStream cos = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[10240000];
            int r;
            while ((r = is.read(buffer)) >= 0) {
                //                byte[] encryptedData = new BASE64Decoder().decodeBuffer(new String(buffer));
                byte decryptedData[] = cipher.doFinal(buffer);
                cos.write(buffer, 0, r);
            }
            cos.close();
            is.close();
            out.close();
            return destFile;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Key generateKey(String key) {
        char[] array = key.toCharArray(); //获取字符数组
        for (int i = 0; i < array.length; i++) { //遍历字符数组
            array[i] = (char) (array[i] ^ 8); //对每个数组元素进行异或运算
        }
        String password = new String(array);
        password = password + "29742";
        password = password.substring(0, 8);
        DESKeySpec dks = null;
        SecretKeyFactory keyFactory = null;
        Key result = null;
        try {
            dks = new DESKeySpec(password.getBytes(CHARSET));
            keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            result = keyFactory.generateSecret(dks);
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static void main(String[] args) {

        decryptFile("dp0:ce", "C:\\Users\\tangbin\\Desktop\\日志\\29742(1).pdf",
            "C:\\Users\\tangbin\\Desktop\\日志\\29742(1)-1.pdf");
    }
}
