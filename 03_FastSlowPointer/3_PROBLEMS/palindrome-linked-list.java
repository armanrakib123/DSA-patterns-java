package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 234. Palindrome Linked List
 * Category: Medium (Fast & Slow + Reverse Pattern)
 * 
 * Problem: Given the head of a singly linked list, return true if it is a palindrome.
 */
public class palindrome_linked_list {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Approach: Fast & Slow Pointers + Reverse half the list 1. Find the middle
     * of the linked list. 2. Reverse the second half of the list. 3. Compare
     * the first half and the reversed second half.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
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
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Compare halves
        ListNode left = head;
        ListNode right = prev; // Head of reversed second half
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    /*
     * Software Company Interview Note:
     * Using a stack or copying to an array takes O(N) space. 
     * The O(1) space solution (modifying the list) is what Software Company interviewers look for.
     */
}
