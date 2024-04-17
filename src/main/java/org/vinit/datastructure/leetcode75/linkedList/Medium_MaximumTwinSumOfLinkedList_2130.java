package org.vinit.datastructure.leetcode75.linkedList;

public class Medium_MaximumTwinSumOfLinkedList_2130 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static int pairSum(ListNode head) {
        // Break LL into 2
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy, temp = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        temp = slow.next;
        slow.next = null;
        // Print
//        ListNode iter = head;
//        while (iter != null) {
//            System.out.print(iter.val+"->");
//            iter = iter.next;
//        }
//        System.out.println("");
        // Reverse Second LL
        ListNode prev = null, curr = temp, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Print
//        iter = prev;
//        while (iter != null) {
//            System.out.print(iter.val+"->");
//            iter = iter.next;
//        }
//        System.out.println("");
        // Compute Sum of Twin
        int maxSum = 0;
        ListNode traverseNode = head;
        while (traverseNode != null) {
            int tempVal = prev.val + head.val;
            maxSum = Math.max(maxSum, tempVal);
            prev = prev.next;
            head = head.next;
            traverseNode = head;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
        l.next = new ListNode(4);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(1);
        System.out.println(pairSum(l));
    }
}
