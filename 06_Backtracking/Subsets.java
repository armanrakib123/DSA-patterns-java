import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
      
        res.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
           
            tempList.add(nums[i]);
            
            backtrack(res, tempList, nums, i + 1);
            
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println("Subsets: " + result);
    }
}
























/**
 * 🎯 Problem 2: Subsets (LeetCode 78)
 * লেভেল: Medium (Power Set / Backtracking)
 * 
 * প্রশ্ন: একটি ইউনিক সংখ্যার অ্যারে `nums` দেওয়া আছে। আপনাকে এর সব সম্ভাব্য উপসেট (Subsets/Power Set) 
 * বের করতে হবে।
 * উদাহরণ: [1,2,3] -> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 💡 ব্যাকট্র্যাকিং লজিক:
 * প্রতিটি সংখ্যার জন্য আমাদের কাছে দুটি অপশন আছে: হয় আমরা তাকে নেব, অথবা নেব না।
 * রিকার্সিভলি আমরা প্রতিটি ইনডেক্স থেকে শুরু করে সামনের দিকে আগাব এবং প্রতিটি স্টেপকে 
 * একটি ভ্যালিড উপসেট হিসেবে রেজাল্টে যোগ করব।
 * 
 * 🚀 সল্যুশন স্টেপস:
 * ১. রেজাল্টে বর্তমান লিস্টটি অ্যাড করো (শুরুতে এম্পটি লিস্ট)।
 * ২. একটি লুপ চালাও বর্তমান ইনডেক্স থেকে শেষ পর্যন্ত।
 * ৩. সংখ্যাটি অ্যাড করো -> রিকার্সন চালাও -> সংখ্যাটি রিমুভ করো (Backtrack)।
 * 
 * Time Complexity: O(N * 2^N)
 * Space Complexity: O(N)
 */