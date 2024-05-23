package org.vinit.designpatterns.creational.singleton;

public class StringSingleton {

    private static volatile StringSingleton instance;
    public String s;
    private StringSingleton() {
        this.s = "I am an instance of String singleton class";
    }

    public static StringSingleton getInstance() {
        if (instance == null) {
            synchronized (StringSingleton.class) {
                if (instance == null) {
                    instance = new StringSingleton();
                }
            }
        }
        return instance;
    }
}
