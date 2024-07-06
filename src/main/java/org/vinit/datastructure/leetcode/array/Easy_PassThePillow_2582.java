package org.vinit.datastructure.leetcode.array;

public class Easy_PassThePillow_2582 {

    public int passThePillow(int n, int time) {
        boolean traverseBack = false;
        int idx = 1;
        while (time > 0) {
            if (!traverseBack) idx++;
            else idx--;
            if (idx == n || idx == 1) traverseBack = !traverseBack;
            time--;
        }
        return idx;
    }
}
