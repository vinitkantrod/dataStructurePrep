package org.vinit.datastructure.leetcode.ll;

public class Easy_IntersectionOfTwoLL_160 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = (h1 != null) ? h1.next : headB;
            h2 = (h2 != null) ? h2.next : headA;
        }
        return h1;
    }
}
