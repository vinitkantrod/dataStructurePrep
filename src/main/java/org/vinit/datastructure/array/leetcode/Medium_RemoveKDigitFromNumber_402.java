package org.vinit.datastructure.array.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Medium_RemoveKDigitFromNumber_402 {

    public static String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        Boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            sb.append(digit);
            leadingZero = false;
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
//        char[] ch = new char[num.length() + 1];
//        int i = 0;
//        for (char c: num.toCharArray()) {
//            ch[i++] = c;
//        }
//        if (k == num.length()) return "0";
//        int index = 0;
//        while (k > 0 && index < ch.length - 1) {
//            if (ch[index] >= ch[index + 1]){
//                ch[index] = '/';
//                k--;
//            }
//            index++;
//        }
////        System.out.println(Arrays.toString(ch));
//        StringBuilder sb = new StringBuilder();
//        for (char c : ch) {
//            if (Character.isDigit(c)) sb.append(c);
//        }
//        return String.valueOf(Integer.parseInt(sb.toString()));
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 1));
        System.out.println(removeKdigits("1089", 3));
    }
}
