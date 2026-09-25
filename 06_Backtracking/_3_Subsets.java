import java.util.ArrayList;
import java.util.List;

public class _3_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, int start) {
        result.add(new ArrayList<>(currentList));

        for (int i = start; i < nums.length; i++) {
            
            currentList.add(nums[i]);
            
            backtrack(result, currentList, nums, i + 1);
            
            currentList.remove(currentList.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        _3_Subsets solution = new _3_Subsets();
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> allSubsets = solution.subsets(nums);
        System.out.println("All subsets: " + allSubsets);
        // Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}
























/**
 * Subsets Example
 * LeetCode 78: Subsets (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array (nums) দেওয়া আছে যেখানে সবগুলো নম্বর ইউনিক (unique)।
 * আপনাকে এর সম্ভাব্য সব সাবসেট (Subsets/Power set) রিটার্ন করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * এটি ব্যাকট্র্যাকিং এর সবচেয়ে বেসিক প্রবলেম। 
 * প্রতিটি ইলিমেন্টের জন্য আমাদের দুটি অপশন আছে:
 * ১. তাকে লিস্টে নেব।
 * ২. তাকে লিস্টে নেব না।
 * 
 * আমরা টেমপ্লেট ফলো করে রিকার্সন ট্রি (Recursion Tree) তৈরি করব।
 * 
 * Time Complexity: O(N * 2^N) - কারণ 2^N টি সাবসেট হয় এবং প্রতিটিতে N সময় লাগতে পারে কপি করার জন্য।
 * Space Complexity: O(N) - রিকার্সন স্ট্যাক (Recursion Stack) এর জন্য।
 */