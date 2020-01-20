package com.psysoft.jdk.LambdaExp;

import com.psysoft.jdk.defaultPublic.Person;
import com.psysoft.jdk.defaultPublic.PersonFactory;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

        Integer[] arrays = {1,12,5,14,6,18,3,1,2,3,4,5,6,7,8,9,0};







        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        init(arrays,treeSet);




        TreeSet<Integer> treeSet1 = new TreeSet<Integer>((o1,o2)->{
            return o1.compareTo(o2);
        });

        PersonFactory<Person> factory = Person::new;


        TreeSet<Integer> treeSet2 = new TreeSet<>((o1,o2) -> o1.compareTo(o2));

        Person[] nameAyyays = {
                factory.create("peng","sanya"),
                factory.create("peng","huiyi"),
                factory.create("zhang","san"),
                factory.create("peng","sanya")
        };

        TreeSet<Person> treeSet3 = new TreeSet<>((p1,p2) -> p1.compareTo(p2));

        init(nameAyyays,treeSet3);




        System.out.println("1111");

    }



    private static  <T>   void init(T[] ayyas, TreeSet<T> treeSet){
        for (T  t:ayyas
             ) {
            treeSet.add(t);
        }
    }








}
