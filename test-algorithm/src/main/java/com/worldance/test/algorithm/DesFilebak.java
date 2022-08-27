package com.worldance.test.algorithm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class DesFilebak {
    private static String keyfileName = "DesKey.xml";

    /**
     * <p> DES解密文件
     *
     * @param file 需要解密的文件
     * @param dest 解密后的文件
     * @throws Exception
     */
    public static void decrypt(String key, String file, String dest) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, getKey("k3c46029742"));
        //        cipher.init(Cipher.DECRYPT_MODE, generateKey(key));
        InputStream is = new FileInputStream(file);
        OutputStream out = new FileOutputStream(dest);
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) >= 0) {
            cos.write(buffer, 0, r);
        }
        cos.close();
        out.close();
        is.close();
    }

    /**
     * <p>DES加密文件
     *
     * @param file     源文件
     * @param destFile 加密后的文件
     * @throws Exception
     */
    public static void encrypt(String file, String destFile) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, getKey("k3c46029742"));
        InputStream is = new FileInputStream(file);
        OutputStream out = new FileOutputStream(destFile);
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0) {
            out.write(buffer, 0, r);
        }
        cis.close();
        is.close();
        out.close();
    }

    private static Key getKey(String keyRule) {
        // Key key = null;
        byte[] keyByte = keyRule.getBytes();
        // 创建一个空的八位数组,默认情况下为0
        byte[] byteTemp = new byte[8];
        // 将用户指定的规则转换成八位数组
        for (int i = 0; i < 8 && i < keyByte.length; i++) {
            byteTemp[i] = keyByte[i];
        }
        Key kp = new SecretKeySpec(byteTemp, "DES");
        return kp;
    }

    //    private static Key getKey() {
    //        Key kp = null;
    //        try {
    //            String fileName = keyfileName;
    //            InputStream is = new FileInputStream(fileName);
    //            ObjectInputStream oos = new ObjectInputStream(is);
    //            kp = (Key) oos.readObject();
    //            oos.close();
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //        return kp;
    //    }
    public static void main(String[] args) throws Exception {
        //        DesUtil.saveDesKey();
        //        DesUtil.encrypt("desinput.txt", "desoutput.txt");
        DesFilebak.decrypt("&lt;dzz8?", "C:\\Users\\tangbin\\Desktop\\日志\\29742(2).pdf",
            "C:\\Users\\tangbin\\Desktop\\日志\\29742(2).pdf");
        //desinput.txt 经过加密和解密后生成的 desinput2.txt 应该与源文件一样
    }

    /**
     * <p> 生成KEY，并保存
     */
    public static void saveDesKey() {
        try {
            SecureRandom sr = new SecureRandom();
            //为我们选择的DES算法生成一个KeyGenerator对象
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(sr);
            FileOutputStream fos = new FileOutputStream(keyfileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //生成密钥
            Key key = kg.generateKey();
            oos.writeObject(key);
            oos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Key generateKey(String key) {
        char[] array = key.toCharArray(); //获取字符数组
        for (int i = 0; i < array.length; i++) { //遍历字符数组
            array[i] = (char) (array[i] ^ 8); //对每个数组元素进行异或运算
        }
        String password = new String(array);
        password = password + "29742";
        //        password = password.substring(0,8);
        // Key key = null;
        byte[] keyByte = password.getBytes();
        // 创建一个空的八位数组,默认情况下为0
        byte[] byteTemp = new byte[8];
        // 将用户指定的规则转换成八位数组
        for (int i = 0; i < 8 && i < keyByte.length; i++) {
            byteTemp[i] = keyByte[i];
        }
        Key kp = new SecretKeySpec(byteTemp, "DES");
        return kp;

    }
}