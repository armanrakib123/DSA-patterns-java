public class _5_Knapsack_01 {

    public int solveKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                
                if (wt[i - 1] <= w) {
                    
                    int include = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                    int exclude = dp[i - 1][w];
                    
                    dp[i][w] = Math.max(include, exclude);
                    
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        _5_Knapsack_01 solution = new _5_Knapsack_01();
        
        int[] val = {60, 100, 120}; // আইটেমের ভ্যালু
        int[] wt = {10, 20, 30};    // আইটেমের ওজন
        int W = 50;                 // ব্যাগের ক্যাপাসিটি
        
        System.out.println("Maximum Value: " + solution.solveKnapsack(wt, val, W)); 
        // Output: 220 (আইটেম ২ এবং ৩ নিয়ে: 100 + 120 = 220, ওজন: 20 + 30 = 50)
    }
}




















/**
 * 0/1 Knapsack Pattern
 * (The Mother of all DP Problems)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * আপনার কাছে একটি ন্যাপস্যাক (ব্যাগ) আছে যার সর্বোচ্চ ধারণক্ষমতা W।
 * আপনার কাছে n টি আইটেম আছে, প্রতিটি আইটেমের একটি ওজন (weight) এবং একটি মূল্য (value) আছে।
 * আপনি ব্যাগটিতে সর্বোচ্চ কত মূল্যের আইটেম নিতে পারবেন? 
 * (0/1 মানে হলো: হয় আপনি একটি আইটেম পুরোটা নেবেন, অথবা একদমই নেবেন না। অর্ধেক নেওয়া যাবে না)।
 * 
 * এপ্রোচ (Tabulation - 2D DP):
 * ১. একটি 2D dp[n+1][W+1] টেবিল তৈরি করব।
 * ২. dp[i][w] মানে হলো: প্রথম i টি আইটেম দিয়ে w ওজনের ব্যাগে সর্বোচ্চ কত ভ্যালু রাখা যায়।
 * ৩. প্রতি ধাপে আমাদের দুটি অপশন (Choice):
 *    - আইটেমটি নেব না (Exclude): তাহলে ভ্যালু হবে আগের আইটেম পর্যন্ত ভ্যালু `dp[i-1][w]`
 *    - আইটেমটি নেব (Include): যদি ব্যাগে জায়গা থাকে, তবে ভ্যালু হবে `val[i-1] + dp[i-1][w - wt[i-1]]`
 *    আমরা এই দুটির মধ্যে ম্যাক্সিমাম (Max) টি নেব।
 * 
 * Time Complexity: O(N * W)
 * Space Complexity: O(N * W) - চাইলে O(W) (1D DP) তে অপ্টিমাইজ করা যায়।
 */
