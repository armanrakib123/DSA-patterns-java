package Software

Company_DSA_PATTERNS_MASTER.06_BINARY_SEARCH_PATTERN;

/**
 * 🎯 Problem 3: Search in Rotated Sorted Array (LeetCode 33)
 * লেভেল: Medium (Software Company Favorite)
 * 
 * প্রশ্ন: একটি sorted array কে কোনো একটি অজানা পিভট (pivot) পয়েন্টে রোটেট বা ঘোরানো হয়েছে।
 * যেমন: [0,1,2,4,5,6,7] রোটেট হয়ে [4,5,6,7,0,1,2] হতে পারে।
 * আপনাকে এই রোটেটেড অ্যারেতে `target` খুঁজতে হবে O(log N) টাইমে।
 * 
 * 💡 Intuition:
 * অ্যারেটি রোটেট করা থাকলেও, আমরা যদি অ্যারেটিকে মাঝখান (mid) বরাবর দুই ভাগ করি, 
 * তবে একটি জিনিস নিশ্চিত: **দুই ভাগের অন্তত একটি ভাগ সবসময় পুরোপুরি সর্টেড থাকবে!**
 * 
 * লজিক:
 * ১. `mid` বের করার পর চেক করব কোন অংশটি সর্টেড (বাম দিকের অংশ নাকি ডান দিকের অংশ)।
 * ২. যদি বাম অংশ সর্টেড হয় (`nums[left] <= nums[mid]`):
 *    - এবার চেক করব `target` কি এই বাম অংশের ভেতরে আছে কিনা? (`nums[left] <= target < nums[mid]`)
 *    - যদি থাকে, তবে ডান অংশ বাদ! (`right = mid - 1`)
 *    - যদি না থাকে, তবে বাম অংশ বাদ! (`left = mid + 1`)
 * ৩. যদি ডান অংশ সর্টেড হয় (`nums[mid] <= nums[right]`):
 *    - চেক করব `target` ডান অংশের ভেতরে আছে কিনা? (`nums[mid] < target <= nums[right]`)
 *    - যদি থাকে, তবে বাম অংশ বাদ! (`left = mid + 1`)
 *    - যদি না থাকে, তবে ডান অংশ বাদ! (`right = mid - 1`)
 * 
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */

public class SearchRotatedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // টার্গেট পেয়ে গেছি
            }

            // চেক করি বাম দিকের অংশ (Left Half) সর্টেড কিনা
            if (nums[left] <= nums[mid]) {
                // টার্গেট কি এই সর্টেড বাম অংশের ভেতরে আছে?
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // হ্যাঁ, ডানের অংশ বাদ
                } else {
                    left = mid + 1;  // না, বামের অংশ বাদ দিয়ে ডানে খুঁজব
                }
            } // যদি বাম অংশ সর্টেড না হয়, তার মানে ডান দিকের অংশ (Right Half) অবশ্যই সর্টেড
            else {
                // টার্গেট কি এই সর্টেড ডান অংশের ভেতরে আছে?
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // হ্যাঁ, বামের অংশ বাদ
                } else {
                    right = mid - 1; // না, ডানের অংশ বাদ দিয়ে বামে খুঁজব
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray solution = new SearchRotatedArray();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Search 0: " + solution.search(nums, 0));
        // Expected Output: 4

        System.out.println("Search 3: " + solution.search(nums, 3));
        // Expected Output: -1
    }
}
