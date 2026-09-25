public class dsu_template {

    class DSU {
        private int[] parent;
        private int[] rank;
        private int numComponents;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            numComponents = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * Find with Path Compression
         * Time Complexity: O(alpha(N))
         */
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        /**
         * Union by Rank
         * Time Complexity: O(alpha(N))
         */
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            
            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootI] = rootJ;
                    rank[rootJ]++;
                }
                numComponents--;
                return true;
            }
            return false;
        }

        public int getNumComponents() {
            return numComponents;
        }
    }
    public static void main(String[] args) {
        dsu_template dt = new dsu_template();
        DSU dsu = dt.new DSU(5);
        
        dsu.union(0, 1);
        dsu.union(1, 2);
        System.out.println("Number of components: " + dsu.getNumComponents()); // Output: 3
        
        dsu.union(3, 4);
        System.out.println("Number of components: " + dsu.getNumComponents()); // Output: 2
        
        dsu.union(2, 3);
        System.out.println("Number of components: " + dsu.getNumComponents()); // Output: 1
    }
}
