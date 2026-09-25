package 

24_GREEDY_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 763. Partition Labels Category: Medium (Greedy + Hashing)
 */
public class partition_labels {

    /**
     * Approach: Last Occurrence tracking For each character, find its last
     * occurrence. The partition must be at least as far as the last occurrence
     * of any character inside it.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    /*
     * Software Company Interview Note:
     * This is a greedy problem because we make the smallest possible partition 
     * that satisfies the constraint at each step.
     */
}
