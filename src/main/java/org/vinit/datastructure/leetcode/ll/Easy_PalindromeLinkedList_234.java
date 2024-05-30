package org.vinit.datastructure.leetcode.ll;

public class Easy_PalindromeLinkedList_234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=reverse(slow);
        ListNode temp1=head;
        while(temp!=null){
            if(temp1.val!=temp.val){
                return false;
            }
            temp=temp.next;
            temp1=temp1.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
