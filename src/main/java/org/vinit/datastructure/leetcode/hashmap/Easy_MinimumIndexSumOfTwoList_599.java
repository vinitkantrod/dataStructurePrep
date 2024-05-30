package org.vinit.datastructure.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy_MinimumIndexSumOfTwoList_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> h1 = new HashMap<>();
        Map<String, Integer> h2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) h1.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) h2.put(list2[i], i);
        System.out.println(h1);
        System.out.println(h2);
        int maxIndexSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        if (list1.length <= list2.length) {
            for (String s : list1) {
                if (h1.containsKey(s) && h2.containsKey(s)) {
                    int sum = h1.get(s) + h2.get(s);
                    System.out.println("S: " + sum);
                    if (sum == maxIndexSum) {
                        res.add(s);
                    }
                    if (sum < maxIndexSum) {
                        res = new ArrayList<>();
                        res.add(s);
                        maxIndexSum = sum;
                    }
                }
            }
        }
        if (list1.length > list2.length) {
            for (String s : list2) {
                if (h1.containsKey(s) && h2.containsKey(s)) {
                    int sum = h1.get(s) + h2.get(s);
                    System.out.println("S: " + sum);
                    if (sum == maxIndexSum) {
                        res.add(s);
                    }
                    if (sum < maxIndexSum) {
                        res = new ArrayList<>();
                        res.add(s);
                        maxIndexSum = sum;
                    }
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
