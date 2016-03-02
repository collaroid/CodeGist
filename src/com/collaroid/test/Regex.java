package com.collaroid.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MacBookAir on 5/12/15.
 */
public class Regex {

    public static void main(String[] args) {
        String a = "111\n 222 \r3333\t4444";
        System.out.println(a);
        System.out.println("~~~~~~~~");
        System.out.println(a.replaceAll("\\n|\\r|\\t",""));
//        regTest2();
    }


    private static void regTest() {
        // 查找html中对应条件字符串
        Pattern vastPattern = Pattern.compile("<MediaFile\\s+[^>]*>(.*?)</MediaFile>");
        Matcher matcher = vastPattern.matcher("<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" ?><VAST version=\\\"2.0\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xsi:noNamespaceSchemaLocation=\\\"vast.xsd\\\"><Ad><InLine><AdSystem version=\\\"2.0\\\">Ad Server</AdSystem><AdTitle>In-Stream Video</AdTitle><Description>A test creative with a description.</Description><Impression><![CDATA[http://adserver.com/imp]]></Impression><Creatives><Creative sequence=\\\"1\\\" AdID=\\\"\\\"><Linear><Duration>00:00:58</Duration><VideoClicks><ClickThrough><![CDATA[http://adserver.com/click]]></ClickThrough></VideoClicks><MediaFiles><MediaFile id=\\\"1\\\" delivery=\\\"progressive\\\" type=\\\"video/x-flv\\\" bitrate=\\\"457\\\" width=\\\"300\\\" height=\\\"225\\\"><![CDATA[http://adserver.com/video.flv]]></MediaFile></MediaFiles></Linear></Creative></Creatives></InLine></Ad></VAST>");
        while(matcher.find())
            System.out.println(unboxXmlText(matcher.group(1)));
    }

    private static void regTest2() {
        // 查找html中对应条件字符串
        Pattern jsonPattern = Pattern.compile("\"fu\":\\s*\"(.+?)\",");
        Matcher matcher = jsonPattern.matcher("{\"creatives\": [{\"fu\":    \"file_url\",\"lp\": \"landing_page\",\"ctu\": [\"click_tracking_url1\",\"click_tracking_url2\"],\"itu\": [\"imp_tracking_url1\",\"imp_tracking_url2\"]},{\"fu\": \"file_url\",\"lp\": \"landing_page\",\"ctu\": [\"click_tracking_url1\",\"click_tracking_url2\"],\"itu\": [\"imp_tracking_url1\",\"imp_tracking_url2\"]}]}");
        while(matcher.find())
            System.out.println(matcher.group(1));
    }


    private static String unboxXmlText(String str) {
        if ( "<![CDATA[".equalsIgnoreCase(str.substring(0, 9))) {
            return str.substring(9, str.length() - 3);
        }
        return str;
    }

    private static void reg1(){
        //查找以Java开头,任意结尾的字符串
        Pattern pattern = Pattern.compile("^Java.*");
        Matcher matcher = pattern.matcher("Java不是人");
        boolean b= matcher.matches();
        //当条件满足时，将返回true，否则返回false
        System.out.println(b);
    }

    private static void reg2() {
        //以多条件分割字符串时
        Pattern pattern = Pattern.compile("[, |]+");
        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
        for (int i=0;i<strs.length;i++) {
            System.out.println(strs[i]);
        }
    }

    private static void reg3() {
        // 文字替换（首次出现字符）
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        //替换第一个符合正则的数据
        System.out.println(matcher.replaceFirst("Java"));
    }

    private static void reg4() {
        // 文字替换（全部）
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        //替换第一个符合正则的数据
        System.out.println(matcher.replaceAll("Java"));
    }

    private static void reg5() {
        // 文字替换（置换字符）
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbr, "Java");
        }
        matcher.appendTail(sbr);
        System.out.println(sbr.toString());
    }

    private static void reg6() {
        // 验证是否为邮箱地址
        String str="ceponline@yahoo.com.cn";
        Pattern pattern = Pattern.compile("[//w//.//-]+@([//w//-]+//.)+[//w//-]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    private static void reg7() {
        // 去除html标记
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

    private static void reg8() {
        // 查找html中对应条件字符串
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        if(matcher.find())
            System.out.println(matcher.group(1));
    }

    private static void reg9() {
        //截取url
        Pattern pattern = Pattern.compile("(http://|https://){1}[//w//.//-/:]+");
        Matcher matcher = pattern.matcher("dsdsds<http://dsds//gfgffdfd>fdf");
        StringBuffer buffer = new StringBuffer();
        while(matcher.find()){
            buffer.append(matcher.group());
            buffer.append("/r/n");
            System.out.println(buffer.toString());
        }
    }


}
