package org.vinit.datastructure.leetcode.leetcode75.arrayStrings;

import java.util.Arrays;

public class Medium_ProductOfArrayExceptItself_238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];
        productArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productArr[i] = productArr[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productArr[i] = productArr[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return productArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
