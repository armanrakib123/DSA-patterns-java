public class _11_UnboundedKnapsack {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        int max = amount + 1; 
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }
        
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        _11_UnboundedKnapsack solution = new _11_UnboundedKnapsack();
        
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        System.out.println("Minimum coins needed: " + solution.coinChange(coins, amount)); 
        // Output: 3 (5 + 5 + 1)
    }
}






















/**
 * Unbounded Knapsack Pattern
 * LeetCode 322: Coin Change (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * আপনার কাছে কিছু কয়েন (coins) এবং একটি অ্যামাউন্ট (amount) দেওয়া আছে।
 * আপনাকে মিনিমাম (সবচেয়ে কম) সংখ্যক কয়েন ব্যবহার করে ওই অ্যামাউন্টটি বানাতে হবে।
 * (Unbounded মানে হলো: আপনি একটি কয়েন যতবার খুশি (unlimited) ব্যবহার করতে পারবেন)।
 * 
 * এপ্রোচ (1D DP Tabulation):
 * ১. একটি 1D dp[amount + 1] অ্যারে নেব। 
 * ২. `dp[i]` মানে হলো i অ্যামাউন্ট বানাতে মিনিমাম কয়টি কয়েন লাগে।
 * ৩. শুরুতে `dp[0] = 0` (0 টাকা বানাতে 0 কয়েন লাগে)। বাকি সবগুলোতে একটি ম্যাক্সিমাম ভ্যালু (যেমন amount + 1) দিয়ে রাখব।
 * ৪. এরপর ১ থেকে amount পর্যন্ত লুপ চালাব।
 * ৫. ভেতরে সব কয়েনের জন্য চেক করব: `dp[i] = min(dp[i], 1 + dp[i - coin])` 
 *    (অর্থাৎ, বর্তমান কয়েনটি নিলে ১টি কয়েন বাড়বে, আর বাকি টাকার জন্য মিনিমাম কয়েন কত লাগে তা dp থেকে নেব)।
 * 
 * Time Complexity: O(N * Amount) - যেখানে N হলো কয়েনের সংখ্যা।
 * Space Complexity: O(Amount) - 1D DP Array এর জন্য।
 */