/**
 * Same Direction Two Pointers Example
 * LeetCode 26: Remove Duplicates from Sorted Array (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি সর্টেড (Sorted) array দেওয়া আছে। আপনাকে ইন-প্লেস (in-place) ডুপ্লিকেটগুলো 
 * রিমুভ করতে হবে, যেন প্রতিটি ইউনিক ইলিমেন্ট একবার করে থাকে। 
 * শেষে ইউনিক ইলিমেন্টের সংখ্যা (k) রিটার্ন করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. আমরা Same Direction Two Pointers ব্যবহার করব।
 * ২. `slow` পয়েন্টার: এটি নির্দেশ করবে কোথায় নতুন ইউনিক ইলিমেন্ট লিখতে হবে। 
 *    (শুরুতে ইনডেক্স 1 এ রাখব, কারণ ইনডেক্স 0 এর ইলিমেন্ট সবসময় ইউনিক)।
 * ৩. `fast` পয়েন্টার: এটি array স্ক্যান করে নতুন ইউনিক ইলিমেন্ট খুঁজবে 
 *    (এটিও ইনডেক্স 1 থেকে শুরু হবে)।
 * ৪. লুপের ভেতরে চেক করব `nums[fast]` এবং তার আগের ইলিমেন্ট `nums[fast - 1]` একই কি না।
 * ৫. যদি একই না হয় (অর্থাৎ নতুন ইউনিক ইলিমেন্ট পেয়েছি), তখন আমরা সেটিকে `slow` এর 
 *    জায়গায় বসিয়ে দেব (`nums[slow] = nums[fast]`) এবং `slow` কে এক ঘর এগিয়ে দেব।
 * ৬. শেষে `slow` এর ভ্যালুই হবে মোট ইউনিক ইলিমেন্টের সংখ্যা।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) - ইন-প্লেস মডিফিকেশন।
 */





public class _4_SameDirection {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 1;

        for (int fast = 1; fast < nums.length; fast++) {
            
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;   
            }
        }
        return slow;
    }


    public static void main(String[] args) {
        _4_SameDirection solution = new _4_SameDirection();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        
        int k = solution.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + k);
        System.out.println("Modified Array (first " + k + " elements): ");
        
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Output: 
        // Number of unique elements: 5
        // Modified Array: 0 1 2 3 4
    }
}