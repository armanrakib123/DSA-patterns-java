public class _4_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int width = right - left;  
            int currentHeight = Math.min(height[left], height[right]); 
            int area = width * currentHeight;
            
            maxArea = Math.max(maxArea, area);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    public static void main(String[] args) {
        _4_ContainerWithMostWater solution = new _4_ContainerWithMostWater();
        
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height1)); 
        // Output: 49 height[1] = 8, height[8] = 7, width = 8 - 1 = 7, area = 7 * 7 = 49
        
        int[] height2 = {1,1};
        System.out.println(solution.maxArea(height2));
        // Output: 1 height[0] = 1, height[1] = 1, width = 1 - 0 = 1, area = 1 * 1 = 1
    }
}




















/**
 * LeetCode 11. Container With Most Water
 * Pattern: Two Pointer (Opposite Direction) - Greedy Approach
 * 
 * প্রবলেম: 
 * আপনাকে একটি Array দেওয়া আছে যা বিভিন্ন উচ্চতার খাড়া লাইন (Vertical Lines) কে রিপ্রেজেন্ট করে।
 * আপনাকে এমন দুটি লাইন বেছে নিতে হবে যারা x-অক্ষের সাথে মিলে এমন একটি কন্টেইনার তৈরি করে 
 * যাতে সবচেয়ে বেশি পরিমাণ পানি (Water) ধরে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * একটি কন্টেইনারে কতটুকু পানি ধরবে তা নির্ভর করে দুটি জিনিসের ওপর: 
 *  ১. প্রস্থ (Width) বা দুটি লাইনের মধ্যবর্তী দূরত্ব।
 *  ২. উচ্চতা (Height) বা দুটি লাইনের মধ্যে ছোট লাইনটির উচ্চতা (কারণ বড় লাইন পর্যন্ত পানি ভরলে তা উপচে পড়বে)।
 *  Area = (right - left) * min(height[left], height[right])
 * 
 * ব্রুট ফোর্স O(N^2) হবে। Two Pointer দিয়ে আমরা O(N) এ করতে পারি।
 * 
 * লজিক (Greedy Two Pointer):
 * ১. `left` পয়েন্টার 0 এ এবং `right` পয়েন্টার শেষে রাখব, যেন আমাদের প্রস্থ (Width) সর্বোচ্চ হয়।
 * ২. বর্তমান Area বের করে `maxArea` আপডেট করব।
 * ৩. এরপর কোন পয়েন্টারটি মুভ করব? 
 *    যেহেতু কন্টেইনারের উচ্চতা নির্ভর করে ছোট লাইনটির ওপর, আমরা সবসময় ছোট লাইনটিকে স্কিপ করব (কারণ ছোট লাইনের সাথে 
 *    অন্য যেকোনো লাইন নিলে প্রস্থ কমবে এবং উচ্চতাও ঐ ছোট লাইনের বেশি হতে পারবে না, তাই Area কখনোই বাড়বে না)।
 *    তাই যদি `height[left] < height[right]` হয়, তবে `left++` করব, নাহলে `right--` করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */