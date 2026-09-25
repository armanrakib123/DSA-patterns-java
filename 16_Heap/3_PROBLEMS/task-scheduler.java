package 

23_HEAP_PRIORITY_QUEUE_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 621. Task Scheduler Category: Medium (Greedy / Math / Heap)
 */
public class task_scheduler {

    /**
     * Approach: Greedy (Max-Heap) Pick the task with highest frequency to
     * execute first.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }

                time++;
                if (pq.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }

            for (int f : temp) {
                if (--f > 0) {
                    pq.offer(f);
                }
            }
        }

        return time;
    }

    /*
     * Software Company Interview Note:
     * This problem has a math formula solution too, but the Heap approach 
     * is more general and demonstrates your understanding of greedy strategies.
     */
}
