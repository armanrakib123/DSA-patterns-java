public class _7_SortColors {
    public void sortColors(int[] nums) {
        int left = 0;               
        int right = nums.length - 1; 
        int curr = 0;         
        
        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++; 
            } 
            else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } 
            else {
                curr++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }





    public static void main(String[] args) {
        _7_SortColors solution = new _7_SortColors();
        
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums1);
        // Output: [0, 0, 1, 1, 2, 2]
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        // Output: [0, 1, 2]
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}





















/**
 * LeetCode 75. Sort Colors (Dutch National Flag Problem)
 * Pattern: Two Pointer (Three Pointers / Partitioning)
 * 
 * প্রবলেম: 
 * একটি Array তে শুধুমাত্র 0 (Red), 1 (White) এবং 2 (Blue) আছে। 
 * আপনাকে এদেরকে সর্ট (Sort) করতে হবে যেন সবগুলো 0 প্রথমে, তারপর 1 এবং শেষে 2 থাকে।
 * শর্ত: আপনাকে In-place সর্ট করতে হবে এবং লাইব্রেরি সর্ট (O(N log N)) ব্যবহার করা যাবে না।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি বিখ্যাত "Dutch National Flag Algorithm" যা Edsger W. Dijkstra তৈরি করেছিলেন।
 * আমরা ৩টি পয়েন্টার ব্যবহার করব:
 * 1. `left`: 0 গুলো রাখার বাউন্ডারি (এর বামে সব 0 থাকবে)। শুরু হবে 0 থেকে।
 * 2. `right`: 2 গুলো রাখার বাউন্ডারি (এর ডানে সব 2 থাকবে)। শুরু হবে array এর শেষ থেকে।
 * 3. `curr`: বর্তমান এলিমেন্ট স্ক্যান করার জন্য। শুরু হবে 0 থেকে।
 * 
 * লজিক:
 * `curr` পয়েন্টার দিয়ে array ট্রাভার্স করব:
 * - যদি `nums[curr] == 0` হয়: এটি বামে (left) যাওয়া উচিত। তাই left এর সাথে সোয়াপ করব, এবং left ও curr দুটোই বাড়াব।
 * - যদি `nums[curr] == 2` হয়: এটি ডানে (right) যাওয়া উচিত। তাই right এর সাথে সোয়াপ করব, এবং right কমাব। (curr বাড়াব না, কারণ right থেকে যে নতুন সংখ্যাটি আসল সেটি আবার চেক করতে হবে)।
 * - যদি `nums[curr] == 1` হয়: এটি মাঝখানেই থাকবে। তাই শুধু `curr++` করব।
 * 
 * Time Complexity: O(N) (Single Pass)
 * Space Complexity: O(1)
 */