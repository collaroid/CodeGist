package com.collaroid.test;

/**
 * Created by Frank on 6/29/15.
 */
public class PointerTest {

    static String a = new String("good");
    static char[] b = {'a', 'b', 'c'};

    public static void main(String[] args) {

        PointerTest pointerTest = new PointerTest();

        System.out.println(pointerTest.a);
        System.out.println(pointerTest.b);

        pointerTest.change(pointerTest);

        System.out.println(a);
        System.out.println(b);

    }

    void change(PointerTest pointerTest){
        pointerTest.a = "test a";
        pointerTest.b[0] = 'g';
    }

}
