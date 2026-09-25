
/**
 * Binary Search Generic Templates
 * Software Company ইন্টারভিউতে বাইনারি সার্চে ছোটখাটো (Off-by-one) ভুলের কারণে অনেক ক্যান্ডিডেট বাদ পড়ে।
 * নিচের টেমপ্লেটগুলো এই কনফিউশন দূর করবে।
 */

public class _2_Template {

    /**
     * Pattern 1: Classic Binary Search (Exact Match) একটি নির্দিষ্ট টার্গেট
     * ভ্যালু খুঁজে বের করা। না পেলে -1 রিটার্ন করা।
     */
    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Pattern 2: Lower Bound (First occurrence / Insert Position) টার্গেটের
     * সমান বা তার চেয়ে বড় প্রথম ইলিমেন্টের ইনডেক্স বের করা। টার্গেট Array তে
     * না থাকলেও এটি যে পজিশনে বসালে সর্টেড থাকবে (Insert Position), তা রিটার্ন
     * করে।
     */
    public int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Pattern 3: Binary Search on Answer (Advanced)
     *
     * যখন কোনো ফিক্সড Array নেই, বরং একটি ফাংশন (যেমন isValid) চেক করতে হয়।
     */
    public int binarySearchOnAnswer(int minPossible, int maxPossible) {
        int left = minPossible;
        int right = maxPossible;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(mid)) {
                ans = mid;
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean isValid(int guess) {
        return true;
    }
}
