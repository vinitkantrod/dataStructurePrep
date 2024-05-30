package org.vinit.datastructure.leetcode.ll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy_LinkedListFreq_3063 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            freqMap.put(curr.val, freqMap.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        List<Integer> values = freqMap.values().stream().toList();
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for (Integer i : values) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }
}
