public class RangeSumQuery {

    static class NumArray {
        private int[] prefix;

        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];
            
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }
        
        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        
        System.out.println("Sum range [0, 2]: " + numArray.sumRange(0, 2)); 
        // Expected Output: 1 (-2 + 0 + 3)
        
        System.out.println("Sum range [2, 5]: " + numArray.sumRange(2, 5)); 
        // Expected Output: -1 (3 + -5 + 2 + -1)
        
        System.out.println("Sum range [0, 5]: " + numArray.sumRange(0, 5)); 
        // Expected Output: -3 (-2 + 0 + 3 + -5 + 2 + -1)
    }
}


















/**
 * 🎯 Problem 1: Range Sum Query - Immutable (LeetCode 303)
 * লেভেল: Easy
 * 
 * প্রশ্ন: আপনাকে একটি integer array (nums) দেওয়া হবে এবং একটি کلاس ডিজাইন করতে হবে `NumArray`।
 * এই ক্লাসে একটি মেথড থাকবে `sumRange(int left, int right)`, যা অ্যারের left ইনডেক্স থেকে 
 * right ইনডেক্স পর্যন্ত (উভয় ইনডেক্সসহ) এলিমেন্টগুলোর যোগফল রিটার্ন করবে।
 * 
 * 💡 Brute Force Approach:
 * প্রতিবার `sumRange` কল হলে left থেকে right পর্যন্ত একটি লুপ চালানো।
 * Time Complexity: O(N) for each query.
 * Space Complexity: O(1)
 * যদি Q সংখ্যক কুয়েরি থাকে, তবে মোট টাইম লাগবে O(Q * N), যা অনেক স্লো।
 * 
 * 🚀 Optimal Approach (Prefix Sum):
 * আমরা কনস্ট্রাক্টরে (Constructor) একবারেই একটি প্রিফিক্স সাম অ্যারে (prefix[]) তৈরি করে রাখব।
 * prefix[i] এর মধ্যে 0 থেকে i-1 পর্যন্ত সব এলিমেন্টের যোগফল থাকবে।
 * 
 * লজিক:
 * ১. `prefix[i] = prefix[i-1] + nums[i-1]`
 * ২. যখন `sumRange(left, right)` কল হবে, তখন আমরা লুপ না চালিয়ে `O(1)` সময়ে উত্তর বের করব।
 *    উত্তর = `prefix[right + 1] - prefix[left]`
 * 
 * Time Complexity: 
 *   - Constructor: O(N) (একবারই লুপ চলবে)
 *   - sumRange: O(1) (প্রতিটি কুয়েরির জন্য)
 * Space Complexity: O(N) (প্রিফিক্স অ্যারের জন্য)
 */