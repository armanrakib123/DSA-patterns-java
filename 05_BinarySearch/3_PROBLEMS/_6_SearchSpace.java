
/**
 * Binary Search on Answer / Search Space Example
 * LeetCode 875: Koko Eating Bananas (Medium) - Software Company Favorite
 *
 * প্রবলেম স্টেটমেন্ট:
 * Koko কলা খেতে ভালোবাসে। তার সামনে কিছু কলার স্তুপ (piles) আছে, যেখানে `piles[i]` হলো i-তম স্তুপের কলার সংখ্যা।
 * গার্ড h ঘন্টার জন্য বাইরে গেছে। Koko ঠিক করতে চায় তার কলা খাওয়ার স্পিড k (কলা প্রতি ঘন্টা) কত হবে,
 * যেন সে গার্ড ফিরে আসার আগেই সব কলা খেয়ে ফেলতে পারে।
 * সে সবচেয়ে কম স্পিডে (minimum integer k) কলা খেতে চায়।
 *
 * এপ্রোচ (Approach):
 * ১. এখানে কোনো সর্টেড Array নেই। কিন্তু আমাদের উত্তরের (স্পিড) একটি রেঞ্জ আছে:
 *    - মিনিমাম স্পিড = 1 (প্রতি ঘন্টায় অন্তত ১টি খাবে)।
 *    - ম্যাক্সিমাম স্পিড = সবচেয়ে বড় স্তুপের কলার সংখ্যা (এর চেয়ে বেশি স্পিড নিয়ে লাভ নেই)।
 * ২. যেহেতু স্পিড 1, 2, 3... (Sorted) এবং বাড়তে থাকলে সময় কম লাগবে, আমরা Binary Search ব্যবহার করতে পারি।
 * ৩. আমরা একটি `mid` স্পিড গেস করব এবং চেক করব ওই স্পিডে সব কলা খেতে h ঘন্টার চেয়ে কম বা সমান সময় লাগে কি না (`isValid` ফাংশন)।
 * ৪. যদি লাগে, তবে স্পিড আরও কমানোর চেষ্টা করব (`right = mid - 1`)।
 * ৫. যদি সময় বেশি লাগে, তবে স্পিড বাড়াতে হবে (`left = mid + 1`)।
 */

public class _6_SearchSpace {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canEatAll(int[] piles, int speed, int h) {
        long hoursNeeded = 0;

        for (int pile : piles) {
            hoursNeeded += (pile + speed - 1) / speed;
        }

        return hoursNeeded <= h;
    }

    public static void main(String[] args) {
        _6_SearchSpace solution = new _6_SearchSpace();

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println("Minimum eating speed: " + solution.minEatingSpeed(piles, h));
        // Output: 4
    }
}
