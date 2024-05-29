package org.vinit.datastructure.hackerrank;

import lombok.val;

public class Easy_MergeTwoSortedLinkedList {

    static class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
     }
    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode dummy = new SinglyLinkedListNode();
        SinglyLinkedListNode curr = dummy;
        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        while (head1 != null) {
            curr.next = head1;
            head1 = head1.next;
        }
        while (head2 != null) {
            curr.next = head2;
            head2 = head2.next;
        }
        return dummy.next;
    }
}
