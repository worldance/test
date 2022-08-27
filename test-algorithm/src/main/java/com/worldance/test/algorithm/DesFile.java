package com.worldance.test.algorithm;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DesFile {
    private static final String ALGORITHM = "DES";

    private static final String CHARSET = "utf-8";

    public static void main(String[] args) throws Exception {
        DesFile.decrypt("1?;ipi", "29742", "C:\\Users\\tangbin\\Desktop\\日志\\29742(3).pdf",
            "C:\\Users\\tangbin\\Desktop\\日志\\29742(3)-1.pdf");
        //desinput.txt 经过加密和解密后生成的 desinput2.txt 应该与源文件一样
    }

    /**
     * <p> DES解密文件
     *
     * @param file 需要解密的文件
     * @param dest 解密后的文件
     * @throws Exception
     */
    public static void decrypt(String key, String requestTemplateId, String file, String dest) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, generateKey(key, requestTemplateId));
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

    public static Key generateKey(String key, String requestTemplateId) {
        char[] array = key.toCharArray(); //获取字符数组
        for (int i = 0; i < array.length; i++) { //遍历字符数组
            array[i] = (char) (array[i] ^ 8); //对每个数组元素进行异或运算
        }
        String password = new String(array);
        password = password + requestTemplateId;
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

}