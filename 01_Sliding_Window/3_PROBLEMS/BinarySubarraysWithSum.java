public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0; 
        
        int left = 0;
        int sum = 0;
        int count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            
            count += (right - left + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        BinarySubarraysWithSum solution = new BinarySubarraysWithSum();
        
        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;
        System.out.println(solution.numSubarraysWithSum(nums1, goal1)); // Output: 4
        
        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        System.out.println(solution.numSubarraysWithSum(nums2, goal2)); // Output: 15
    }
}



















/**
 * LeetCode 930. Binary Subarrays With Sum
 * Pattern: Sliding Window (At Most K Trick) or Prefix Sum
 * 
 * প্রবলেম: 
 * একটি Binary Array (যেখানে শুধু 0 এবং 1 আছে) এবং একটি integer `goal` দেওয়া আছে।
 * আপনাকে বলতে হবে কয়টি Subarray আছে যাদের যোগফল ঠিক `goal` এর সমান।
 * 
 * সলিউশন (Sliding Window - At Most Trick):
 * Sliding Window সাধারণত "Exact K" বের করতে পারে না, কারণ যদি Array তে 0 থাকে তবে উইন্ডো বাড়ালেও 
 * যোগফল বাড়ে না, ফলে উইন্ডো সাইজ একাধিক হতে পারে।
 * এই সমস্যা সমাধানের জন্য একটি চমৎকার ট্রিক (Trick) আছে:
 * **Exact(K) = AtMost(K) - AtMost(K - 1)**
 * অর্থাৎ, "সর্বোচ্চ K" যোগফলের সাব-অ্যারের সংখ্যা থেকে "সর্বোচ্চ K-1" যোগফলের সাব-অ্যারের সংখ্যা বিয়োগ 
 * করলেই আমরা ঠিক "K" যোগফলের সাব-অ্যারের সংখ্যা পেয়ে যাব।
 * 
 * লজিক:
 * ১. একটি Helper Function লিখব `atMost(nums, goal)` যা বের করবে কয়টি সাব-অ্যারের যোগফল <= goal।
 * ২. Helper function এ Sliding Window ব্যবহার করব। `sum > goal` হলে উইন্ডো Shrink করব।
 * ৩. প্রতি ভ্যালিড স্টেপে সাব-অ্যারের সংখ্যা হবে `(right - left + 1)`।
 * ৪. মেইন ফাংশনে `atMost(nums, goal) - atMost(nums, goal - 1)` রিটার্ন করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
