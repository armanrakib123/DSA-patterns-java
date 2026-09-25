package FAANG_DSA_PATTERNS_MASTER.07_BINARY_SEARCH_ON_ANSWER;

/**
 * 🎯 Problem 1: Koko Eating Bananas (LeetCode 875)
 * লেভেল: Medium
 * 
 * প্রশ্ন: কোকো (বানর) কলা খেতে ভালোবাসে। `piles` নামে একটি অ্যারে দেওয়া আছে যেখানে প্রতিটি এলিমেন্ট একটি কলার কাঁদি নির্দেশ করে।
 * গার্ডরা `h` ঘণ্টার জন্য বাইরে গেছে। কোকো প্রতি ঘণ্টায় `k` সংখ্যক কলা খেতে পারে।
 * যদি কোনো কাঁদিতে `k` এর চেয়ে কম কলা থাকে, সে সেগুলো খাবে কিন্তু ওই ঘণ্টায় আর অন্য কোনো কাঁদি ধরবে না।
 * আপনাকে বের করতে হবে কোকোর ন্যূনতম খাওয়ার স্পিড `k` (minimum integer) কত হলে সে `h` ঘণ্টার মধ্যে সব কলা খেয়ে শেষ করতে পারবে।
 * 
 * 💡 Intuition:
 * স্পিড `k` এর সম্ভাব্য মান কত হতে পারে?
 * - সর্বনিম্ন স্পিড হতে পারে 1 (প্রতি ঘণ্টায় ১টি কলা)।
 * - সর্বোচ্চ স্পিড হতে পারে অ্যারের সবচেয়ে বড় ইলিমেন্টটি (কারণ এর চেয়ে বেশি স্পিডে খেলেও লাভ নেই, সে এক ঘণ্টায় এক কাঁদির বেশি খেতে পারে না)।
 * অর্থাৎ আমাদের উত্তরের রেঞ্জ হলো: `[1, max(piles)]`
 * 
 * এখন যদি স্পিড ৫ দিয়ে সে `h` ঘণ্টার মধ্যে সব কলা খেতে পারে, তবে ৬, ৭, ৮ স্পিডেও পারবে।
 * এটি একটি Monotonic Function তৈরি করে: `[False, False, True, True, True]`
 * আমাদের কাজ হলো প্রথম `True` এর ইনডেক্সটা (অর্থাৎ ন্যূনতম স্পিড) খুঁজে বের করা।
 * 
 * 🚀 Optimal Approach (Binary Search on Answer):
 * ১. left = 1, right = max(piles)
 * ২. mid = (left + right) / 2
 * ৩. একটি `canEatAll(mid)` ফাংশন দিয়ে চেক করব এই `mid` স্পিডে সে `h` ঘণ্টায় সব খেতে পারে কিনা।
 * ৪. যদি পারে, তবে `right = mid - 1` করব (কারণ আমরা আরও ছোট স্পিড খুঁজছি)।
 * ৫. যদি না পারে, তবে `left = mid + 1` করব।
 * 
 * Time Complexity: O(N * log(Max_Pile))
 * Space Complexity: O(1)
 */

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // সর্বোচ্চ স্পিড (রাইট বাউন্ডারি) বের করা
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int minSpeed = right;

        // Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                minSpeed = mid; // এটি একটি সম্ভাব্য উত্তর
                right = mid - 1; // আরও ছোট স্পিড খোঁজার চেষ্টা
            } else {
                left = mid + 1; // স্পিড খুব কম, বাড়াতে হবে
            }
        }

        return minSpeed;
    }

    // Helper function to check if Koko can eat all bananas with speed 'k' within 'h' hours
    private boolean canEatAll(int[] piles, int k, int h) {
        long totalHours = 0; // Integer overflow এড়ানোর জন্য long

        for (int pile : piles) {
            // Math.ceil(pile / k) এর সমতুল্য ইনটিজার ম্যাথ
            // যদি pile = 7 এবং k = 3 হয়, 7/3 = 2 কিন্তু ৩ ঘণ্টা লাগবে (3+3+1)।
            // (7 + 3 - 1) / 3 = 9 / 3 = 3 ঘণ্টা।
            totalHours += (pile + k - 1) / k; 
        }

        return totalHours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        
        System.out.println("Minimum eating speed: " + solution.minEatingSpeed(piles, h)); 
        // Expected Output: 4
    }
}
