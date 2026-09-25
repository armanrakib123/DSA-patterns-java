package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 143. Reorder List
 * Category: Medium (Fast & Slow + Reverse + Merge)
 * 
 * Problem: You are given the head of a singly linked-list. L0 → L1 → … → Ln-1 → Ln
 * Reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 */
public class reorder_list {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Approach: Combined Patterns 1. Find middle of list. 2. Reverse second
     * half. 3. Merge two halves.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Cut list into two halves
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Merge two halves
        ListNode first = head;
        ListNode second = prev; // Head of reversed second half
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    /*
     * Software Company Interview Note:
     * This problem is a "grand finale" for Linked List basics. 
     * It combines three distinct patterns into one elegant solution.
     */
}
