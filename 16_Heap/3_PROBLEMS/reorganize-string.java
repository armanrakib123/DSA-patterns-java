package 

23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 767. Reorganize String Category: Medium (Greedy + Heap)
 *
 * Problem: Reorganize characters so that no two adjacent characters are the
 * same.
 */
public class reorganize_string {

    /**
     * Approach: Max-Heap (Frequency based) Always pick the most frequent
     * character that is different from the previous one.
     *
     * Time Complexity: O(N log 26) -> O(N) Space Complexity: O(26) -> O(1)
     */
    public String reorganizeString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        pq.addAll(counts.keySet());

        StringBuilder res = new StringBuilder();
        Queue<Character> waitQueue = new LinkedList<>();

        while (!pq.isEmpty()) {
            char curr = pq.poll();
            res.append(curr);
            counts.put(curr, counts.get(curr) - 1);
            waitQueue.offer(curr);

            // Re-add to heap only after another char has been used
            if (waitQueue.size() >= 2) {
                char front = waitQueue.poll();
                if (counts.get(front) > 0) {
                    pq.offer(front);
                }
            }
        }

        return res.length() == s.length() ? res.toString() : "";
    }

    /*
     * Software Company Interview Note:
     * This "Greedy with WaitQueue" pattern is very common for scheduling problems 
     * where you cannot repeat the same task immediately.
     */
}
