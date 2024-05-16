package org.vinit.datastructure.leetcode.ll;

import java.util.Stack;

public class Medium_RemoveNodesFromLL_2487 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            int currData = curr.val;
            while (!stack.isEmpty() && stack.peek().val < currData) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }
        head = null;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            top.next = head;
            head = top;
        }
        return head;
    }
}
