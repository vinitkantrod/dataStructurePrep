package org.vinit.datastructure.leetcode.ll;

public class Medium_DeleteNodeFromLL_237 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
