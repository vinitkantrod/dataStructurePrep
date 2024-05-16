package org.vinit.datastructure.leetcode.uberLeetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy_PascalTriangles_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int numRow = 1; numRow < numRows; numRow++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(numRow - 1);
            row.add(1);

            for (int j = 1; j < numRow; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
