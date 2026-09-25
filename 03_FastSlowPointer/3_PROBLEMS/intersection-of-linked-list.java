package 15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 160. Intersection of Two Linked Lists
 * Category: Easy (Two Pointers)
 * 
 * Problem: Given the heads of two singly linked-lists headA and headB, 
 * return the node at which the two lists intersect.
 */
public class intersection_of_linked_list {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    /**
     * Approach: Two Pointers (Cycle Detection logic)
     * If two pointers travel (ListA + ListB), they will both travel the same distance 
     * and meet at the intersection point.
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // If they don't intersect, they will both reach null at the same time
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }

    /*
     * FAANG Interview Note:
     * The logic is: a + c + b = b + c + a (where c is the shared intersection part). 
     * This is a very elegant solution.
     */
}
