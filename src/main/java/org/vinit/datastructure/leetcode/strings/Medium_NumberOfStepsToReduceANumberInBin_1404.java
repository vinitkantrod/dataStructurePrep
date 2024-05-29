package org.vinit.datastructure.leetcode.strings;

public class Medium_NumberOfStepsToReduceANumberInBin_1404 {

    public static int numSteps(String s) {
        int N = s.length();
        int carry = 0, operation = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if (digit % 2 == 1) {
                operation += 2;
                carry = 1;
            } else
                operation++;
        }
        return operation + carry;
//        long val = Long.parseLong(s, 2);
//        System.out.println(val);
//        int steps = 0;
//        while (val != 1) {
//            if (val % 2 == 1) {
//                val += 1;
//            } else {
//                val /= 2;
//            }
//            steps++;
//        }
//        return steps;
    }

    public static void main(String[] args) {
//        System.out.println(numSteps("1101"));
        System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
    }
}
