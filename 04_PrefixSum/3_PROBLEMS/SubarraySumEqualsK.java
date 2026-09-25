
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = solution.subarraySum(nums, k);
        System.out.println("Total subarrays with sum " + k + ": " + result);
        // Expected Output: 2 (সাবঅ্যারে [1,1] দুবার আছে)

        int[] nums2 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k2 = 7;
        System.out.println("Total subarrays with sum " + k2 + ": " + solution.subarraySum(nums2, k2));
        // Expected Output: 4
    }
}
















/**
 * 🎯 Problem 2: Subarray Sum Equals K (LeetCode 560)
 * লেভেল: Medium (Software Company Favorite)
 * 
 * প্রশ্ন: একটি integer array (nums) এবং একটি integer (k) দেওয়া আছে।
 * আপনাকে বের করতে হবে এমন কতগুলো contiguous subarray (পরপর থাকা সাবঅ্যারে) আছে যাদের যোগফল k এর সমান।
 * 
 * 💡 Brute Force Approach:
 * নেস্টেড লুপ চালিয়ে সব সাবঅ্যারে তৈরি করে যোগফল চেক করা। 
 * Time: O(N^2), Space: O(1)
 * 
 * 🤔 Sliding Window কেন কাজ করবে না?
 * কারণ এই অ্যারেতে নেগেটিভ সংখ্যা (Negative numbers) থাকতে পারে। 
 * স্লাইডিং উইন্ডোতে আমরা ধরে নিই পয়েন্টার ডানে সরালে যোগফল বাড়বে। 
 * কিন্তু নেগেটিভ সংখ্যা থাকলে এই লজিকটি ব্রেক করে যায়। 
 * তাই সাবঅ্যারের যোগফলের প্রবলেমে নেগেটিভ সংখ্যা থাকলেই Sliding Window বাদ দিয়ে Prefix Sum + HashMap ভাবতে হবে।
 * 
 * 🚀 Optimal Approach (Prefix Sum + HashMap):
 * আমরা একটি HashMap নিব যেখানে সেভ রাখব: `(prefix_sum, frequency)`
 * অর্থাৎ, কোন প্রিফিক্স সামটি আগে কতবার পেয়েছি।
 * 
 * লজিক:
 * ১. প্রতি ধাপে আমরা `currentSum` (prefix sum) আপডেট করব।
 * ২. আমরা খুঁজছি `currentSum - k` ম্যাপে আগে কখনো তৈরি হয়েছিল কিনা।
 *    যদি তৈরি হয়ে থাকে, তার মানে সেই পয়েন্ট থেকে বর্তমান পয়েন্ট পর্যন্ত সাবঅ্যারের যোগফল অবশ্যই `k`!
 * ৩. যদি থাকে, তবে `count` এর সাথে সেই `currentSum - k` এর frequency যোগ করব।
 * ৪. এরপর বর্তমান `currentSum` কে ম্যাপে অ্যাড করে রাখব ভবিষ্যতের জন্য।
 * 
 * Time Complexity: O(N) (লুপটি একবার চলবে)
 * Space Complexity: O(N) (ম্যাপের জন্য)
 */
