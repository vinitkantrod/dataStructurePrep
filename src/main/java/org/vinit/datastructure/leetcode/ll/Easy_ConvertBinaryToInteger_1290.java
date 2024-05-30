package org.vinit.datastructure.leetcode.ll;

public class Easy_ConvertBinaryToInteger_1290 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int getDecimalValue(ListNode head) {
        int listCount = 0;
        ListNode curr = head;
        while (curr != null) {
            listCount++;
            curr = curr.next;
        }
        int res = 0;
        curr = head;
        while (listCount > 0) {
            res += ((curr.val * (int) Math.pow(2, listCount - 1)));
            listCount--;
            curr = curr.next;
        }
        return res;
    }
}
