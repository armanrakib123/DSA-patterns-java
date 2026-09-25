package FAANG_DSA_PATTERNS_MASTER.06_BINARY_SEARCH_PATTERN;

/**
 * 🎯 Problem 1: Binary Search (LeetCode 704)
 * লেভেল: Easy
 * 
 * প্রশ্ন: আপনাকে একটি sorted (ছোট থেকে বড় সাজানো) integer array `nums` এবং একটি `target` ভ্যালু দেওয়া হবে।
 * যদি `target` অ্যারের মধ্যে থাকে, তবে তার ইনডেক্স রিটার্ন করতে হবে। না থাকলে `-1` রিটার্ন করতে হবে।
 * 
 * 💡 Brute Force Approach:
 * লিনিয়ার সার্চ - অ্যারের শুরু থেকে শেষ পর্যন্ত লুপ চালিয়ে চেক করা।
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * 🚀 Optimal Approach (Binary Search):
 * যেহেতু অ্যারেটি সাজানো, আমরা বাইনারি সার্চ ব্যবহার করে প্রতি ধাপে সার্চ স্পেস অর্ধেক করে ফেলব।
 * 
 * লজিক:
 * ১. `left` পয়েন্টার শুরুতে (0) এবং `right` পয়েন্টার শেষে (n-1) রাখব।
 * ২. মাঝখানের ইলিমেন্ট `mid` বের করব।
 * ৩. যদি `nums[mid] == target` হয়, উত্তর পেয়ে গেছি!
 * ৪. যদি `nums[mid] < target` হয়, তার মানে টার্গেট ডানদিকে আছে (বড় সংখ্যাগুলো ডানদিকে)। তাই `left = mid + 1` করব।
 * ৫. যদি `nums[mid] > target` হয়, তার মানে টার্গেট বামদিকে আছে। তাই `right = mid - 1` করব।
 * 
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */

public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // `<=` ব্যবহার করা জরুরি, না হলে ১ সাইজের অ্যারে বা শেষ ইলিমেন্ট চেক করা বাদ পড়তে পারে
        while (left <= right) {
            // (left + right) / 2 করলে Integer Overflow হতে পারে অনেক বড় অ্যারের ক্ষেত্রে
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target
            } else if (nums[mid] < target) {
                // টার্গেট বড়, তাই সার্চ স্পেস ডানদিকে শিফট করলাম
                left = mid + 1;
            } else {
                // টার্গেট ছোট, তাই সার্চ স্পেস বামদিকে শিফট করলাম
                right = mid - 1;
            }
        }

        // টার্গেট পাওয়া যায়নি
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println("Target index: " + solution.search(nums, target)); 
        // Expected Output: 4
        
        int target2 = 2;
        System.out.println("Target index: " + solution.search(nums, target2)); 
        // Expected Output: -1 (কারণ 2 অ্যারেতে নেই)
    }
}
