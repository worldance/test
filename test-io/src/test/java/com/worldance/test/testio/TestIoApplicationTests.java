package com.worldance.test.testio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class TestIoApplicationTests {
    String filePath1 = "E:\\sourceCode\\worldance\\test\\test-io\\src\\main\\resources\\testTxt1.txt";

    String filePath2 = "E:\\sourceCode\\worldance\\test\\test-io\\src\\main\\resources\\testTxt2.txt";

    String filePath3 = "E:\\sourceCode\\worldance\\test\\test-io\\src\\main\\resources\\testTxt3.txt";

    @Test
    void contextLoads() {
        System.out.println("test111");
    }

    @Test
    void testMain() {
        this.testFileRead();
        this.testFileBufferedRead();
        this.testFileWrite();
        this.testFileBufferedWrite();
    }

    @Test
    void testFileInputStream() {
        File file = new File(filePath1);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int len;
            byte[] byteArray = new byte[1024];
            while ((len = fis.read(byteArray)) != -1) {
                System.out.println(byteArray);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("文件读取异常！" + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("读取文件内容异常！" + e.getMessage());
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException e) {
                    System.out.println("输入流关闭异常！" + e.getMessage());
                }
            }
        }
    }

    @Test
    void testFileRead() {
        long beginTime = System.nanoTime();
        File file = new File(filePath1);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int len;
            char[] charArray = new char[10];
            while ((len = fr.read(charArray)) != -1) {
                System.out.println("FileReader输出内容：" + String.valueOf(charArray));
                charArray = new char[10];
            }
            long endTime = System.nanoTime();
            System.out.println("FileReader耗时:" + (endTime - beginTime));
        }
        catch (IOException e) {
            System.out.println("FileReader IO异常:" + e.getMessage());
        }
        finally {
            if (fr != null) {
                try {
                    fr.close();
                }
                catch (IOException e) {
                    System.out.println("FileReader fr流关闭异常:" + e.getMessage());
                }
            }
        }
    }

    @Test
    void testFileBufferedRead() {
        long beginTime = System.nanoTime();
        File file = new File(filePath1);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            int len;
            char[] charArray = new char[10000];
            while ((len = br.read(charArray)) != -1) {
                System.out.println("FileBufferedRead输出内容：" + String.valueOf(charArray));
                charArray = new char[10000];
            }
            long endTime = System.nanoTime();
            System.out.println("FileBufferedRead耗时:" + (endTime - beginTime));
        }
        catch (IOException e) {
            System.out.println("FileBufferedReadIO异常:" + e.getMessage());
        }
        finally {
            if (fr != null) {
                try {
                    fr.close();
                }
                catch (IOException e) {
                    System.out.println("FileBufferedRead fr流关闭异常:" + e.getMessage());
                }
            }
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    System.out.println("FileBufferedRead br流关闭异常:" + e.getMessage());
                }
            }
        }
    }

    @Test
    void testFileWrite() {
        long beginTime = System.nanoTime();
        File file = new File(filePath2);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            String testStr = "文件2：测试输出下";
            fw.write(testStr);
            fw.write(System.getProperty("line.separator"));
            long endTime = System.nanoTime();
            System.out.println("FileWrite耗时:" + (endTime - beginTime));
        }
        catch (IOException e) {
            System.out.println("FileWrite IO异常:" + e.getMessage());
        }
        finally {
            if (fw != null) {
                try {
                    fw.close();
                }
                catch (IOException e) {
                    System.out.println("FileWrite fw流关闭异常:" + e.getMessage());
                }
            }
        }
    }

    @Test
    void testFileBufferedWrite() {
        long beginTime = System.nanoTime();
        File file = new File(filePath3);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            String testStr = "文件3：测试输出下!";
            bw.write(testStr);
            bw.write(System.getProperty("line.separator"));
            bw.flush();
            long endTime = System.nanoTime();
            System.out.println("FileBufferedWrite耗时:" + (endTime - beginTime));
        }
        catch (IOException e) {
            System.out.println("FileBufferedWrite IO异常:" + e.getMessage());
        }
        finally {
            if (fw != null) {
                try {
                    fw.close();
                }
                catch (IOException e) {
                    System.out.println("FileBufferedWrite fw流关闭异常:" + e.getMessage());
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException e) {
                    System.out.println("FileBufferedWrite bw流关闭异常:" + e.getMessage());
                }
            }
        }
    }

    @Test
    void testFileCopy() {
        long beginTime = System.nanoTime();
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            int len;
            char[] charArray = new char[1000];
            while ((len = fr.read(charArray)) != -1) {
                fw.write(charArray);
            }
            fw.flush();
            long endTime = System.nanoTime();
            System.out.println("testFileCopy耗时:" + (endTime - beginTime));
        }
        catch (IOException e) {
            System.out.println("testFileCopy IO异常:" + e.getMessage());
        }
        finally {
            if (fr != null) {
                try {
                    fr.close();
                }
                catch (IOException e) {
                    System.out.println("testFileCopy fr流关闭异常:" + e.getMessage());
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                }
                catch (IOException e) {
                    System.out.println("testFileCopy fw流关闭异常:" + e.getMessage());
                }
            }
        }
    }

}
