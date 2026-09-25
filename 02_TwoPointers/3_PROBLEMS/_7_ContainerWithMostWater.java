public class _7_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            
            int currentHeight = Math.min(height[left], height[right]);
            
            int currentArea = width * currentHeight;
            
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++; 
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        _7_ContainerWithMostWater solution = new _7_ContainerWithMostWater();
        
        int[] height = {1,8,6,2,5,4,8,3,7};
        
        int result = solution.maxArea(height);
        System.out.println("Maximum Water Container Area: " + result); 
        // Expected Output: 49 (পিলার 8 এবং 7 এর মধ্যে, width = 7)
    }
}



















/**
 * 🎯 Problem 2: Container With Most Water (LeetCode 11)
 * লেভেল: Medium
 * 
 * প্রশ্ন: আপনাকে একটি অ্যারে height[] দেওয়া হবে, যেখানে প্রতিটি ইলিমেন্ট একটি খাড়া লাইনের উচ্চতা নির্দেশ করে।
 * আপনাকে এমন দুটি লাইন বের করতে হবে, যাদের মধ্যে পানি রাখলে সবচেয়ে বেশি পরিমাণ পানি (Maximum Area) রাখা যাবে।
 * (যেমন একটি আয়তক্ষেত্র, যার ক্ষেত্রফল = দৈর্ঘ্য * উচ্চতা)
 * 
 * 💡 Brute Force Approach:
 * সব জোড়া লাইন চেক করে এরিয়া বের করা।
 * Time Complexity: O(N^2) (ইন্টারভিউতে গ্রহণযোগ্য নয়)
 * 
 * 🚀 Optimal Approach (Two Pointers & Greedy):
 * আমরা দুটি পয়েন্টার নেব: left = 0, right = n - 1.
 * পানির পরিমাণ (Area) = (right - left) * min(height[left], height[right])
 * 
 * এখানে দৈর্ঘ্য (width) হলো (right - left), আর উচ্চতা (height) হবে দুটির মধ্যে যেটি ছোট, সেটি। 
 * কারণ বড় লাইনের সমান পানি ভরতে গেলে তা ছোট লাইনের ওপর দিয়ে উপচে পড়ে যাবে।
 * 
 * লজিক:
 * ১. প্রথমে সবচেয়ে বড় দৈর্ঘ্যের (width) জন্য Area ক্যালকুলেট করে maxArea আপডেট করব।
 * ২. এরপর কোন পয়েন্টার মুভ করব?
 *    যেহেতু আমরা width কমিয়ে দিচ্ছি (পয়েন্টার কাছে আনছি), তাই আমাদের Area বাড়ানোর একমাত্র উপায় হলো বড় height খোঁজা।
 *    তাই left এবং right এর মধ্যে যার উচ্চতা ছোট, আমরা তাকে বাদ দিয়ে (point move করে) সামনে এগোব, এই আশায় যে হয়তো পরে আরও বড় উচ্চতা পাব।
 * 
 * Time Complexity: O(N) (লুপটি সর্বোচ্চ একবারই রান করবে)
 * Space Complexity: O(1)
 */


