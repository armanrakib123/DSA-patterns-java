package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 19. Remove Nth Node From End of List
 * Category: Medium (Two Pointers / Fast & Slow)
 * 
 * Problem: Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class remove_nth_from_end {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Approach: Fast & Slow Pointers (Two Pointers) 1. Move the fast pointer n
     * steps ahead. 2. Move both slow and fast pointers until fast reaches the
     * end. 3. Slow will be pointing to the node before the one to be removed.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 1. Move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 2. Move both until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. Remove the nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    /*
     * Software Company Interview Note:
     * Using a dummy node simplifies the edge case where the head itself needs to be removed.
     */
}
