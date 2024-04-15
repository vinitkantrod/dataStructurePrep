package org.vinit.datastructure.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_PascalTriangleTwo_119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int rowNum = 1; rowNum <= rowIndex; rowNum++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < rowNum; j++) row.add(result.get(j - 1) + result.get(j));
            row.add(1);
            result = row;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(getRow(3)));
    }
}
