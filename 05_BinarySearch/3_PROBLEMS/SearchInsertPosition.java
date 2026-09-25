package Software

Company_DSA_PATTERNS_MASTER.06_BINARY_SEARCH_PATTERN;

/**
 * 🎯 Problem 2: Search Insert Position (LeetCode 35)
 * লেভেল: Easy
 * 
 * প্রশ্ন: একটি sorted array `nums` এবং একটি `target` দেওয়া আছে।
 * যদি টার্গেটটি পাওয়া যায়, তবে তার ইনডেক্স রিটার্ন করো।
 * আর যদি না পাওয়া যায়, তবে টার্গেটটিকে এমন একটি ইনডেক্সে ইনসার্ট করতে হবে যাতে অ্যারেটি সর্টেডই থাকে। 
 * সেই ইনসার্ট ইনডেক্সটি রিটার্ন করো। (আপনাকে অবশ্যই O(log n) টাইমে এটি সলভ করতে হবে)।
 * 
 * 💡 Intuition:
 * এটি ঠিক নরমাল বাইনারি সার্চের মতোই। 
 * পার্থক্য হলো, নরমাল বাইনারি সার্চে আমরা ভ্যালু না পেলে `-1` রিটার্ন করি। 
 * কিন্তু এখানে লুপ শেষে `left` পয়েন্টার ঠিক সেই ইনডেক্সে গিয়ে থামবে, যেখানে টার্গেটটি বসা উচিত। 
 * (একে C++ এর ভাষায় lower_bound বলা হয়)।
 * 
 * লজিক:
 * যদি লুপ `left <= right` কন্ডিশন ব্রেক করে বের হয়ে আসে, তার মানে `target` অ্যারেতে নেই।
 * তখন `left` পয়েন্টারটি সেই প্রথম ইলিমেন্টকে পয়েন্ট করে থাকবে যা `target` এর চেয়ে বড়। 
 * অর্থাৎ ঠিক ওই জায়গাতেই `target` কে ইনসার্ট করতে হবে।
 * 
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // টার্গেট পেয়ে গেছি
            } else if (nums[mid] < target) {
                left = mid + 1; // ডানে খুঁজব
            } else {
                right = mid - 1; // বামে খুঁজব
            }
        }

        // লুপ শেষ হওয়ার পর left পয়েন্টার ইনসার্ট পজিশন নির্দেশ করবে
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};

        System.out.println("Insert 5 at: " + solution.searchInsert(nums, 5));
        // Expected Output: 2 (কারণ 5 আগে থেকেই ইনডেক্স 2 তে আছে)

        System.out.println("Insert 2 at: " + solution.searchInsert(nums, 2));
        // Expected Output: 1 (1 এবং 3 এর মাঝে বসবে)

        System.out.println("Insert 7 at: " + solution.searchInsert(nums, 7));
        // Expected Output: 4 (সবার শেষে বসবে)
    }
}
