package Software

Company_DSA_PATTERNS_MASTER.07_BINARY_SEARCH_ON_ANSWER;

import java.util.Arrays;

/**
 * 🎯 Problem 3: Aggressive Cows (SPOJ / Similar to LeetCode 1552) লেভেল: Hard
 * (Software Company Favorite)
 *
 * প্রশ্ন: একটি সোজা লাইনে `N` টি স্টল (Stall) আছে, যাদের পজিশন `stalls`
 * অ্যারেতে দেওয়া আছে। আপনার কাছে `C` সংখ্যক রাগী গরু (Aggressive cows) আছে।
 * গরুগুলো খুব রাগী, তাই তাদেরকে এমনভাবে স্টলে রাখতে হবে যেন দুটি গরুর মধ্যকার
 * "ন্যূনতম দূরত্ব" (Minimum distance) "সর্বোচ্চ" (Maximum) হয়। আপনাকে সেই
 * সর্বোচ্চ-ন্যূনতম দূরত্বটি বের করতে হবে। (Find the Maximum of the Minimum
 * possible distance).
 *
 * 💡 Intuition (Search Space): দূরত্বের রেঞ্জ কত হতে পারে? - সর্বনিম্ন দূরত্ব
 * হতে পারে 1 (পরপর দুটি স্টল)। - সর্বোচ্চ দূরত্ব হতে পারে (শেষ স্টল - প্রথম
 * স্টল)। অর্থাৎ রেঞ্জ: `[1, max_stall_pos - min_stall_pos]`
 *
 * আমাদের এই রেঞ্জের মধ্যে বাইনারি সার্চ করে দেখতে হবে: "যদি আমরা বলি ন্যূনতম
 * দূরত্ব `mid` হতে হবে, তবে কি আমরা `C` সংখ্যক গরুকে স্টলগুলোতে বসাতে পারব?"
 *
 * 🚀 Optimal Approach: ১. প্রথমে `stalls` অ্যারেটিকে সর্ট (Sort) করে নিতে হবে,
 * যাতে আমরা পরপর স্টলগুলোতে গরু বসাতে পারি। ২. `isValid(mid)` ফাংশনে আমরা প্রথম
 * গরুকে প্রথম স্টলে বসাব। এরপর চেক করব পরের স্টলটির দূরত্ব আগেরটির থেকে অন্তত
 * `mid` কি না। যদি হয়, তবে সেখানে পরের গরুটি বসাব। এভাবে যদি `C` সংখ্যক গরু
 * বসানো যায়, তবে `mid` একটি সম্ভাব্য উত্তর। ৩. যেহেতু আমাদের "সর্বোচ্চ" দূরত্ব
 * চাই, তাই উত্তর পেলে আমরা `left = mid + 1` করব! (আগের প্রবলেমগুলোর ঠিক উল্টো)।
 *
 * Time Complexity: O(N log N) (সর্টিংয়ের জন্য) + O(N * log(Max_Distance)) Space
 * Complexity: O(1)
 */
public class AggressiveCows {

    public int maxDistance(int[] stalls, int cows) {
        // Step 1: Array সর্ট করা মাস্ট
        Arrays.sort(stalls);

        int n = stalls.length;
        int left = 1; // সর্বনিম্ন সম্ভাব্য দূরত্ব
        int right = stalls[n - 1] - stalls[0]; // সর্বোচ্চ সম্ভাব্য দূরত্ব
        int maxDist = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                maxDist = mid; // এই দূরত্বে বসানো সম্ভব, এটি একটি উত্তর
                left = mid + 1; // কিন্তু আমরা আরও বড় দূরত্ব চাই, তাই ডানে খুঁজব
            } else {
                right = mid - 1; // এই দূরত্ব অনেক বেশি, এত দূরে দূরে গরু বসানো সম্ভব নয়
            }
        }

        return maxDist;
    }

    private boolean canPlaceCows(int[] stalls, int totalCows, int minDistanceAllowed) {
        int cowsPlaced = 1; // প্রথম গরুকে প্রথম স্টলে বসালাম
        int lastPlacedPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            // যদি বর্তমান স্টল এবং শেষ বসানো গরুর স্টলের দূরত্ব আমাদের কাঙ্ক্ষিত দূরত্বের সমান বা বেশি হয়
            if (stalls[i] - lastPlacedPosition >= minDistanceAllowed) {
                cowsPlaced++;
                lastPlacedPosition = stalls[i];

                // যদি সবগুলো গরু বসানো শেষ হয়ে যায়
                if (cowsPlaced == totalCows) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AggressiveCows solution = new AggressiveCows();

        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;

        // Sorting the input manually for understanding: {1, 2, 4, 8, 9}
        // গরুগুলো বসবে: স্টল 1, 4 এবং 8 এ।
        // তাদের মধ্যকার দূরত্ব: (4-1)=3 এবং (8-4)=4। ন্যূনতম দূরত্ব 3।
        System.out.println("Maximum of minimum distance: " + solution.maxDistance(stalls, cows));
        // Expected Output: 3
    }
}
