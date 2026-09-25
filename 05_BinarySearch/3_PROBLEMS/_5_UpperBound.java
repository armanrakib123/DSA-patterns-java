/**
 * Upper Bound / Last Occurrence Example
 * LeetCode 34: Find First and Last Position of Element in Sorted Array (Medium) - Second Part
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি সর্টেড array তে একটি টার্গেট (target) এর শেষ (Last/Upper Bound) ইনডেক্স বের করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. Lower Bound এর ঠিক উল্টো।
 * ২. যখন `nums[mid] == target` হবে, আমরা রিটার্ন করব না। 
 * ৩. আমরা ইনডেক্সটি `lastPos` এ সেভ রাখব এবং ডানদিকে খোঁজা চালিয়ে যাব (`left = mid + 1`), 
 *    কারণ আমরা দেখতে চাই এর ডানে আরও কোনো টার্গেট আছে কি না।
 */








public class _5_UpperBound {

    public int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPos = mid;
                left = mid + 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastPos;
    }

    public static void main(String[] args) {
        _5_UpperBound solution = new _5_UpperBound();
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        
        System.out.println("Last occurrence of " + target + " is at index: " + solution.findLastOccurrence(nums, target)); 
        // Output: 4
    }
}