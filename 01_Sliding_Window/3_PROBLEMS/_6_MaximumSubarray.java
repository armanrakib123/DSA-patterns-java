/**
 * 🎯 Problem 1: Maximum Subarray (LeetCode 53)
 * লেভেল: Medium (Kadane's Algorithm)
 * 
 * প্রশ্ন: আপনাকে একটি integer array (nums) দেওয়া হবে। 
 * আপনাকে এমন একটি contiguous subarray (পরপর থাকা সাবঅ্যারে) খুঁজে বের করতে হবে যার যোগফল সবচেয়ে বেশি (maximum sum)।
 * এবং সেই যোগফলটি রিটার্ন করতে হবে।
 * 
 * 💡 Brute Force Approach:
 * সবগুলো সাবঅ্যারে জেনারেট করা। দুটি নেস্টেড লুপ চালিয়ে প্রতিটি সাবঅ্যারের যোগফল বের করে ম্যাক্সিমাম ট্র্যাক করা।
 * Time Complexity: O(N^2) (Time Limit Exceeded খাবে)
 * Space Complexity: O(1)
 * 
 * 🚀 Optimal Approach (Kadane's Algorithm - A variation of Sliding Window):
 * কাদানস অ্যালগরিদম বলে: আমরা অ্যারের প্রতিটি এলিমেন্ট দিয়ে যেতে থাকব এবং যোগ করতে থাকব।
 * কিন্তু, যদি আমাদের currentSum (বর্তমান যোগফল) 0 এর চেয়ে ছোট (Negative) হয়ে যায়, 
 * তবে সেই যোগফল সাথে নিয়ে সামনে এগোলে সেটি সামনের পজিটিভ সংখ্যাগুলোকেও ছোট করে দেবে।
 * তাই currentSum নেগেটিভ হয়ে গেলে আমরা সেটিকে 0 করে দেব (অর্থাৎ উইন্ডো রিসেট করে নতুন উইন্ডো শুরু করব)।
 * 
 * লজিক:
 * ১. `currentSum` এ বর্তমান এলিমেন্ট যোগ করব।
 * ২. `maxSum` আপডেট করব।
 * ৩. যদি `currentSum < 0` হয়, তবে `currentSum = 0` করে দেব (কারণ নেগেটিভ যোগফল সামনের সাবঅ্যারেকে কোনো সাহায্য করবে না)।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class _6_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // যদি অ্যারেতে শুধু নেগেটিভ সংখ্যা থাকে, তখন 0 আউটপুট দিলে হবে না। 
        // তাই Integer.MIN_VALUE দিয়ে ইনিশিয়ালাইজ করছি।
        int maxSum = Integer.MIN_VALUE; 
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // বর্তমান যোগফল যদি maxSum এর চেয়ে বড় হয়, তবে আপডেট করব
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // যদি যোগফল নেগেটিভ হয়ে যায়, তবে উইন্ডো ড্রপ করব (রিসেট টু 0)
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        _6_MaximumSubarray solution = new _6_MaximumSubarray();
        
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int result = solution.maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result); 
        // Expected Output: 6 (সাবঅ্যারে [4, -1, 2, 1] এর যোগফল)
    }
}
