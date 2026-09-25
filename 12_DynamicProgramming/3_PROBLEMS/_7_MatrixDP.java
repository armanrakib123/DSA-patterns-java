public class _7_MatrixDP {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        _7_MatrixDP solution = new _7_MatrixDP();
        
        int m = 3, n = 7;
        System.out.println("Unique Paths: " + solution.uniquePaths(m, n));
        // Output: 28
    }
}

























/**
 * Matrix DP Pattern
 * LeetCode 62: Unique Paths (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি m x n গ্রিড দেওয়া আছে। একটি রোবট Top-Left (0,0) কোণায় আছে।
 * সে Bottom-Right (m-1, n-1) কোণায় যেতে চায়। 
 * রোবটটি প্রতিবার শুধুমাত্র "ডানে" (Right) অথবা "নিচে" (Down) যেতে পারে।
 * মোট কতগুলো ভিন্ন উপায়ে (Unique Paths) সে গন্তব্যে পৌঁছাতে পারবে?
 * 
 * এপ্রোচ (2D Tabulation):
 * ১. একটি 2D `dp[m][n]` টেবিল তৈরি করব।
 * ২. `dp[i][j]` মানে হলো: (i, j) সেলে পৌঁছানোর মোট উপায়।
 * ৩. Base Case: প্রথম রো এবং প্রথম কলামের সব সেলে যাওয়ার উপায় ১টি (কারণ শুধু ডানে বা শুধু নিচে গিয়ে পৌঁছানো যায়)।
 * ৪. অন্যান্য যেকোনো সেলে (i, j) পৌঁছানোর উপায় হলো তার ঠিক উপরের সেল এবং ঠিক বামের সেলের উপায়ের যোগফল!
 *    `dp[i][j] = dp[i-1][j] + dp[i][j-1]`
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) - (O(N) বা 1D Array দিয়ে অপ্টিমাইজ করা যায়)।
 */