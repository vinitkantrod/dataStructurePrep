package org.vinit.datastructure.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Medium_SwapNodes {

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        for (int k : queries) {
            swap(indexes, 0, 1, k);
            // inorder
            List<Integer> r = new ArrayList<>();
            res.add(inorder(indexes, r, 0));
        }
        return res;
    }
    static List<Integer> inorder(List<List<Integer>> indexes, List<Integer> list, int i) {
        if (indexes.get(i).get(0) != -1) {
            inorder(indexes, list, indexes.get(i).get(0) - 1);
        }
        list.add(i+1);
        if (indexes.get(i).get(1) != -1) {
            inorder(indexes, list, indexes.get(i).get(1) - 1);
        }
        return list;
    }

    static void swap(List<List<Integer>> indexes, int i, int level, int k) {
        if (level % k == 0) {
            List<Integer> node = indexes.get(i);
            int temp = node.get(0);
            node.set(0, node.get(1));
            node.set(1, temp);
            indexes.set(i, node);
        }
        if (indexes.get(i).get(0) != -1) {
            swap(indexes, indexes.get(i).get(0) - 1, level + 1, k);
        }
        if (indexes.get(i).get(1) != -1) {
            swap(indexes, indexes.get(i).get(1) - 1, level + 1, k);
        }

    }
}
