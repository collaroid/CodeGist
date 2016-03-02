package com.collaroid.test;

/**
 * Created by Frank on 8/25/15.
 */
public class StringTest {

    public static void main(String[] args) throws InterruptedException {
        final StringBuffer stringBuffer = new StringBuffer("abcdebcfg");
        final StringBuilder stringBuilder = new StringBuilder();
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i = 1000;
//                while (i-- > 0) {
//                    stringBuffer.append("123456789098765432");
//                    stringBuilder.append("123456789098765432");
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i = 1000;
//                while (i-- > 0) {
//                    stringBuffer.append("123456789098765432");
//                    stringBuilder.append("123456789098765432");
//                }
//            }
//        });
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);

//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();

//        System.out.println(stringBuffer.toString());
//        System.out.println("sbuilder:  " + stringBuilder.toString());

//        stringBuffer.append("abc");
//        stringBuffer.append("xyz");
//
//
//        System.out.println(stringBuffer.length());
//        System.out.println(stringBuilder.length());

        int index = stringBuffer.indexOf("bc");
        stringBuffer.insert(index, "@@@");

        System.out.println(index);
        System.out.println(stringBuffer.toString());

    }

}
