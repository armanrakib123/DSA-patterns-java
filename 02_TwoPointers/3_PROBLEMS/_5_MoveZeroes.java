public class _5_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0; 
        
        // Step 1: সবগুলো non-zero এলিমেন্টকে সামনের দিকে নিয়ে আসো
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        // Step 2: slow এর পর থেকে array এর শেষ পর্যন্ত সব 0 বসিয়ে দাও
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
    
    // Alternative approach (Single Pass Optimization via Swapping):
    public void moveZeroesOptimized(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
    public static void main(String[] args) {
        _5_MoveZeroes solution = new _5_MoveZeroes();
        



        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        // Output: [1, 3, 12, 0, 0]
        
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        




        int[] nums2 = {0, 0, 1};
        solution.moveZeroes(nums2);
        // Output: [1, 0, 0]
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();




        int[] nums3 = {0, 1, 0, 3, 12};
        solution.moveZeroesOptimized(nums3);
        // Output: [1, 3, 12, 0, 0]
        for (int num : nums3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}









/**
 * LeetCode 283. Move Zeroes
 * Pattern: Two Pointer (Same Direction / Fast & Slow)
 * 
 * প্রবলেম: 
 * একটি integer array দেওয়া আছে। আপনাকে array এর সবগুলো `0` কে array এর শেষে পাঠিয়ে দিতে হবে, 
 * কিন্তু শর্ত হলো বাকি non-zero এলিমেন্টগুলোর সাপেক্ষিক ক্রম (relative order) ঠিক রাখতে হবে।
 * আপনাকে এই কাজটি In-place (অতিরিক্ত মেমোরি ছাড়া) করতে হবে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * আমরা Fast এবং Slow পয়েন্টার টেকনিক ব্যবহার করব।
 * ১. `slow` পয়েন্টারটি ট্র্যাক রাখবে কোথায় পরবর্তী non-zero এলিমেন্টটি বসাতে হবে।
 * ২. `fast` (লুপের ইনডেক্স `i`) দিয়ে আমরা পুরো array ট্রাভার্স করব।
 * ৩. যখনই আমরা একটি non-zero এলিমেন্ট পাব (`arr[i] != 0`), তখন আমরা সেটিকে `slow` এর পজিশনে কপি করব এবং `slow` বাড়াব।
 * ৪. পুরো ট্রাভার্সাল শেষে `slow` পয়েন্টারের পরের সবগুলো পজিশন আমরা `0` দিয়ে পূর্ণ করে দেব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */