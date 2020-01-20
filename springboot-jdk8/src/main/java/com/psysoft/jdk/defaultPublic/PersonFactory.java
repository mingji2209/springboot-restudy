package com.psysoft.jdk.defaultPublic;

public interface PersonFactory <P extends Person>{

    P create(String firstName,String LastName);

}
