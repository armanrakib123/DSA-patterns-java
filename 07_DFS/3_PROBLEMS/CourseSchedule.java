import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, state)) return false;
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] == 1) return true; // সাইকেল পাওয়া গেছে!
        if (state[node] == 2) return false; // অলরেডি ভিজিটেড এবং ভ্যালিড

        state[node] = 1; // বর্তমান পাথে আছে
        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, state)) return true;
        }

        state[node] = 2; // পাথ শেষ
        return false;
    }

    // টাইম কমপ্লেক্সিটি: O(V + E)
    // স্পেস কমপ্লেক্সিটি: O(V + E)
}















/**
 * 🎯 Problem: Course Schedule (LeetCode 207)
 * লেভেল: Medium (Graph DFS / Cycle Detection)
 * 
 * প্রশ্ন: কিছু কোর্স এবং তাদের প্রি-রিকুইজিট দেওয়া আছে। সব কোর্স শেষ করা কি সম্ভব?
 * 
 * 💡 DFS ইন্টুইশন:
 * এটি একটি ডিরেক্টেড গ্রাফ। যদি গ্রাফে কোনো সাইকেল (Cycle) থাকে, তবে কোর্স করা সম্ভব নয়। 
 * আমরা DFS ব্যবহার করব এবং প্রতিটি নোডকে তিনটি স্টেটে রাখব: 
 * 0: Not Visited, 1: Visiting (In current path), 2: Fully Visited.
 */