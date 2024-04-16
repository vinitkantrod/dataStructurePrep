package org.vinit.datastructure.leetcode75.twoPointers;

public class Easy_MoveZeros_283 {

    public void moveZeroes(int[] nums) {
//        int i = 0;
//        while (i < nums.length) {
//            while (i < nums.length && nums[i] != 0) i++;
//            int j = i;
//            while (j < nums.length && nums[j] == 0) j++;
//            int temp = nums[j];
//            nums[j] = nums[i];
//            nums[i] = temp;
//        }
        int nonZero=0;
        for(int i:nums){
            if(i!=0){
                nums[nonZero]=i;
                nonZero++;
            }
        }
        while(nonZero<nums.length){
            nums[nonZero]=0;
            nonZero++;
        }
    }
}
