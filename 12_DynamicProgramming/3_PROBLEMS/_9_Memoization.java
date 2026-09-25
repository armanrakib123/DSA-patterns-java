import java.util.Arrays;

public class _9_Memoization {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        
        Arrays.fill(memo, -1);
        
        return solve(n, memo);
    }

    private int solve(int n, int[] memo) {
        
        if (n == 0 || n == 1) return 1;

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
        
        return memo[n];
    }

    public static void main(String[] args) {
        _9_Memoization solution = new _9_Memoization();
        int n = 5;
        System.out.println("Ways to climb " + n + " stairs: " + solution.climbStairs(n)); 
        // Output: 8
    }
}
























/**
 * Top-Down DP (Memoization) Example
 * LeetCode 70: Climbing Stairs (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * আপনি একটি সিঁড়ি দিয়ে উঠছেন। মোট n টি ধাপ (steps) আছে।
 * আপনি প্রতিবার ১টি অথবা ২টি ধাপ লাফ দিতে পারেন।
 * কতগুলো ভিন্ন উপায়ে (distinct ways) আপনি সিঁড়ির চূড়ায় পৌঁছাতে পারবেন?
 * 
 * এপ্রোচ (Memoization):
 * ১. রিকার্সন: n নম্বর ধাপে পৌঁছানোর উপায় = (n-1 ধাপে পৌঁছানোর উপায়) + (n-2 ধাপে পৌঁছানোর উপায়)।
 * ২. কিন্তু রিকার্সনে Time Complexity হবে O(2^n), যা TLE খাবে।
 * ৩. তাই আমরা একটি `memo` অ্যারে ব্যবহার করব। যখনই আমরা কোনো নির্দিষ্ট n এর উত্তর পাব, তা সেভ করে রাখব।
 * 
 * Time Complexity: O(N) - কারণ প্রতিটি স্টেটের ক্যালকুলেশন মাত্র একবার হবে।
 * Space Complexity: O(N) - রিকার্সন কল স্ট্যাক এবং মেমো অ্যারের জন্য।
 */