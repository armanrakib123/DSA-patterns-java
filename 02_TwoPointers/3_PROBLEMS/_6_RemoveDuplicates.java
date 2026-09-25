public class _6_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
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
        _6_RemoveDuplicates solution = new _6_RemoveDuplicates();
        


        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println(k1); // Output: 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        


        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println(k2); // Output: 5
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}














/**
 * LeetCode 26. Remove Duplicates from Sorted Array
 * Pattern: Two Pointer (Same Direction / Fast & Slow)
 * 
 * প্রবলেম: 
 * একটি Sorted Array দেওয়া আছে। আপনাকে In-place এর ডুপ্লিকেট এলিমেন্টগুলো রিমুভ করতে হবে 
 * যেন প্রতিটি unique এলিমেন্ট শুধু একবারই থাকে। 
 * আপনাকে unique এলিমেন্টের সংখ্যা `k` রিটার্ন করতে হবে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * Array টি Sorted হওয়ায় একই সংখ্যাগুলো পাশাপাশি থাকবে।
 * ১. `slow` পয়েন্টার: এটি ইনডেক্স `1` থেকে শুরু হবে। এটি ট্র্যাক করবে কোথায় আমরা নতুন unique এলিমেন্ট বসাব।
 * ২. `fast` পয়েন্টার: এটিও ইনডেক্স `1` থেকে শুরু হয়ে শেষ পর্যন্ত যাবে।
 * ৩. যদি বর্তমান এলিমেন্ট (`nums[fast]`) তার আগের এলিমেন্টের (`nums[fast-1]`) সমান না হয়, 
 *    এর মানে আমরা একটি নতুন (Unique) এলিমেন্ট পেয়েছি! 
 * ৪. তখন আমরা সেই এলিমেন্টটিকে `nums[slow]` তে বসিয়ে দেব এবং `slow` এক ঘর বাড়াব।
 * ৫. শেষে `slow` পয়েন্টারের মানই হবে মোট unique এলিমেন্টের সংখ্যা।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */