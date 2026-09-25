package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 142. Linked List Cycle II
 * Category: Medium (Fast & Slow Pointers)
 * 
 * Problem: Given the head of a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 */
public class detect_cycle_ii {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Approach: Floyd's Cycle-Finding Algorithm 1. Detect if a cycle exists
     * using slow and fast pointers. 2. Find the entry point of the cycle.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Step 2: Find entry point
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }

        return null;
    }

    /*
     * Software Company Interview Note:
     * This is a math-heavy follow-up to the standard cycle detection. 
     * The distance from head to cycle-start is same as distance from 
     * collision-point to cycle-start.
     */
}
