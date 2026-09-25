public class _2_JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }
            
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _2_JumpGame solution = new _2_JumpGame();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump nums1? " + solution.canJump(nums1)); // true
        
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump nums2? " + solution.canJump(nums2)); // false
    }
}





























/**
 * 🎯 Problem 3: Jump Game (LeetCode 55)
 * লেভেল: Medium (Greedy Visualization)
 * 
 * প্রশ্ন: একটি অ্যারে `nums` দেওয়া আছে যেখানে প্রতিটি ভ্যালু ওই পজিশন থেকে আপনি সর্বোচ্চ কত দূর লাফ (Jump) 
 * দিতে পারবেন তা বোঝায়। আপনি ইনডেক্স 0 তে আছেন। আপনাকে বলতে হবে আপনি শেষ ইনডেক্সে পৌঁছাতে পারবেন কিনা।
 * 
 * 💡 ইন্টুইশন:
 * আমরা যদি বর্তমান পজিশন থেকে "সর্বোচ্চ কত দূর পৌঁছানো সম্ভব" (Max Reach) তা প্রতি মুহূর্তে আপডেট করি, 
 * তবে সহজেই বুঝতে পারব শেষ পর্যন্ত যাওয়া যাবে কিনা। 
 * যদি কোনো মুহূর্তে আমাদের বর্তমান ইনডেক্স `i` আমাদের `maxReach` এর চেয়ে বড় হয়ে যায়, 
 * তার মানে আমরা আর সামনে এগোতে পারছি না।
 * 
 * 🚀 সল্যুশন স্টেপস:
 * ১. `maxReach` নামে একটি ভেরিয়েবল নিন (শুরুতে 0)।
 * ২. অ্যারে দিয়ে লুপ চালান:
 *    - যদি `i > maxReach` হয়, তবে রিটার্ন `false` (কারণ আমরা এখানে পৌঁছাতে পারছি না)।
 *    - `maxReach` আপডেট করুন: `max(maxReach, i + nums[i])`।
 *    - যদি `maxReach` শেষ ইনডেক্স কভার করে ফেলে, তবে রিটার্ন `true`।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */