package org.vinit.datastructure.leetcode75.dp1D;

public class Easy_NthTribonacci_1137 {

    public static int tribonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        if (n == 0) return first;
        if (n == 1 || n == 2) return second;
        while (n - 1 > 0) {
            int curr = first + second + third;
            first = second;
            second = third;
            third = curr;
            n--;
            System.out.println(n + " - " + first + " - " + second);
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
