package org.vinit.datastructure.leetcode.design;

import java.util.*;

public class Hard_InsertDeleteGetRandomDuplicateAllowed_381 {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> map;
        List<Integer> list;
        Random random = new Random();
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) map.put(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(list.size(), val);
            return map.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).size() == 0) return false;
            int remove_idx = map.get(val).iterator().next();
            map.get(val).remove(remove_idx);
            int last = list.get(list.size() - 1);
            list.set(remove_idx, last);
            map.get(last).add(remove_idx);
            map.get(last).remove(list.size() - 1);

            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
