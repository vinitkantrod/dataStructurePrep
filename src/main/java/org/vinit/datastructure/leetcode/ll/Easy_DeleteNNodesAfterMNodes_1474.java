package org.vinit.datastructure.leetcode.ll;

public class Easy_DeleteNNodesAfterMNodes_1474 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode last = head;
        while (curr != null) {
            int mCount = m, nCount = n;
            while (curr != null && mCount != 0) {
                last = curr;
                curr = curr.next;
                mCount--;
            }
            while (curr != null && nCount != 0) {
                curr = curr.next;
                nCount--;
            }
            last.next = curr;
        }
        return head;
    }
}
