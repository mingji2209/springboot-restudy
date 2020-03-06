package com.psysoft.pattern;

public class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton(){

    }

    public static LazySingleton getinstance(){
        if (singleton == null){
            synchronized(LazySingleton.class){
                if (singleton == null){
                    singleton = new LazySingleton();
                }
            }
        }
        return  singleton;
    }
}
