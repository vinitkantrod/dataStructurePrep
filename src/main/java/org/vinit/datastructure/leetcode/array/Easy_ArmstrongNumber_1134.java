package org.vinit.datastructure.leetcode.array;

public class Easy_ArmstrongNumber_1134 {

    public static boolean isArmstrong(int n) {
        int kPower = String.valueOf(n).length();
        System.out.println("K: " + kPower);
        int originalNum = n;
        int sum = 0;
        while (n > 0) {
            sum += (int) Math.pow((double) n % 10, (double) kPower);
            n = n / 10;
        }
        return sum == originalNum;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }
}
