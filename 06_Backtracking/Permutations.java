import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
       
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
           
            if (used[i]) continue;

            used[i] = true;
            tempList.add(nums[i]);

            backtrack(res, tempList, nums, used);

            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> result = solution.permute(nums);
        System.out.println("Permutations: " + result);
    }
}














/**
 * 🎯 Problem 1: Permutations (LeetCode 46)
 * লেভেল: Medium (Standard Backtracking)
 * 
 * প্রশ্ন: একটি ইউনিক (Unique) সংখ্যার অ্যারে `nums` দেওয়া আছে। আপনাকে এর সব সম্ভাব্য বিন্যাস (Permutations) 
 * বের করে একটি লিস্ট আকারে রিটার্ন করতে হবে। 
 * উদাহরণ: [1,2,3] -> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 💡 ব্যাকট্র্যাকিং লজিক:
 * ১. একটি রেজাল্ট লিস্ট (res) এবং একটি বর্তমান লিস্ট (tempList) নিন।
 * ২. একটি `used` বুলিয়ান অ্যারে নিন ট্র্যাক রাখার জন্য যে কোন সংখ্যাটি অলরেডি নেওয়া হয়েছে।
 * ৩. রিকার্সিভলি প্রতিটি সংখ্যা ট্রাই করুন:
 *    - যদি সংখ্যাটি অলরেডি ব্যবহৃত হয়, তবে স্কিপ করুন।
 *    - নতুবা, সংখ্যাটি `tempList` এ অ্যাড করুন এবং `used` ট্রু করে পরের স্টেপে যান।
 *    - ফিরে আসার সময় (Backtrack), সংখ্যাটি রিমুভ করুন এবং `used` ফলস করে দিন।
 * 
 * Time Complexity: O(N * N!)
 * Space Complexity: O(N)
 */