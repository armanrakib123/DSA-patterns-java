package 23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.PriorityQueue;

/**
 * LeetCode 23. Merge k Sorted Lists
 */
public class merge_k_sorted_lists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            curr.next = smallest;
            curr = curr.next;
            if (smallest.next != null) pq.offer(smallest.next);
        }
        return dummy.next;
    }
}
