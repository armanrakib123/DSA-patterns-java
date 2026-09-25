package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * InterviewBit / GeeksForGeeks: Painter's Partition Problem
 * Category: Medium (Same logic as Split Array Largest Sum)
 * 
 * Problem: Given 2 integers A and B and an array of integers C of size N. 
 * Element C[i] represents the length of ith board. 
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. 
 * There are A painters available and each of them takes B units of time to paint 1 unit of board. 
 * Calculate and return minimum time required to paint all boards under the constraints that 
 * any painter will only paint contiguous sections of board.
 * Return the ans % 10000003.
 */
public class painter_partition {

    /**
     * Approach: Binary Search on Answer
     * This is mathematically identical to "Split Array Largest Sum" and "Allocate Books".
     * The maximum time any painter takes will determine the total time.
     * We want to minimize this maximum time.
     * 
     * Time Complexity: O(N log(Sum))
     * Space Complexity: O(1)
     */
    public int paint(int A, int B, int[] C) {
        long low = 0;
        long high = 0;
        
        for (int board : C) {
            low = Math.max(low, board); // A single board MUST be painted by 1 painter
            high += board; // 1 painter paints all boards
        }
        
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isPossible(C, A, mid)) {
                ans = mid; // Try to minimize time
                high = mid - 1;
            } else {
                low = mid + 1; // Time is too small, need more time
            }
        }
        
        // Multiply by B (time per unit) and modulo
        // We multiply AFTER the binary search to prevent massive overflow during the search
        return (int) ((ans * B) % 10000003);
    }
    
    private boolean isPossible(int[] boards, int maxPainters, long maxTimeAllowed) {
        int paintersUsed = 1;
        long currentTime = 0;
        
        for (int board : boards) {
            if (currentTime + board > maxTimeAllowed) {
                paintersUsed++;
                currentTime = board;
            } else {
                currentTime += board;
            }
            
            if (paintersUsed > maxPainters) {
                return false;
            }
        }
        
        return true;
    }

    /*
     * FAANG Interview Note:
     * A common trap here is multiplying the board lengths by 'B' BEFORE doing the Binary Search.
     * While technically correct, it causes massive integer overflows.
     * The senior approach is to binary search the "Units of Board", find the minimum maximum units,
     * and THEN multiply the final answer by 'B' (modding immediately).
     */
}
