public class _6_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

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
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--; 
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        _6_TrappingRainWater solution = new _6_TrappingRainWater();
        
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        int result = solution.trap(height);
        System.out.println("Total Trapped Water: " + result); 
        // Expected Output: 6
    }
}














/**
 * 🎯 Problem 3: Trapping Rain Water (LeetCode 42)
 * লেভেল: Hard (FAANG's Most Asked Question)
 * 
 * প্রশ্ন: আপনাকে একটি অ্যারে height[] দেওয়া হবে, যা ব্লকের উচ্চতা নির্দেশ করে। 
 * বৃষ্টি হলে এই ব্লকগুলোর মধ্যে মোট কত ইউনিট পানি জমবে তা বের করতে হবে।
 * 
 * 💡 Core Concept:
 * যেকোনো ইনডেক্স `i` তে পানি জমার পরিমাণ নির্ভর করে তার বাম দিকের সবচেয়ে উঁচু ব্লক (maxLeft) 
 * এবং ডান দিকের সবচেয়ে উঁচু ব্লকের (maxRight) ওপর। 
 * i তম পজিশনে জমানো পানি = min(maxLeft, maxRight) - height[i] (অবশ্যই যদি এর মান > 0 হয়)।
 * 
 * 🛠️ Approach 1 (Prefix & Suffix Array):
 * দুটি আলাদা অ্যারে তৈরি করে বাম এবং ডান দিকের ম্যাক্সিমাম সেভ করে রাখা।
 * Time: O(N), Space: O(N)
 * 
 * 🚀 Optimal Approach (Two Pointers):
 * আমরা O(1) স্পেসে এটি সলভ করতে পারি। 
 * দুটি পয়েন্টার left এবং right নেব। সাথে leftMax এবং rightMax দুটি ভেরিয়েবল রাখব।
 * 
 * লজিক:
 * ১. যদি height[left] <= height[right] হয়, তার মানে আমরা নিশ্চিত যে ডান দিকে বড় কোনো দেওয়াল আছে।
 *    তাই আমরা শুধু leftMax নিয়ে চিন্তা করব।
 *    - যদি height[left] >= leftMax হয়, তবে পানি জমবে না (leftMax আপডেট হবে)।
 *    - নতুবা পানি জমবে = leftMax - height[left]।
 *    - এরপর left++।
 * ২. একইভাবে, যদি height[left] > height[right] হয়, আমরা ডান দিক নিয়ে কাজ করব এবং right-- করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */


