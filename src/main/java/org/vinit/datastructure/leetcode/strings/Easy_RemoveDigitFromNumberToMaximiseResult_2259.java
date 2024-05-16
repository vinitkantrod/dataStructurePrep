package org.vinit.datastructure.leetcode.strings;

public class Easy_RemoveDigitFromNumberToMaximiseResult_2259 {

    public String removeDigit(String number, char digit) {
        int index = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                index = i;
                if (i < number.length() - 1 && digit < number.charAt(i + 1)) break;;
            }
        }
        return number.substring(0, index) + number.substring(index + 1);
    }
}
