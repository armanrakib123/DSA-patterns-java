package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 392. Is Subsequence
 * Category: Easy (Greedy / Two Pointers)
 */
public class is_subsequence {

    /**
     * Approach: Greedy (Two Pointers)
     * At each step, take the first available match.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        
        int sIdx = 0, tIdx = 0;
        while (tIdx < t.length()) {
            if (t.charAt(tIdx) == s.charAt(sIdx)) {
                sIdx++;
                if (sIdx == s.length()) return true;
            }
            tIdx++;
        }
        
        return false;
    }
}
