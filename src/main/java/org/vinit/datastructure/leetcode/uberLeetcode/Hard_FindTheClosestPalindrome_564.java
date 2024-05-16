package org.vinit.datastructure.leetcode.uberLeetcode;

public class Hard_FindTheClosestPalindrome_564 {

    public String nearestPalindromic(String n) {
        long N = Long.parseLong(n);
        long smaller = smaller(String.valueOf(N - 1).toCharArray());
        long larger = next(String.valueOf(N + 1).toCharArray());
        if (N - smaller > larger - N) return String.valueOf(larger);
        return String.valueOf(smaller);
    }

    public long smaller(char[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] != nums[right]) {
                decrement(nums, right);
                if (nums[0] == '0') return Long.parseLong(new String(nums));
            }
            left++;
            right--;
        }
        return Long.parseLong(new String(nums));
    }
    public void decrement(char[] nums, int index) {
        while (nums[index] == '0') {
            nums[index] = '9';
            index--;
        }
        nums[index]--;
    }
    private long next (char[] num){
        int left = 0, right = num.length-1;
        while (left < right){
            while (num[left] != num[right]){
                increment(num, right);
            }
            left++;
            right--;
        }
        return Long.parseLong(new String(num));
    }
    private void increment(char[] num, int indx){
        while (num[indx] == '9'){
            num[indx] = '0';
            indx--;
        }
        num[indx]++;
    }
}
