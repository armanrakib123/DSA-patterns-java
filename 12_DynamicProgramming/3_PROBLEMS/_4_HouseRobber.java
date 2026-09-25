public class _4_HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <= n - 1; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
    public static void main(String[] args) {
        _4_HouseRobber obj = new _4_HouseRobber();

        int[] nums = {1, 2, 3, 1};
        System.out.println("Maximum Amount Robbed: " + obj.rob(nums)); // Maximum Amount Robbed: 4 (1 + 3)
    }

    // টাইম কমপ্লেক্সিটি: O(N)
    // স্পেস কমপ্লেক্সিটি: O(N)
}





























/**
 * 🎯 Problem: House Robber (LeetCode 198)
 * লেভেল: Medium (Linear DP)
 * 
 * প্রশ্ন: আপনি একজন চোর। প্রতিটি ঘরে নির্দিষ্ট পরিমাণ টাকা আছে। 
 * শর্ত হলো আপনি পাশাপাশি দুটি ঘরে চুরি করতে পারবেন না। 
 * সর্বোচ্চ কত টাকা চুরি করতে পারবেন?
 * 
 * 💡 লজিক:
 * i-তম ঘরের জন্য আপনার কাছে দুটি অপশন:
 * ১. এই ঘরে চুরি করবেন (তবে i-1 এ করা যাবে না): nums[i] + dp[i-2]
 * ২. এই ঘরে চুরি করবেন না: dp[i-1]
 * সুতরাং: dp[i] = max(nums[i] + dp[i-2], dp[i-1])
 */