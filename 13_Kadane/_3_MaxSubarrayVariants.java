public class _3_MaxSubarrayVariants {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // যদি নাম্বারটি নেগেটিভ হয়, ম্যাক্স এবং মিন সোয়াপ করি
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // নতুন করে শুরু করব নাকি আগেরটার সাথে গুণ করব?
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num); // Min ট্র্যাক রাখা জরুরি

            // গ্লোবাল ম্যাক্স আপডেট
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        _3_MaxSubarrayVariants solution = new _3_MaxSubarrayVariants();
        
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + solution.maxProduct(nums)); 
        // Output: 6 ([2, 3])
        
        int[] nums2 = {-2, 3, -4};
        System.out.println("Maximum Product Subarray 2: " + solution.maxProduct(nums2)); 
        // Output: 24 (-2 * 3 * -4)
    }
}

































/**
 * Kadane's Algorithm Variants
 * LeetCode 152: Maximum Product Subarray (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array দেওয়া আছে। আপনাকে এমন একটি contiguous subarray (পাশাপাশি ইলিমেন্ট) 
 * খুঁজে বের করতে হবে যার গুণফল (Product) সবচেয়ে বেশি।
 * 
 * এপ্রোচ (Approach):
 * এটি Kadane's Algorithm এর একটি ট্রিকি ভ্যারিয়েশন। 
 * যোগের (Sum) ক্ষেত্রে নেগেটিভ নাম্বার সবসময় ক্ষতি করে। 
 * কিন্তু গুণের (Product) ক্ষেত্রে দুটি নেগেটিভ নাম্বার গুণ হয়ে অনেক বড় পজিটিভ নাম্বার হয়ে যেতে পারে! 
 * তাই শুধু `maxProduct` রাখলে হবে না, সাথে সাথে `minProduct` (সবচেয়ে ছোট/নেগেটিভ) ও রাখতে হবে।
 * 
 * যখন কোনো নেগেটিভ নাম্বার পাব, তখন বর্তমান ম্যাক্সিমাম এবং মিনিমাম কে সোয়াপ (Swap) করে দেব। 
 * কারণ নেগেটিভ নাম্বারের সাথে গুণ হলে বড়টা সবচেয়ে ছোট হয়ে যায়, আর ছোটটা সবচেয়ে বড় হয়ে যায়!
 */