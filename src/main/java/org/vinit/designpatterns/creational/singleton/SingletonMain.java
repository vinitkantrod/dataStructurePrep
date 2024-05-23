package org.vinit.designpatterns.creational.singleton;

import java.util.Objects;

public class SingletonMain {

    public static void main(String[] args) {
        StringSingleton s1 = StringSingleton.getInstance();
        StringSingleton s2 = StringSingleton.getInstance();
        StringSingleton s3 = StringSingleton.getInstance();

        System.out.println("Hashcode of s1: " + s1.hashCode());
        System.out.println("Hashcode of s1: " + s2.hashCode());
        System.out.println("Hashcode of s1: " + s3.hashCode());
        System.out.println(Objects.equals(s1, s2));

        s1.s = s1.s.toUpperCase();
        System.out.println(s2.s);
    }
}
