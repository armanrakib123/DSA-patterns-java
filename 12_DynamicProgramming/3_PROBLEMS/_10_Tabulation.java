public class _10_Tabulation {

    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // O(1) Space approach (Space Optimized Tabulation)
    public int climbStairsOptimized(int n) {
        if (n <= 1) return 1;

        int prev2 = 1; 
        int prev1 = 1; 
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        _10_Tabulation solution = new _10_Tabulation();
        int n = 5;
        System.out.println("Ways to climb " + n + " stairs (Tabulation): " + solution.climbStairs(n)); 
        System.out.println("Ways to climb " + n + " stairs (Optimized): " + solution.climbStairsOptimized(n)); 
        // Output: 8
    }
}






















/**
 * Bottom-Up DP (Tabulation) Example
 * LeetCode 70: Climbing Stairs (Easy)
 * 
 * প্রবলেম: n টি ধাপে পৌঁছানোর উপায় কয়টি?
 * 
 * এপ্রোচ (Tabulation):
 * ১. এখানে কোনো রিকার্সন নেই। আমরা নিচ থেকে (Base case) শুরু করে ওপরের দিকে উঠব।
 * ২. একটি `dp` অ্যারে নেব। `dp[i]` মানে হলো i-তম ধাপে পৌঁছানোর উপায়।
 * ৩. dp[0] = 1 এবং dp[1] = 1।
 * ৪. এরপর একটি for লুপ চালিয়ে dp[i] = dp[i-1] + dp[i-2] ফর্মুলা (State Transition Equation) 
 *    দিয়ে টেবিল পূরণ করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) - (আমরা চাইলে এটি O(1) এ নামিয়ে আনতে পারি, কারণ শুধু আগের দুটি ভ্যালু দরকার হয়!)
 */