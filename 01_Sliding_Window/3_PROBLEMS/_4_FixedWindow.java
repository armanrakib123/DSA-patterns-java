/**
 * Fixed Size Sliding Window Example
 * LeetCode 643: Maximum Average Subarray I (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array (nums) এবং একটি integer (k) দেওয়া আছে। 
 * আপনাকে এমন একটি k-সাইজের contiguous subarray (পাশাপাশি ইলিমেন্ট) খুঁজে বের করতে হবে, 
 * যার এভারেজ (গড়) সবচেয়ে বেশি। এবং সেই ম্যাক্সিমাম এভারেজ রিটার্ন করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. প্রথমে আমরা array এর প্রথম k টা ইলিমেন্ট যোগ করে একটি 'উইন্ডো' (Window) তৈরি করব।
 * ২. এরপর উইন্ডোটি ডানদিকে সরাতে থাকব।
 * ৩. প্রতিবার স্লাইড করার সময়:
 *    - নতুন যে ইলিমেন্টটি উইন্ডোতে ঢুকল (nums[i]) সেটি যোগ করব।
 *    - যে ইলিমেন্টটি উইন্ডো থেকে বের হয়ে গেল (nums[i - k]) সেটি বিয়োগ করব।
 * ৪. প্রতি ধাপে আমরা ম্যাক্সিমাম যোগফল (Max Sum) ট্র্যাক করব।
 * ৫. শেষে Max Sum কে k দিয়ে ভাগ করে এভারেজ রিটার্ন করব।
 * 
 * Time Complexity: O(N) - কারণ আমরা Array টি মাত্র একবার ভিজিট করছি।
 * Space Complexity: O(1) - কারণ আমরা এক্সট্রা কোনো মেমরি ব্যবহার করছি না।
 */



public class _4_FixedWindow {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0.0;
        }

        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }

    public static void main(String[] args) {
        _4_FixedWindow solution = new _4_FixedWindow();
        int[] nums = {0,4,0,3,2};
        int k = 1;
        
        System.out.println("Maximum Average: " + solution.findMaxAverage(nums, k));
        // Output হবে 12.75 কারণ (12 + -5 + -6 + 50) / 4 = 51 / 4 = 12.75
    }
}
