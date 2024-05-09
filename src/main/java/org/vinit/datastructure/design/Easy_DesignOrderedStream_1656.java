package org.vinit.datastructure.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Easy_DesignOrderedStream_1656 {
    static class OrderedStream {
        String[] values;
        int counter;
        int size;
        public OrderedStream(int n) {
            values = new String[n + 1];
            counter = 1;
            size = n;
        }

        public List<String> insert(int idKey, String value) {
            values[idKey] = value;
            List<String> response = new ArrayList<>();
            if (counter == idKey) {
                int strValue = counter;
                while (strValue <= size && !Objects.isNull(values[strValue])) {
                    response.add(values[strValue]);
                    counter++;
                    strValue++;
                }
            }
            return response;
        }
    }

    public static void main(String[] args) {
        OrderedStream o = new OrderedStream(5);
        System.out.println(Arrays.asList(o.insert(3, "cc")));
        System.out.println(Arrays.asList(o.insert(1, "aa")));
        System.out.println(Arrays.asList(o.insert(2, "bb")));
        System.out.println(Arrays.asList(o.insert(5, "ee")));
        System.out.println(Arrays.asList(o.insert(4, "dd")));
    }
}
