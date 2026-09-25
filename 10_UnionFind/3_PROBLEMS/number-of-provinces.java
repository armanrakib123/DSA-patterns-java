package 30_DISJOINT_SET_UNION_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 547. Number of Provinces
 * Category: Medium (DSU / Graph Connectivity)
 */
public class number_of_provinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        
        return dsu.count;
    }
    
    class DSU {
        int[] parent;
        int count;
        
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            this.count = n;
        }
        
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
            }
        }
    }

    /*
     * FAANG Interview Note:
     * While DFS/BFS can also solve this, DSU is often preferred 
     * for its efficiency in dynamic connectivity scenarios.
     */
}
