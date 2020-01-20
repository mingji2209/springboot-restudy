package com.psysoft.jdk.defaultPublic;

import lombok.Data;

@Data
public class Person implements Comparable<Person> {

    private String firstName ;
    private String lastName;

    public Person(){

    }

    public Person(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName){
        this.firstName = firstName;
        this.lastName = "default";
    }



   public  void print(){
       System.out.println(firstName+lastName);
    }



    @Override
    public int compareTo(Person o) {
//        return this.firstName.compareTo(o.getFirstName()) && this.lastName.compareTo(o.getLastName());

        int result = this.firstName.compareTo(o.getFirstName());
        if (result == 0){
            result =this.lastName.compareTo(o.getLastName());
        }

        return result;
    }
}
