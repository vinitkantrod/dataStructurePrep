package org.vinit.datastructure.strings.leetcode;

import java.util.Arrays;

public class Medium_CompareVersionNumbers_165 {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int a = 0, b = 0;
            System.out.println(i + " - " + j);
            if (i < v1.length) a = Integer.parseInt(v1[i]);
            if (j < v2.length) b = Integer.parseInt(v2[j]);
            i++;
            j++;
            System.out.println(a + " : " + b);
            if (a < b) return -1;
            else if (a > b) return 1;
            else continue;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.0"));
    }
}
