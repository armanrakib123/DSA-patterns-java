import java.util.*;

public class _2_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // বা আমরা সরাসরি `sum = nums[i] + nums[left] + nums[right] == 0` চেক করতে পারি
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } 
                else if (sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        _2_ThreeSum solution = new _2_ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = solution.threeSum(nums);
        System.out.println(triplets); // Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}




















/**
 * LeetCode 15. 3Sum
 * Pattern: Sorting + Two Pointer
 * 
 * প্রবলেম: 
 * একটি integer array দেওয়া আছে। আপনাকে এমন সব ইউনিক (Unique) ট্রিপলেট (তিনটি সংখ্যার সেট) 
 * খুঁজে বের করতে হবে যাদের যোগফল 0 হয়। 
 * শর্ত: ট্রিপলেটগুলো ইউনিক হতে হবে (একই ট্রিপলেট বারবার থাকা যাবে না)।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * ব্রুট ফোর্স এপ্রোচ হবে O(N^3) (৩টি নেস্টেড লুপ)। কিন্তু Two Pointer দিয়ে আমরা এটিকে O(N^2) এ নামিয়ে আনতে পারি।
 * 
 * ১. প্রথমে পুরো Array টিকে Sort করে নিতে হবে। (O(N log N))
 * ২. এরপর একটি লুপ (i) দিয়ে Array ট্রাভার্স করব। `arr[i]` হবে আমাদের প্রথম সংখ্যা (Fixed number)।
 * ৩. আমাদের টার্গেট যোগফল হলো 0। যেহেতু প্রথম সংখ্যাটি `arr[i]`, তাই বাকি দুটি সংখ্যার যোগফল হতে হবে `-arr[i]`।
 *    অর্থাৎ, `arr[left] + arr[right] = -arr[i]` 
 *    যা আসলে Two Sum II (Sorted Array) প্রবলেমে রূপান্তরিত হলো!
 * ৪. ডুপ্লিকেট এড়ানোর জন্য `i`, `left`, এবং `right` পয়েন্টার মুভ করার সময় যদি দেখি সংখ্যাটি আগের সংখ্যার সমান, 
 *    তবে সেটি স্কিপ করে যাব।
 * 
 * Time Complexity: O(N^2) [Sorting N log N + N * Two Pointer N]
 * Space Complexity: O(1) or O(log N) depending on the sorting algorithm implementation.
 */