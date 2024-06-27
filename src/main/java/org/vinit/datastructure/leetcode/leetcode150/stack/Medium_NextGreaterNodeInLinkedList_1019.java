package org.vinit.datastructure.leetcode.leetcode150.stack;

import com.fasterxml.jackson.core.JsonToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Medium_NextGreaterNodeInLinkedList_1019 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        while (head != null) {
            ans.add(0);
            while (!stack.isEmpty() && head.val > stack.peek()[1]) {
                int[] curr = stack.peek();
                int id = curr[0], val = curr[1];
                stack.pop();
                ans.set(id, head.val);
            }
            stack.push(new int[]{idx, head.val});
            head = head.next;
        }

        return ans.stream().mapToInt(i -> i).toArray();

    }


    public static void main(String[] args) {
        ListNode l = new ListNode(2);
        l.next = new ListNode(1);
        l.next.next = new ListNode(5);
        System.out.println(Arrays.toString(nextLargerNodes(l)));
        l = new ListNode(2);
        l.next = new ListNode(7);
        l.next.next = new ListNode(4);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(5);
        System.out.println(Arrays.toString(nextLargerNodes(l)));
        l = new ListNode(9);
        l.next = new ListNode(7);
        l.next.next = new ListNode(6);
        l.next.next.next = new ListNode(7);
        l.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next = new ListNode(9);
        System.out.println(Arrays.toString(nextLargerNodes(l)));
    }
}
