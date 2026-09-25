import java.util.HashMap;

public class _4_SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum += nums[i];

            int targetPrefix = currentPrefixSum - k;

            if (map.containsKey(targetPrefix)) {
                count += map.get(targetPrefix);
            }

            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        _4_SubarraySum solution = new _4_SubarraySum();
        
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Number of subarrays: " + solution.subarraySum(nums, k)); 
        
        int[] nums2 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k2 = 7;
        System.out.println("Number of subarrays: " + solution.subarraySum(nums2, k2)); 
    }
}






















/**
 * Prefix Sum with HashMap Example
 * LeetCode 560: Subarray Sum Equals K (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array (nums) এবং একটি integer (k) দেওয়া আছে। 
 * আপনাকে বলতে হবে array এর ভেতরে মোট কতগুলো continuous subarray আছে 
 * যাদের ইলিমেন্টগুলোর যোগফল ঠিক k এর সমান।
 * (এখানে পজিটিভ ও নেগেটিভ দুই ধরনের নাম্বারই থাকতে পারে, তাই Sliding Window কাজ করবে না!)
 * 
 * এপ্রোচ (Approach):
 * ১. Sliding Window কাজ করবে না কারণ নেগেটিভ নাম্বারের কারণে যোগফল যেকোনো সময় কমতে বা বাড়তে পারে। 
 *    তাই আমরা Prefix Sum + HashMap ব্যবহার করব।
 * ২. একটি HashMap এ আমরা সেভ রাখব কোন প্রিফিক্স সাম কতবার পেয়েছি (Prefix Sum -> Count)।
 * ৩. প্রতি ধাপে array এর ইলিমেন্ট যোগ করে currentPrefixSum বানাবো।
 * ৪. এরপর চেক করব যে (currentPrefixSum - k) আগে কখনো পেয়েছি কি না। 
 *    যদি পেয়ে থাকি, তার মানে সেই আগের পয়েন্ট থেকে বর্তমান পয়েন্ট পর্যন্ত সাব-অ্যারের যোগফল ঠিক k!
 * ৫. যদি পাই, তবে সেই কাউন্ট রেজাল্টে যোগ করব।
 * ৬. সবশেষে currentPrefixSum কে ম্যাপে আপডেট করব।
 * 
 * Time Complexity: O(N) - কারণ Array টি মাত্র একবার ভিজিট করছি।
 * Space Complexity: O(N) - HashMap এর জন্য।
 */