package com.psysoft.jdk.defaultPublic;

public class Test {

    public static void main(String[] args) {
        test5();
    }

    private static void test5() {

        //访问对象字段与静态变量

    }

    private static void test4() {

        //访问局部变量
        int num = 1;

        Converter<String,Integer> converter = form -> String.valueOf(form+num);  //num 隐性的具有final的语义

        System.out.println(converter.convert(2));
//        num = 4;
    }

    private static void test3() {
        PersonFactory<Person> factory = Person::new;

        factory.create("123","456").print();

    }


    private static void test2() {

//        Converter<Integer,String> converter = (form -> Integer.valueOf(form));
//        Converter<Integer,String> converter = form -> Integer.valueOf(form);
        Converter<Integer,String> converter = Integer::valueOf;
        System.out.println(converter.convert("12345"));
    }

    private static void test1() {

        Calculator cal = new SimpleCalculator();
        System.out.println( cal.sub(cal.add(1,3), cal.mul(9,5)));

        System.out.println( cal.div(cal.add(1,3), cal.mul(8,5)));
    }
}
