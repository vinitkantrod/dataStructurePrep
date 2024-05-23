package org.vinit.designpatterns.creational.abstractFactory;

public class MobileMain {
    public static void main(String[] args) {
        PhoneStore store = new PhoneStore();
        Phone user1 = store.getPhone(Constants.APPLE, Constants.I_PHONE_14_PRO);
        System.out.println(user1.getDescription());
        Phone user2 = store.getPhone(Constants.SAMSUNG, Constants.S_23);
        System.out.println(user2.getDescription());
        Phone user3 = store.getPhone(Constants.APPLE, "iPhone 15");
        System.out.println(user3.getDescription());

    }
}
