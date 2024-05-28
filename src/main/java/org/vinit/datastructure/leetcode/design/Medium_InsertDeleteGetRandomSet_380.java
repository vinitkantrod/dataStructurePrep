package org.vinit.datastructure.leetcode.design;

import java.util.*;

public class Medium_InsertDeleteGetRandomSet_380 {

    class RandomizedSet {

        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand;
        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;
            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;
            int lastIdxVal = list.get(list.size() - 1);
            int valIdx = dict.get(val);
            list.set(valIdx, lastIdxVal);
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
