package org.vinit.datastructure.leetcode.dp.decisionMaking;

public class Medium_HouseRobber_198 {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int a = nums[0];
        int b= Math.max(a, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int t = a;
            a = b;
            b = Math.max(a, t + nums[i]);
        }
        return b;

//        int[] maxRobbedElement = new int[nums.length + 1];
//        if (nums.length == 0) return 0;
//        maxRobbedElement[nums.length] = 0;
//        maxRobbedElement[nums.length - 1] = nums[nums.length - 1];
//        for (int i = nums.length - 2; i >=0; i--) {
//            maxRobbedElement[i] = Math.max(
//                    maxRobbedElement[i + 1], maxRobbedElement[i + 2]
//             + nums[i]);
//        }
//        return maxRobbedElement[0];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,0,0,9,3,1}));
    }
}
