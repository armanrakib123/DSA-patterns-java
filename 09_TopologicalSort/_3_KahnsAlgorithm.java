
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_KahnsAlgorithm {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        _3_KahnsAlgorithm solution = new _3_KahnsAlgorithm();

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println("Can finish? " + solution.canFinish(numCourses, prerequisites));

        int[][] cyclePrereq = {{1, 0}, {0, 1}};
        System.out.println("Can finish? " + solution.canFinish(numCourses, cyclePrereq));
    }
}






















/**
 * Kahn's Algorithm (BFS based Topological Sort)
 * LeetCode 207: Course Schedule (Medium) - Software Company Favorite
 * 
 * প্রবলেম স্টেটমেন্ট:
 * numCourses সংখ্যক কোর্স আছে (0 থেকে numCourses-1)। 
 * prerequisites নামে একটি 2D array দেওয়া আছে, যেখানে [a, b] মানে হলো কোর্স a করার আগে অবশ্যই কোর্স b করতে হবে (b -> a)।
 * আপনাকে বলতে হবে আপনি সব কোর্স শেষ করতে পারবেন কি না।
 * 
 * এপ্রোচ (Approach):
 * এটি সরাসরি Cycle Detection in Directed Graph বা Topological Sort এর প্রবলেম।
 * আমরা Kahn's Algorithm ব্যবহার করব।
 * 
 * Time Complexity: O(V + E) - যেখানে V হলো কোর্স সংখ্যা (Vertices) এবং E হলো Prerequisites (Edges)।
 * Space Complexity: O(V + E) - গ্রাফ এবং In-degree array সংরক্ষণের জন্য।
 */
