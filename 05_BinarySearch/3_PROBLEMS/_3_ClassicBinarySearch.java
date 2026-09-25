/**
 * Classic Binary Search Example
 * LeetCode 704: Binary Search (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি সর্টেড (Sorted) array এবং একটি টার্গেট (target) ভ্যালু দেওয়া আছে।
 * যদি টার্গেটটি array তে থাকে তবে তার ইনডেক্স রিটার্ন করুন, না থাকলে -1 রিটার্ন করুন。
 * অ্যালগরিদমটি অবশ্যই O(log n) টাইমে রান করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. `left` = 0 এবং `right` = array এর শেষ ইনডেক্স সেট করব।
 * ২. লুপ চালাব যতক্ষণ `left <= right` থাকে। (<= খুবই জরুরি, নাহলে সিঙ্গেল ইলিমেন্ট array তে ফেইল করবে)।
 * ৩. মাঝখানের ইনডেক্স `mid` বের করব।
 * ৪. যদি `nums[mid] == target` হয়, তবে `mid` রিটার্ন করব।
 * ৫. যদি `nums[mid] < target` হয়, এর মানে টার্গেট ডানদিকে আছে, তাই `left = mid + 1` করব।
 * ৬. যদি `nums[mid] > target` হয়, এর মানে টার্গেট বামদিকে আছে, তাই `right = mid - 1` করব।
 */



 

public class _3_ClassicBinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        _3_ClassicBinarySearch solution = new _3_ClassicBinarySearch();
        
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        
        System.out.println("Index of " + target + ": " + solution.search(nums, target)); // Output: 4
        
        target = 2;
        System.out.println("Index of " + target + ": " + solution.search(nums, target)); // Output: -1
    }
}