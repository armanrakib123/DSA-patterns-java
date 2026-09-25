public class _9_TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += (rightMax - height[right]);
                }
                right--;
            }
        }
        
        return totalWater;
    }
    public static void main(String[] args) {
        _9_TrappingRainWater solution = new _9_TrappingRainWater();
        
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height1)); // Output: 6
        
        int[] height2 = {4,2,0,3,2,5};
        System.out.println(solution.trap(height2)); // Output: 9
    }
}













/**
 * LeetCode 42. Trapping Rain Water
 * Pattern: Two Pointer (Opposite Direction - Advanced)
 * 
 * প্রবলেম: 
 * আপনাকে একটি Array দেওয়া আছে যা বিভিন্ন বিল্ডিং বা ব্লকের উচ্চতাকে (elevation map) রিপ্রেজেন্ট করে।
 * বৃষ্টি হলে এই ব্লকগুলোর মাঝে কত ইউনিট পানি জমে থাকতে পারবে তা বের করতে হবে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * একটি নির্দিষ্ট ব্লকের ওপর কতটুকু পানি জমবে তা নির্ভর করে তার বাম দিকের সবচেয়ে উঁচু ব্লক (Left Max) 
 * এবং ডান দিকের সবচেয়ে উঁচু ব্লকের (Right Max) ওপর। 
 * পানি জমবে = Min(Left Max, Right Max) - Current Block Height
 * 
 * Two Pointer Approach (O(N) time, O(1) space):
 * ১. `left` পয়েন্টার শুরু থেকে এবং `right` পয়েন্টার শেষ থেকে শুরু হবে।
 * ২. `leftMax` এবং `rightMax` ভেরিয়েবল দুটি মেইনটেইন করব।
 * ৩. যদি `height[left] <= height[right]` হয়, তার মানে হলো `rightMax` নিশ্চিতভাবেই `leftMax` এর সমান বা বড় হবে। 
 *    তাই আমরা নিশ্চিন্তে `leftMax` এর ওপর ভিত্তি করে পানি হিসাব করতে পারি এবং `left` পয়েন্টার আগাতে পারি।
 * ৪. বিপরীতভাবে, যদি `height[right] < height[left]` হয়, তবে `rightMax` এর ওপর ভিত্তি করে হিসাব করে `right` কমাবো।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */