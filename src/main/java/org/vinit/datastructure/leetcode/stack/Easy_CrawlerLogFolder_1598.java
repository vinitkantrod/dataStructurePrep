package org.vinit.datastructure.leetcode.stack;

import java.util.Stack;

public class Easy_CrawlerLogFolder_1598 {

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (stack.size() >= 1) stack.pop();
                else continue;
            } else if (log.equals("./")) continue;
            else {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
