package org.vinit.datastructure.leetcode.leetcode150.arrays;

public class Easy_LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
//        String[] arr = s.trim().replaceAll("\\s+", " ").split(" ");
//        return arr[arr.length - 1].length();

        int c = 0;
        int f = 0;
        for(int i = s.length() -1 ; i >= 0 ; i--){
            if(s.charAt(i) != ' '){
                f = 1 ;
                c++;
            }else{
                if(f == 1){
                    break;
                }
            }
        }
        return c ;
    }
}
