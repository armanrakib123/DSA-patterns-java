package 

15_FAST_SLOW_POINTER_PATTERN.TEMPLATE;

/**
 * Software Company Standard Fast & Slow Pointers Template
 */
public class fast_slow_template {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Template 1: Detect Cycle (Floyd's Algorithm) Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle found
            }
        }

        return false; // No cycle
    }

    /**
     * Template 2: Find the Middle Node
     */
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // At this point, slow is at the middle node
        return slow;
    }

    /**
     * Template 3: Start of Cycle
     */
    public ListNode detectCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find collision point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle exists, now find the entry point
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow; // Cycle entry node
            }
        }
        return null;
    }
}
