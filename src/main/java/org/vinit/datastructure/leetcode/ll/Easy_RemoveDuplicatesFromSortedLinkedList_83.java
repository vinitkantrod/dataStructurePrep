package org.vinit.datastructure.leetcode.ll;

import java.util.List;

public class Easy_RemoveDuplicatesFromSortedLinkedList_83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode dummy= new ListNode(-1001);
        dummy.next = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
