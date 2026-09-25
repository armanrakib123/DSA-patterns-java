package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 876. Middle of the Linked List
 * Category: Easy (Fast & Slow Pointers)
 * 
 * Problem: Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class middle_of_linked_list {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Approach: Fast & Slow Pointers When fast reaches the end, slow will be at
     * the middle.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /*
     * Software Company Interview Note:
     * This is a building block for more complex problems like "Sort List" or 
     * "Palindrome Linked List". Mastering this 3-line logic is essential.
     */
}
