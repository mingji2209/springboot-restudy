package com.psysoft.jdk.defaultPublic;

/**
 * 函数式接口
 * 每一个lambda表达式都对应一个类型，通常是接口类型。
 * 而“函数式接口”是指仅仅只包含一个抽象方法的接口，
 * 每一个该类型的lambda表达式都会被匹配到这个抽象方法。
 * @param <T>
 * @param <F>
 */

@FunctionalInterface
public interface Converter<T,F> {

    int count = 0;

    T convert(F form);

    default int count(){
       return count;
    }
}


