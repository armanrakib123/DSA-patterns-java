package 15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 141. Linked List Cycle
 * Category: Easy (Fundamental Fast & Slow)
 * 
 * Problem: Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
public class linked_list_cycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Approach: Floyd's Cycle-Finding Algorithm (Fast & Slow Pointers)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step
            fast = fast.next.next;    // 2 steps
            
            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        
        // If we reach null, no cycle exists
        return false;
    }

    /*
     * FAANG Interview Note:
     * Interviewers might ask: "Why 1 and 2 steps? Can we use 1 and 3?"
     * Answer: Yes, but 2 steps is the most efficient because the distance 
     * between pointers decreases by 1 in every step, ensuring they won't 
     * "jump over" each other in the cycle.
     */
}
