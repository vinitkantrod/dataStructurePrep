package org.vinit.datastructure.leetcode.ll;

import java.util.List;

public class Medum_RotateLL_61 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        int listLen = 0;
        ListNode c = head;
        while (c != null) {
            listLen++;
            c = c.next;
        }
        k %= listLen;
        if (k == 0) return head;
        ListNode reverseHead = reverse(head);
        printLL(reverseHead);
        ListNode first = reverseHead;
        ListNode second = null;
        while (first != null && k - 1 > 0) {
            first = first.next;
            k--;
        }
        second = first.next;
        first.next = null;
        ListNode khead = reverse(reverseHead);
        printLL(khead);
        ListNode firstNext = khead;
        while (firstNext.next != null) {
            firstNext = firstNext.next;
        }
        ListNode secondRev = reverse(second);
        firstNext.next = secondRev;
        printLL(khead);
        return khead;
    }
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static void printLL(ListNode l) {
        ListNode c = l;
        System.out.print("null");
        while (c != null) {
            System.out.print("->" + c.val);
            c = c.next;
        }
        System.out.println("->null");

    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode res = rotateRight(l, 9);
    }
}
