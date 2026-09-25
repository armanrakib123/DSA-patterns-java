public class _2_Kadane {

    public int maxSubArray(int[] nums) {
        // শুরুতে maxSum কে একদম ছোট ভ্যালু (বা প্রথম ইলিমেন্ট) ধরে নিই
        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // বর্তমান ইলিমেন্ট যোগ করি
            currentSum += nums[i];

            // যদি বর্তমান যোগফল maxSum এর চেয়ে বড় হয়, তবে আপডেট করি
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // ম্যাজিক: যদি বর্তমান যোগফল নেগেটিভ হয়ে যায়, তবে তাকে 0 করে দিই!
            // কারণ নেগেটিভ যোগফল সামনের ইলিমেন্টগুলোর সাথে যুক্ত হয়ে যোগফল শুধু কমাবেই।
            // তাই আমরা নতুন করে সাব-অ্যারে শুরু করব।
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // অল্টারনেটিভ DP এপ্রোচ (কোড ছোট)
    public int maxSubArrayDP(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // আমি কি আগের সাব-অ্যারের সাথে যুক্ত হব? নাকি আমি নিজেই নতুন করে শুরু করব?
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        _2_Kadane solution = new _2_Kadane();
        
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums)); 
        // Output: 6 (সাব-অ্যারেটি হলো [4, -1, 2, 1])
    }
}



























/**
 * Kadane's Algorithm 
 * LeetCode 53: Maximum Subarray (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array দেওয়া আছে। আপনাকে এমন একটি contiguous subarray (পাশাপাশি ইলিমেন্ট) 
 * খুঁজে বের করতে হবে যার যোগফল (sum) সবচেয়ে বেশি। এবং সেই ম্যাক্সিমাম যোগফল রিটার্ন করতে হবে।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */