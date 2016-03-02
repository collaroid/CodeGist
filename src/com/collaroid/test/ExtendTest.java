package com.collaroid.test;

/**
 * Created by Frank on 6/29/15.
 */
public class ExtendTest extends A {

    public ExtendTest() {
        System.out.println("init Test!");
    }

    {
        System.out.println("class TTEst");
    }

    public static void main(String[] args) {
        ExtendTest extendTest = new ExtendTest();
    }


    static {
        System.out.println("static Test");
    }

}

class A extends B {

    public A() {
        System.out.println("init A!");
    }

    {
        System.out.println("class AA");
    }

    static {
        System.out.println("static A");
    }

}

class B {

    public B() {
        System.out.println("init B!");
    }

    {
        System.out.println("class BB");
    }

    static {
        System.out.println("static B");
    }

}