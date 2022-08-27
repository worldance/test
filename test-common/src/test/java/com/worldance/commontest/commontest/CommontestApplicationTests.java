package com.worldance.commontest.commontest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class CommontestApplicationTests {

    @Test
    void contextLoads() {
        Long a = 1222221L;
        Long b = 22L;
        Long c = 1222221L;
        Long d = new Long(1222221L);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));

    }

    // 在这个字符串：asfsdf23323，是否符合指定的正则表达式 \w+
    @Test
    void test1() {
        String context = "asfsdf23323";
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(context);
        System.out.println(m.find());
    }
    // 这个字符串：qqq2#asfsd%%fAS_23323，查找是否符合指定的正则表达式 \w+，有就输出
    @Test
    void test2() {
        String context = "qqq2#asfsd%%fAS_23323";
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(context);
        System.out.println(m.matches());

        Pattern p1 = Pattern.compile("\\w{3,5}");
        Matcher m1 = p1.matcher(context);
        while (m1.find()) {
            System.out.println(m1.group());
        }
    }


    // 分组查询22qqq2asfsdfAS_23323----"([0-9]+)([a-z]+)"
    // 含有数字，含有小写字母的分组
    @Test
    void test3() {
        String context = "22qqq2asfsdfAS_23323";
        Pattern p = Pattern.compile("([\\d]+)([a-z]+)");
        Matcher m = p.matcher(context);
        System.out.println("匹配分组数：" + m.groupCount());
        while (m.find()) {
            System.out.println("分组0：" + m.group(0) + ";分组1：" + m.group(1) + ";分组2：" + m.group(2));
        }
    }

    // ssss4545QWww_vv4 将数字替换成%
    @Test
    void test4() {
        String context = "ssss4545QWww_vv4";
        /*Pattern p = Pattern.compile("[\\d]+");
        Matcher m = p.matcher(context);
        m.replaceAll("\\%");*/
        String newContext = context.replaceAll("[\\d]+", "%");
        System.out.println(newContext);
    }

    // dfga12222b55555crrrr 以数字进行切割
    @Test
    void test5() {
        String context = "dfga12222b55555crrrr";
        String[] arr = context.split("[\\d]+");
        System.out.println(Arrays.asList(arr));
    }

    @Test
    void test6() {
        String url = "https://blog.csdn.net/qq_44830627/article/details/105155401";
        String context = getUrlMsg(url);
        System.out.println(context);
        Pattern p = Pattern.compile("(http[\\s\\S]+?)\"");
        Matcher m = p.matcher(context);
        System.out.println("匹配分组数：" + m.groupCount());
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }

    private static String getUrlMsg(String urlStr) {
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(urlStr);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    /**
     * 测试反向引用
     */
    @Test
    void testRef(){
        String context = "335934";
        Pattern p = Pattern.compile("^(\\d)\\1[0-9](\\d)\\1{2}$");
        Matcher m = p.matcher(context);
        System.out.println("反向引用：" + m.matches());
    }

    /**
     * 测试断言
     */
    @Test
    void testAssert(){
        String context = "ingreading a book";
        Pattern p1 = Pattern.compile("read(?=ing)");
        Matcher m1 = p1.matcher(context);
        while (m1.find()) {
            System.out.println("正向肯定零宽断言:" + m1.group());
        }

        Pattern p2 = Pattern.compile("(?<=ing)read"); // (?<=read)ing
        Matcher m2 = p2.matcher(context);
        while (m2.find()) {
            System.out.println("反向肯定零宽断言:" +m2.group());
        }

        Pattern p3 = Pattern.compile("read(?!ing)");
        Matcher m3 = p3.matcher(context);
        while (m3.find()) {
            System.out.println("正向否定零宽断言:" +m3.group());
        }
        Pattern p4 = Pattern.compile("read(?<!ing)");
        Matcher m4 = p4.matcher(context);
        while (m4.find()) {
            System.out.println("反向否定零宽断言:" +m4.group());
        }
    }

    @Test
    void testPattern() {
        String context = "aaQQDqwdQ111\r\n1dsksj";
        System.out.println("原始字符:" + context);
        Pattern p = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(context);
        System.out.println("单行模式：");
        while (m.find()) {
            System.out.println(m.group());
        }

        System.out.println("多行模式：");
        Pattern p1 = Pattern.compile("^.+$", Pattern.MULTILINE);
        Matcher m1 = p1.matcher(context);
        while (m1.find()) {
            System.out.println(m1.group());
        }

        System.out.println("默认多行模式：");
        Pattern p2 = Pattern.compile("^.+$");
        Matcher m2 = p2.matcher(context);
        while (m2.find()) {
            System.out.println(m2.group());
        }

    }


}
