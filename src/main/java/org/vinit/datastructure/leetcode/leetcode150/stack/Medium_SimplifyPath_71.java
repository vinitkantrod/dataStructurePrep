package org.vinit.datastructure.leetcode.leetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

public class Medium_SimplifyPath_71 {

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("") || s.equals(".")) continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
}
