package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 69. Sqrt(x)
 * Category: Easy
 * 
 * Problem: Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, 
 * and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
public class sqrtx {

    /**
     * Approach: Binary Search on Answer
     * The square root of x will always lie between 1 and x.
     * So our search space is [1, x]. Since this sequence is sorted, we can apply Binary Search.
     * 
     * Time Complexity: O(log X)
     * Space Complexity: O(1)
     */
    public int mySqrt(int x) {
        // Base cases
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        int left = 1;
        int right = x / 2; // Optimization: sqrt(x) is always <= x/2 for x >= 2
        int ans = 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // To prevent Integer Overflow (mid * mid > Integer.MAX_VALUE),
            // Instead of checking (mid * mid == x), we check (mid == x / mid)
            if (mid == x / mid) {
                return mid; // Exact square root found
            } else if (mid < x / mid) {
                // mid*mid is less than x, so it could be the answer
                // record it, and try to find a larger one on the right
                ans = mid; 
                left = mid + 1;
            } else {
                // mid*mid is greater than x, so search left
                right = mid - 1;
            }
        }
        
        return ans; // 'ans' stores the truncated integer part
    }

    /*
     * FAANG Interview Note:
     * This is the perfect introduction to the "Binary Search on Answer" pattern.
     * The most critical part here is avoiding Integer Overflow.
     * Many candidates write `if (mid * mid <= x)`. If mid is 100,000, `mid * mid` 
     * exceeds 2.14 billion (Integer.MAX_VALUE) and becomes negative, breaking the logic.
     * Always use division: `if (mid <= x / mid)`.
     */
}
