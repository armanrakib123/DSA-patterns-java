import java.util.*;

/**
 * 🎯 Problem 3: Course Schedule (LeetCode 207)
 * লেভেল: Medium (Dependency Management)
 * 
 * প্রশ্ন: আপনাকে `numCourses` টি কোর্স করতে হবে। কিছু কোর্সের প্রিরিকুইজিট দেওয়া আছে: 
 * [a, b] মানে হলো কোর্স 'a' করার আগে কোর্স 'b' করতে হবে। আপনি কি সব কোর্স শেষ করতে পারবেন?
 * 
 * 💡 ইন্টুইশন:
 * সব কোর্স শেষ করা সম্ভব হবে যদি কোর্সের ডিপেন্ডেন্সি গ্রাফে কোনো **সাইকেল (Cycle)** না থাকে। 
 * আমরা Kahn's Algorithm ব্যবহার করে এটি সহজেই চেক করতে পারি।
 * 
 * 🚀 সল্যুশন স্টেপস:
 * ১. ইনপুট থেকে অ্যাডজাসেন্সি লিস্ট এবং ইন-ডিগ্রি অ্যারে তৈরি করুন।
 * ২. Kahn's Algorithm চালান।
 * ৩. যদি শেষ পর্যন্ত আমরা সব নোড প্রসেস করতে পারি (count == numCourses), তবে উত্তর `true`।
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        // ১. গ্রাফ বিল্ড করো
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int dependency = pre[1];
            adj.get(dependency).add(course); // dependency -> course
            inDegree[course]++;
        }

        // ২. Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int next : adj.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // ৩. যদি সব কোর্স প্রসেস করা যায়
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}}; // 1 depends on 0
        System.out.println("Can finish courses? " + solution.canFinish(numCourses, prerequisites)); // true

        int[][] prerequisites2 = {{1, 0}, {0, 1}}; // 1->0 and 0->1 (Cycle)
        System.out.println("Can finish courses with cycle? " + solution.canFinish(numCourses, prerequisites2)); // false
    }
}
