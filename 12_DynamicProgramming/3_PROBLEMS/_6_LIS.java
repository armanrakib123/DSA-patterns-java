import java.util.Arrays;

public class _6_LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        _6_LIS solution = new _6_LIS();
        
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums)); 
        // Output: 4 (LIS হলো [2, 3, 7, 101] বা [2, 5, 7, 101])
    }
}


































/**
 * Longest Increasing Subsequence (LIS) Pattern
 * LeetCode 300: Longest Increasing Subsequence (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array দেওয়া আছে। আপনাকে এর মধ্যে সবচেয়ে বড় 
 * "Increasing Subsequence" এর সাইজ (length) বের করতে হবে।
 * (Subsequence মানে হলো অরিজিনাল অ্যারের কিছু ইলিমেন্ট নিয়ে তৈরি নতুন অ্যারে, 
 * যেখানে ইলিমেন্টগুলোর অর্ডার (order) একই থাকে, কিন্তু তারা পাশাপাশি নাও থাকতে পারে)।
 * 
 * এপ্রোচ (1D DP):
 * ১. একটি 1D `dp` অ্যারে নেব, যার সব ভ্যালু শুরুতে 1 হবে (কারণ প্রতিটি ইলিমেন্ট নিজেই একটি 1 সাইজের সাবসিকোয়েন্স)।
 * ২. `dp[i]` মানে হলো: i ইনডেক্সে শেষ হওয়া সবচেয়ে বড় Increasing Subsequence এর সাইজ।
 * ৩. দুটি লুপ চালাব:
 *    - বাইরের লুপ `i` চলবে 1 থেকে শেষ পর্যন্ত।
 *    - ভেতরের লুপ `j` চলবে 0 থেকে `i-1` পর্যন্ত।
 * ৪. যদি দেখি `nums[i] > nums[j]` (অর্থাৎ increasing), 
 *    তবে `dp[i] = max(dp[i], dp[j] + 1)` আপডেট করব।
 * 
 * Time Complexity: O(N^2) - (O(N log N) এর একটি Binary Search সলিউশনও আছে)।
 * Space Complexity: O(N)
 */