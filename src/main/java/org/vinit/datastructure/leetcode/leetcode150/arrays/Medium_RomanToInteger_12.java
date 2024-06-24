package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Medium_RomanToInteger_12 {
    public String intToRoman(int num) {
        final String[] thousands = new String[]{"", "M", "MM", "MMM"};
        final String[] hundreds = new String[]{"",
                "C",
                "CC",
                "CCC",
                "CD",
                "D",
                "DC",
                "DCC",
                "DCCC",
                "CM"};
        final String[] tens = new String[]{"",
                "X",
                "XX",
                "XXX",
                "XL",
                "L",
                "LX",
                "LXX",
                "LXXX",
                "XC"};
        final String[] ones = new String[]{
                "",
                "I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX"
        };

        return (
                thousands[num / 1000] +
                        hundreds[(num % 1000) / 100] +
                        tens[(num % 100) / 10] +
                        ones[num % 10]
                );
    }
}
