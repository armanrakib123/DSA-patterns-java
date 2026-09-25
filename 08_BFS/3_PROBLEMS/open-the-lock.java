package 19_BFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 752. Open the Lock
 */
public class open_the_lock {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) return steps;
                
                for (int j = 0; j < 4; j++) {
                    for (int d : new int[]{-1, 1}) {
                        char[] chars = curr.toCharArray();
                        int digit = (chars[j] - '0' + d + 10) % 10;
                        chars[j] = (char) (digit + '0');
                        String next = new String(chars);
                        if (!dead.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
