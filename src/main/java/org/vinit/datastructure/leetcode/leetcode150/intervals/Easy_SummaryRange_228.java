package org.vinit.datastructure.leetcode.leetcode150.intervals;

import java.util.ArrayList;
import java.util.List;

public class Easy_SummaryRange_228 {

    public List<String> summaryRanges(int[] nums) {
//        StringBuilder sb = new StringBuilder("");
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
//                sb.append(nums[i]).append("->");
//                while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
//                    i++;
//                }
//                sb.append(nums[i]);
//                res.add(sb.toString());
//                sb.setLength(0);
//            } else {
//                sb.append(nums[i] + "");
//            }
//        }
//        return res;


        StringBuilder s = new StringBuilder("");
        List<String> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i < nums.length-1 && nums[i] == nums[i+1]-1){
                s.append(nums[i]).append("->");
                while(i < nums.length-1 && nums[i] == nums[i+1]-1){
                    i++;
                }
                s.append(nums[i]);
                list.add(s.toString());
                s.setLength(0);
            }else{
                list.add(nums[i]+"");
            }
        }
        return list;
    }
}
