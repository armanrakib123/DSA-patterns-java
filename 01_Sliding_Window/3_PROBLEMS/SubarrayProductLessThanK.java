public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Edge Case: K যদি 1 বা তার ছোট হয়, তবে গুণফল কখনোই K এর ছোট হতে পারবে না (যেহেতু সব সংখ্যা Positive)
        if (k <= 1) return 0;
        
        int left = 0;
        int product = 1;
        int count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // উইন্ডো Grow করো
            product *= nums[right];
            
            // উইন্ডো Invalid হলে Shrink করো
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            
            // উইন্ডো Valid, সাব-অ্যারের সংখ্যা যোগ করো
            count += (right - left + 1);
        }
        
        return count;
    }
    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
        
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(solution.numSubarrayProductLessThanK(nums1, k1)); // Output: 8
        
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(solution.numSubarrayProductLessThanK(nums2, k2)); // Output: 0
    }
}



























/**
 * LeetCode 713. Subarray Product Less Than K
 * Pattern: Sliding Window (Growing / Counting Subarrays)
 * 
 * প্রবলেম: 
 * একটি Positive Integer Array এবং একটি integer 'K' দেওয়া আছে। 
 * আপনাকে বলতে হবে এমন কয়টি Continuous Subarray আছে যাদের এলিমেন্টগুলোর গুণফল (Product) 'K' এর চেয়ে ছোট।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি Sliding Window এর সাহায্যে খুব সুন্দরভাবে সলভ করা যায়। 
 * যেহেতু Array এর সব এলিমেন্ট Positive, তাই উইন্ডো বড় হলে গুণফল বাড়বে এবং উইন্ডো ছোট হলে গুণফল কমবে (Monotonic property)।
 * 
 * লজিক:
 * ১. `left` এবং `right` পয়েন্টার 0 থেকে শুরু হবে। `product = 1`।
 * ২. `right` দিয়ে ট্রাভার্স করব এবং `product *= nums[right]` করব।
 * ৩. যদি `product >= K` হয়ে যায় (উইন্ডো Invalid), তখন `left` বাড়িয়ে উইন্ডো ছোট করব এবং 
 *    `product /= nums[left]` করব, যতক্ষণ না `product < K` হয়।
 * ৪. যখন উইন্ডোটি Valid হবে (`product < K`), তখন এই উইন্ডোর মাধ্যমে কয়টি নতুন সাব-অ্যারে তৈরি হলো তা কাউন্ট করতে হবে। 
 *    - সূত্র: একটি ভ্যালিড উইন্ডো `[left...right]` এ নতুন সাব-অ্যারের সংখ্যা হলো `right - left + 1`।
 *    - উদাহরণ: উইন্ডো `[10, 5, 2]` হলে, নতুন সাব-অ্যারে হবে `[2]`, `[5, 2]`, `[10, 5, 2]` (৩টি)।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */