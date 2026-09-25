public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            // Grow the window
            currentSum += nums[right];
            
            // Valid Window, try to shrink it
            while (currentSum >= target) {
                // Update the result
                minLength = Math.min(minLength, right - left + 1);
                
                // Shrink
                currentSum -= nums[left];
                left++;
            }
        }
        
        // যদি কোনো উইন্ডোই না পাওয়া যায়, তবে 0 রিটার্ন করো
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println(solution.minSubArrayLen(target1, nums1)); // Output: 2 (4 + 3)
        
        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        System.out.println(solution.minSubArrayLen(target2, nums2)); // Output: 1 (4)
        
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println(solution.minSubArrayLen(target3, nums3)); // Output: 0 (No valid subarray)
    }
}
























/**
 * LeetCode 209. Minimum Size Subarray Sum
 * Pattern: Sliding Window (Shrinking Window)
 * 
 * প্রবলেম: 
 * একটি Positive Integer Array এবং একটি Target integer দেওয়া আছে।
 * আপনাকে এমন একটি কন্টিনিউয়াস (Continuous) সাব-অ্যারে খুঁজে বের করতে হবে যার যোগফল >= Target হয় 
 * এবং যার সাইজ (length) সবচেয়ে ছোট (Minimum)।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি ক্লাসিক Shrinking Sliding Window প্রবলেম।
 * ১. `left` এবং `right` পয়েন্টার 0 থেকে শুরু হবে।
 * ২. `right` পয়েন্টার দিয়ে Array এর এলিমেন্টগুলো যোগ (`currentSum`) করতে থাকব (Grow the window)।
 * ৩. যখনই `currentSum >= target` হবে, আমরা একটি Valid উইন্ডো পেয়ে গেছি! 
 *    তখন আমরা `minLength` আপডেট করব।
 * ৪. এরপর উইন্ডোটিকে আরও ছোট করার চেষ্টা করব `left` পয়েন্টার বাড়িয়ে এবং `currentSum` থেকে 
 *    `left` এর ভ্যালু বিয়োগ করে (Shrink the window)।
 * ৫. যতক্ষণ `currentSum >= target` থাকবে, ততক্ষণ আমরা Shrink করতে থাকব এবং রেজাল্ট আপডেট করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */