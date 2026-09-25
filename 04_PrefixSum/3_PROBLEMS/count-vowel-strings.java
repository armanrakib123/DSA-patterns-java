package 03_PREFIX_SUM_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 2559. Count Vowel Strings in Ranges
 * Category: Medium
 * 
 * Problem: You are given a 0-indexed array of strings words and a 2D array of integers queries.
 * Each query queries[i] = [li, ri] asks us to find the number of strings present in the 
 * range li to ri (both inclusive) of words that start and end with a vowel.
 * Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
 */
public class count_vowel_strings {

    /**
     * Approach: 1D Prefix Sum Array
     * Instead of checking vowels for each query (which takes O(N * Q)), we create a boolean array
     * mapping to 1 if a word starts and ends with a vowel, else 0.
     * Then we build a Prefix Sum array on this boolean array to answer range queries in O(1).
     * 
     * Time Complexity: O(N + Q)
     * Space Complexity: O(N + Q)
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        // 1-based prefix sum array
        int[] prefix = new int[n + 1];
        
        // Build the prefix sum array
        for (int i = 0; i < n; i++) {
            if (isVowelString(words[i])) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        
        // Answer the queries
        int q = queries.length;
        int[] ans = new int[q];
        
        for (int i = 0; i < q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // 1-based index query: prefix[right+1] - prefix[left]
            ans[i] = prefix[right + 1] - prefix[left];
        }
        
        return ans;
    }
    
    // Helper function to check if word starts and ends with a vowel
    private boolean isVowelString(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /*
     * FAANG Interview Note:
     * This is a great example of converting a complex property (string starts/ends with vowel) 
     * into a simple binary state (1 or 0), and then applying the standard Prefix Sum pattern.
     * It tests your ability to abstract a problem down to its core algorithmic pattern.
     */
}
