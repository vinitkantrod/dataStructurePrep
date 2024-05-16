package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

public class Medium_StringCompression_443 {

    public static int compress(char[] chars) {
        if(chars.length == 1) return chars.length;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char prevChar = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1] ) count++;
            else {
                sb.append(chars[i]);
                if (count > 1) sb.append(count);
                count = 1;
            }
        }
        System.out.println(sb.toString());
        char[] compressedChars = sb.toString().toCharArray();
        System.arraycopy(compressedChars, 0, chars, 0, compressedChars.length);
        return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b'}));
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','a'}));
    }
}
