/**
 * 🎯 Problem: Climbing Stairs (LeetCode 70)
 * লেভেল: Easy (DP Fundamentals)
 * 
 * প্রশ্ন: আপনি n টি সিঁড়ি বেয়ে উপরে উঠছেন। প্রতিবার আপনি ১ বা ২ ধাপ উঠতে পারেন। 
 * কত উপায়ে আপনি চূড়ায় পৌঁছাতে পারবেন?
 * 
 * 💡 লজিক:
 * i-তম সিঁড়িতে আসার উপায় হলো: 
 * (i-1) তম সিঁড়ি থেকে ১ ধাপ আসা অথবা (i-2) তম সিঁড়ি থেকে ২ ধাপ আসা। 
 * সুতরাং: dp[i] = dp[i-1] + dp[i-2] (এটি আসলে ফিবোনাচ্চি সিরিজ)।
 */





public class _2_ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // অপ্টিমাইজড স্পেস (O(1)):
    public int climbStairsOptimized(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2;
        
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {

        _2_ClimbingStairs obj = new _2_ClimbingStairs();

        int n = 5;

        System.out.println("Total Ways: " + obj.climbStairs(n));   // Total Ways: 8

        System.out.println("Optimized Ways: " +     obj.climbStairsOptimized(n));           // Optimized Ways: 8
    }

    // টাইম কমপ্লেক্সিটি: O(N)
    // স্পেস কমপ্লেক্সিটি: O(N) or O(1)
}