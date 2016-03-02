package com.collaroid.test;

/**
 * Created by Frank on 8/12/15.
 */
public class random {

    public static void main(String[] args) {
//        System.out.println(new Random().nextInt());
//        double a = Math.random();
//        System.out.println(a);
//        System.out.println(Math.rint(a * 1000));
//        System.out.println((int) Math.rint(a * 1000));
//
//        int i = (int) (100 + Math.random() * (1000 - 100 + 1));
//        System.out.println(i);
//
//        System.out.println("123abd".substring(3, 6));
//
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("12312", "1231");
//        Iterator<Map.Entry<String, String>> groupIter = map.entrySet().iterator();
//        while (groupIter.hasNext()) {
//            System.out.println(groupIter.next().getValue());
//        }

        final String str1 = "hello";
        final String str2 = "hello";

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("str1 locked.");
                synchronized (str1) {
                    while (true);
                }
            }
        }).start();

    }
}
