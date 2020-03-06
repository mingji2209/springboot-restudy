package com.psysoft.pattern.register;

/**
 * 枚举式单例
 */

public enum EnumSingleton {

    INSTANCE;

    private Object date;

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
