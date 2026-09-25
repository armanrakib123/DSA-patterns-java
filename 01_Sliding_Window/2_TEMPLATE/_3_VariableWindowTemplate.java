
public class _3_VariableWindowTemplate {

    public int solveVariableWindow(int[] arr, int targetCondition) {
        int left = 0;
        int maxLength = 0;
        int currentSum = 0;

        for (int right = 0; right < arr.length; right++) {
            
            currentSum += arr[right]; 
            
            while ( currentSum > targetCondition) {
                
                currentSum -= arr[left];
                
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        _3_VariableWindowTemplate solution = new _3_VariableWindowTemplate();
        int[] arr = {1, 2, 3, 4, 5};
        int targetCondition = 7;
        int result = solution.solveVariableWindow(arr, targetCondition);
        System.out.println("Maximum length of subarray with sum less than or equal to " + targetCondition + " is: " + result);
        
        // Output: Maximum length of subarray with sum less than or equal to 7 is: 3
    }
}




















/**
 * ==========================================
 * SLIDING WINDOW PATTERN (VARIABLE / DYNAMIC SIZE)
 * ==========================================
 * 
 * কখন ব্যবহার করবেন: 
 * যখন আপনাকে এমন একটি Subarray বা Substring খুঁজে বের করতে হবে যা একটি নির্দিষ্ট শর্ত 
 * পূরণ করে এবং আপনাকে তার Maximum বা Minimum length চাওয়া হয়েছে। 
 * (যেমন: Longest substring with K distinct characters)।
 * 
 * লজিক:
 * ১. `left` এবং `right` দুটি পয়েন্টার 0 থেকে শুরু হবে।
 * ২. `right` পয়েন্টারটি ডান দিকে সরতে থাকবে এবং উইন্ডোতে এলিমেন্ট অ্যাড করবে (Grow)।
 * ৩. যদি উইন্ডোটি শর্ত ভঙ্গ করে (Invalid), তবে `left` পয়েন্টার ডান দিকে সরিয়ে 
 *    উইন্ডোটিকে ছোট করতে হবে (Shrink) যতক্ষণ না সেটি আবার Valid হয়।
 * ৪. উইন্ডো Valid থাকা অবস্থায় রেজাল্ট আপডেট করতে হবে।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(K) বা O(1) (প্রবলেমের ওপর ভিত্তি করে)
 */