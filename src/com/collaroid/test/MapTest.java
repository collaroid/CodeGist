package com.collaroid.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Frank on 6/17/15.
 */
public class MapTest {

    static ConcurrentHashMap<Long, String> concurrentHashMap = new ConcurrentHashMap<Long, String>();
    static HashMap<Long, String> hashMap = new HashMap<Long, String>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (concurrentHashMap) {
                    while (true) {
                        System.out.println("concurrentHashMap size: " + concurrentHashMap.size());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (hashMap) {
                    while (true) {
                        System.out.println("hashMap size: " + hashMap.size());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("map put!");
                        synchronized (hashMap) {
                            hashMap.put(System.currentTimeMillis(), "test");
                        }
                        synchronized (concurrentHashMap) {
                            concurrentHashMap.put(System.currentTimeMillis(), "test");
                        }

//                        hashMap.put(System.currentTimeMillis(), "test");
//                        concurrentHashMap.put(System.currentTimeMillis(), "test");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
