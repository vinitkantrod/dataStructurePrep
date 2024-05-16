package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

public class Easy_GreatestCommonDivisorOfString_1071 {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str2 + str1).equals(str1 + str2)) return "";
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
