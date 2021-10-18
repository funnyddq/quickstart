package com.example;

/**
 * Hello world!
 */
public class IntegerTest {
    public static void main(String[] args) throws InterruptedException {
        Integer i1 = 33;

        Integer i2 = 33;

        System.out.println(i1 == i2);// 输出 true

        Integer i01 = 9999;

        Integer i02 = 9999;

        System.out.println(i01 == i02);// 输出 false


        Float i11 = 333f;

        Float i22 = 333f;

        System.out.println(i11 == i22);// 输出 false

        Double i3 = 1.2;

        Double i4 = 1.2;

        System.out.println(i3 == i4);// 输出 false
    }
}
