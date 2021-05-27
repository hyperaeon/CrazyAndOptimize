package com.algorithm.leeCode.simple;

/**
 * @program: CrazyAndOptimize
 * @description: 字符串替换
 * @author: ly
 * @create: 2021-05-01 18:00
 **/
public class StringReplace {

    public static String replaceEmpty1(StringBuffer stringBuffer) {
        StringBuilder sb = new StringBuilder();
        int length = stringBuffer.length();
        for (int i = 0; i < length; i++) {
            char s = stringBuffer.charAt(i);
            if (" ".equals(String.valueOf(s))) {
                sb.append("%20");
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static String replaceEmpty2(StringBuffer stringBuffer) {
        String str = stringBuffer.toString();
        return str.replaceAll("\\s", "%20");
    }

    public static void main(String[] args) {
        StringBuffer test = new StringBuffer("We Are Happy.");
        System.out.println(replaceEmpty1(test));
        System.out.println(replaceEmpty2(test));
    }
}
