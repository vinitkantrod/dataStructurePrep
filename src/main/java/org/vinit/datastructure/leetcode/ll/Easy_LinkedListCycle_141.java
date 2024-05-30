package org.vinit.datastructure.leetcode.ll;

import java.util.HashSet;
import java.util.Set;

public class Easy_LinkedListCycle_141 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode slow = head;
        while (!set.contains(slow)) {
            if (slow == null) return false;
            set.add(slow);
            slow = slow.next;
        }
        return true;
    }
}
