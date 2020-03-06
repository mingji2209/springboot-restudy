package com.psysoft.basic;

public class Test {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;


    public static void main(String[] args) {

        System.out.println(CAPACITY);

          int result = -1 << COUNT_BITS;
        System.out.println(result);

    }
}
