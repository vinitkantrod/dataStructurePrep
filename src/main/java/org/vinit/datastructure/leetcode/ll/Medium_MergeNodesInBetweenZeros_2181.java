package org.vinit.datastructure.leetcode.ll;

public class Medium_MergeNodesInBetweenZeros_2181 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        int val = 0;
        while (curr != null) {
            if (curr.val == 0) {
                if (val != 0) {
                    ListNode temp = new ListNode(val);
                    prev.next = temp;
                    prev = prev.next;
                    val = 0;
                }
            } else {
                val += curr.val;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
