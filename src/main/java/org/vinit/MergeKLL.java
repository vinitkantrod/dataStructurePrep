package org.vinit;

import java.util.PriorityQueue;

public class MergeKLL {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        // base case:
        if (lists.length == 0) return null;
        // create min heap
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        // maintain K nodes in heap
        for (ListNode nodes : lists) {
            if (nodes == null) continue;
            heap.offer(nodes);
        }
        // Result node
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        // iterate till heap is empty
        while (!heap.isEmpty()) {
            ListNode rootNode = heap.poll();    // Root node
            current.next = rootNode;
            // insert next node if ll not empty
            if (rootNode.next != null) {
                heap.offer(rootNode.next);  // O(logk) - balancing
            }
            current = current.next;
        }
        return dummy.next;
    }
}
