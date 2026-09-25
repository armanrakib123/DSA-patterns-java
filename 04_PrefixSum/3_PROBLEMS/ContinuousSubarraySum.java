import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        remainderMap.put(0, -1);
        
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int remainder = k == 0 ? currentSum : currentSum % k;
            
            if (remainder < 0) remainder += k;

            if (remainderMap.containsKey(remainder)) {
                int prevIndex = remainderMap.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();
        
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        
        boolean result = solution.checkSubarraySum(nums, k);
        System.out.println("Has valid subarray sum multiple of " + k + ": " + result); 
        // Expected Output: true ([2, 4] এর যোগফল 6, যা 6 এর গুণিতক)
        
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 13;
        System.out.println("Has valid subarray sum multiple of " + k2 + ": " + solution.checkSubarraySum(nums2, k2)); 
        // Expected Output: false
    }
}






















/**
 * 🎯 Problem 3: Continuous Subarray Sum (LeetCode 523)
 * লেভেল: Medium (Math + Prefix Sum)
 * 
 * প্রশ্ন: একটি integer array (nums) এবং একটি integer (k) দেওয়া আছে।
 * আপনাকে চেক করতে হবে যে এমন কোনো subarray আছে কিনা যার দৈর্ঘ্য (length) কমপক্ষে ২, 
 * এবং যার যোগফল k এর একটি গুণিতক (Multiple)। 
 * গুণিতক মানে হলো: (n * k), যেমন k, 2k, 3k ইত্যাদি (এমনকি 0 ও হতে পারে যদি k এর গুণিতক 0 হয়)।
 * 
 * 💡 Intuition (মডুলো ম্যাথ):
 * "যোগফল k এর গুণিতক" এর গাণিতিক অর্থ হলো, `sum % k == 0`।
 * কিন্তু আমরা যদি প্রিফিক্স সাম ব্যবহার করি, তবে এর একটি চমৎকার গাণিতিক ট্রিক আছে।
 * 
 * ট্রিক:
 * ধরি ইনডেক্স `i` পর্যন্ত যোগফল `S1` এবং ইনডেক্স `j` পর্যন্ত যোগফল `S2`।
 * যদি `S1 % k == x` হয় এবং `S2 % k == x` হয় (অর্থাৎ একই ভাগশেষ থাকে), 
 * তবে তাদের পার্থক্য `(S2 - S1)` অবশ্যই `k` দ্বারা বিভাজ্য হবে! 
 * (কারণ ভাগশেষগুলো বিয়োগ হয়ে জিরো হয়ে যায়)।
 * 
 * 🚀 Optimal Approach (Prefix Sum + HashMap):
 * আমরা HashMap এ (currentSum % k, Index) সেভ করে রাখব। 
 * অর্থাৎ ভাগশেষ এবং সেটি কোন ইনডেক্সে পাওয়া গেছে তা সেভ করব।
 * যদি একই ভাগশেষ আবার পাওয়া যায়, আমরা ইনডেক্সের পার্থক্য চেক করব (length >= 2 কিনা)।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(MIN(N, K)) (কারণ ম্যাপে সর্বোচ্চ K টি ভাগশেষ থাকতে পারে)
 */