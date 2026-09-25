package 30_DISJOINT_SET_UNION_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 990. Satisfiability of Equality Equations
 * Category: Medium (DSU)
 */
public class satisfiability_of_equality_equations {

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        
        // 1. Process all "==" equations first to build components
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                union(parent, eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }
        
        // 2. Check all "!=" equations for contradictions
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (find(parent, eq.charAt(0) - 'a') == find(parent, eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
    
    private void union(int[] parent, int i, int j) {
        int r1 = find(parent, i);
        int r2 = find(parent, j);
        if (r1 != r2) parent[r1] = r2;
    }
}
