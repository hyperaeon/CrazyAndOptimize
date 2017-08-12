package com.crazy.chapter15.fourth.basic;

import java.io.FileReader;
import java.io.PushbackReader;

/**
 * Created by hzliyong on 2017/8/8 0008.
 */
public class PushbackTest {

    public static void main(String[] args) {
        try (PushbackReader pr = new PushbackReader(new FileReader("C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\basic\\PushbackTest.java"), 64)) {
            char[] buf = new char[32];
            String lastContent = "";
            int hasRead = 0;
            while ((hasRead = pr.read(buf)) > 0) {
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
                    pr.unread((lastContent + content).toCharArray());
                    int len = targetIndex > 32 ? 32 : targetIndex;
                    pr.read(buf, 0, len);
                    System.out.println(new String(buf, 0, len));
                    System.exit(0);
                } else {
                    System.out.println(lastContent);
                    lastContent = content;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
