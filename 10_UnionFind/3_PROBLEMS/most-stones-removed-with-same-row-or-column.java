package 30_DISJOINT_SET_UNION_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 947. Most Stones Removed with Same Row or Column
 * Category: Medium (DSU)
 * 
 * Problem: Two stones are connected if they share a row or a column. 
 * Find the max stones that can be removed.
 */
public class most_stones_removed_with_same_row_or_column {

    /**
     * Approach: DSU
     * Each connected component of size S can have S-1 stones removed.
     * Result = Total Stones - Number of Connected Components.
     */
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        for (int[] s : stones) {
            // Use ~ to distinguish row indices from column indices
            // Or use a large offset like col + 10001
            dsu.union(s[0], s[1] + 10001);
        }
        return stones.length - dsu.count;
    }
    
    class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        int count = 0;
        
        public int find(int i) {
            if (!parent.containsKey(i)) {
                parent.put(i, i);
                count++;
            }
            if (parent.get(i) == i) return i;
            parent.put(i, find(parent.get(i)));
            return parent.get(i);
        }
        
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent.put(rootI, rootJ);
                count--;
            }
        }
    }
}
