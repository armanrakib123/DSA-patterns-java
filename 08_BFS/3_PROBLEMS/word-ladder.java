package 19_BFS_PATTERN.TOP_10_PROBLEMS;

import java.util.*;

/**
 * LeetCode 127. Word Ladder
 */
public class word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return steps;
                
                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    chars[j] = old;
                }
            }
            steps++;
        }
        return 0;
    }
}
