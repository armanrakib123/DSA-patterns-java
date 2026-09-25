import java.util.*;

public class _3_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);          // [12,12,12,12,12,12,12,12,12,12,12,12]
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // যদি অ্যামাউন্টটি বানানো সম্ভব না হয় (ভ্যালু আপডেট না হলে)
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        _3_CoinChange obj = new _3_CoinChange();

        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Minimum Coins: " + obj.coinChange(coins, amount)); // Minimum Coins: 3 (5 + 5 + 1)
    }

    // টাইম কমপ্লেক্সিটি: O(amount * length_of_coins)
    // স্পেস কমপ্লেক্সিটি: O(amount)
}















/**
 * 🎯 Problem: Coin Change (LeetCode 322)
 * লেভেল: Medium (Knapsack-style DP)
 * 
 * প্রশ্ন: কিছু কয়েন এবং একটি টার্গেট অ্যামাউন্ট দেওয়া আছে। 
 * সর্বনিম্ন কতগুলো কয়েন দিয়ে ওই অ্যামাউন্টটি বানানো সম্ভব?
 * 
 * 💡 লজিক:
 * এটি একটি আনবাউন্ডেড ন্যাপস্যাক প্রবলেম। 
 * dp[i] হলো i টাকা বানাতে সর্বনিম্ন কয়েন সংখ্যা।
 * dp[i] = min(dp[i], 1 + dp[i - coin]) প্রতিটি কয়েনের জন্য।
 */