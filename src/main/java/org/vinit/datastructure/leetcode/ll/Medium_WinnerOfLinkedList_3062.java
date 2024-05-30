package org.vinit.datastructure.leetcode.ll;

public class Medium_WinnerOfLinkedList_3062 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public String gameResult(ListNode head) {
//        int oddCount = 0;
//        int evenCount = 0;
//        int indexCount = 0;
//        int prevVal = Integer.MAX_VALUE;
//        ListNode curr = head;
//        while (curr != null) {
//            if (indexCount % 2 == 0) {
//                prevVal = curr.val;
//            } else {
//                if (curr.val > prevVal) {
//                    oddCount++;
//                } else {
//                    evenCount++;
//                }
//            }
//            indexCount++;
//            curr = curr.next;
//        }
//        return evenCount > oddCount ? "Even" : evenCount == oddCount ? "Tie" : "Odd";

        ListNode even = head;
        int evenPoints = 0;
        int oddPoints = 0;

        // Traverse through the linked list assigning points
        while (even != null) {
            ListNode odd = even.next;
            if (even.val > odd.val) {
                evenPoints += 1;
            } else {
                oddPoints += 1;
            }
            even = odd.next;
        }

        // Return the winning team
        if (oddPoints > evenPoints) {
            return "Odd";
        } else if (oddPoints < evenPoints) {
            return "Even";
        } else {
            return "Tie";
        }
    }
}
