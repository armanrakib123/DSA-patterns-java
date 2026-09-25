/**
 * Lower Bound / First Occurrence Example
 * LeetCode 34: Find First and Last Position of Element in Sorted Array (Medium) - First Part
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি সর্টেড array তে ডুপ্লিকেট ইলিমেন্ট থাকতে পারে। একটি টার্গেট (target) দেওয়া আছে।
 * আপনাকে টার্গেটটির প্রথম (First/Lower Bound) এবং শেষ (Last/Upper Bound) ইনডেক্স বের করতে হবে।
 * 
 * এই ক্লাসে আমরা শুধু First Occurrence (Lower Bound) নিয়ে আলোচনা করব।
 * 
 * এপ্রোচ (Approach):
 * ১. রেগুলার বাইনারি সার্চের মতোই করব।
 * ২. যখন `nums[mid] == target` হবে, আমরা রিটার্ন করব না! কারণ আমরা জানি না এর বামদিকে আরও টার্গেট আছে কি না।
 * ৩. তাই আমরা একটি ভেরিয়েবল (`firstPos`) এ ইনডেক্সটি সেভ করে রাখব এবং বামদিকে খোঁজা চালিয়ে যাব (`right = mid - 1`)।
 */








public class _4_LowerBound {

    public int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPos = mid;
                right = mid - 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstPos;
    }

    public static void main(String[] args) {
        _4_LowerBound solution = new _4_LowerBound();
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        
        System.out.println("First occurrence of " + target + " is at index: " + solution.findFirstOccurrence(nums, target)); 
        // Output: 3
    }
}
