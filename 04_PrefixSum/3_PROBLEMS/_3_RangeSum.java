public class _3_RangeSum {

    private int[] prefixSum;

    public _3_RangeSum(int[] nums) {
        prefixSum = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        _3_RangeSum numArray = new _3_RangeSum(nums);
        
        System.out.println("Sum range(0, 2): " + numArray.sumRange(0, 2));  // Output: 1  (-2 + 0 + 3)
        System.out.println("Sum range(2, 5): " + numArray.sumRange(2, 5));  // Output: -1 (3 + -5 + 2 + -1)
        System.out.println("Sum range(0, 5): " + numArray.sumRange(0, 5));  // Output: -3 (-2 + 0 + 3 + -5 + 2 + -1)
    }
}












/**
 * Prefix Sum Array Example
 * LeetCode 303: Range Sum Query - Immutable (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * আপনাকে একটি integer array (nums) দেওয়া হবে। এরপর অনেকগুলো Range Query দেওয়া হবে, 
 * যেখানে প্রতিবার দুটি ইনডেক্স left এবং right দেওয়া হবে। আপনাকে left থেকে right 
 * ইনডেক্স পর্যন্ত ইলিমেন্টগুলোর যোগফল রিটার্ন করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. যেহেতু অনেকগুলো কোয়েরি আসবে, তাই প্রতিবার লুপ চালিয়ে যোগফল বের করলে Time Limit Exceeded (TLE) খাবে।
 * ২. তাই আমরা ক্লাসের কনস্ট্রাকটরে (Constructor) একবারেই একটি Prefix Sum Array বানিয়ে রাখব।
 * ৩. `prefixSum[i]` এ সেভ রাখব প্রথম `i` টি ইলিমেন্টের যোগফল।
 * ৪. যখনই রেঞ্জ কোয়েরি (left, right) আসবে, আমরা শুধু `prefixSum[right + 1] - prefixSum[left]` রিটার্ন করব।
 * 
 * Time Complexity:
 * - Constructor (Pre-computation): O(N)
 * - Query (sumRange): O(1) - প্রতি কোয়েরিতে মাত্র একটি বিয়োগ!
 * Space Complexity: O(N) - Prefix Sum Array সেভ রাখার জন্য।
 */