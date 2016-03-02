package com.collaroid.test;

/**
 * Created by MacBookAir on 3/4/15.
 */
public class Test {

    public static boolean ready;
    public static int num;

    static class myThread extends Thread {

        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }
            System.out.println(num);
        }

    }

    public static void main(String[] args){


//        new myThread().start();
//        num = 32;
//        ready = true;

//        ArrayList<Integer> temp = new ArrayList<Integer>();
//        temp.add(1);
//        temp.add(2);
//        temp.add(3);
//        temp.add(4);
//        Object[] b = temp.toArray();
//        String aStr = "aStr: ";
//        for (Integer i : temp) {
//            aStr += i + " ";
//        }
//        String bStr = "bStr: ";
//        for (Object i : b) {
//            bStr += (Integer)i + " ";
//        }
//
//        System.out.println(aStr + "\n" + bStr);
//        System.out.println(temp.get(2) + "\n" + b[2]);

//        int c = 5;
//        System.out.println(c);
//        System.out.println(++c);
//        System.out.println(c);

//        Set<Integer> a = new HashSet<Integer>();
//        a.add(1);
//
//        HashMap<String, Object> b = new HashMap<String, Object>();
//        b.put("a", a);
//
//        System.out.println(((Set<Integer>)b.get("a")).contains(new Integer(1)));

//        System.out.println(NumberU);

    }



}
