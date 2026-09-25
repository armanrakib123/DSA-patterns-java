package 15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 202. Happy Number
 * Category: Easy (Cycle Detection in Math)
 * 
 * Problem: Write an algorithm to determine if a number n is happy.
 * A happy number is defined by replacing the number by the sum of the squares of its digits 
 * repeatedly until the number equals 1. If it enters a cycle that does not include 1, it's NOT happy.
 */
public class happy_number {

    /**
     * Approach: Fast & Slow Pointers
     * This problem is equivalent to detecting a cycle in a linked list.
     * Each number is a node, and the next number (sum of squares) is the next node.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getNext(slow);         // slow moves 1 step
            fast = getNext(getNext(fast)); // fast moves 2 steps
        } while (slow != fast);
        
        // If the cycle ends at 1, it's a happy number
        return slow == 1;
    }
    
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }

    /*
     * FAANG Interview Note:
     * This problem tests your ability to map a mathematical problem to a 
     * known algorithmic pattern (Cycle Detection). 
     * Using a HashSet is another way, but it takes O(log N) space, 
     * whereas Fast & Slow pointers take O(1) space.
     */
}
