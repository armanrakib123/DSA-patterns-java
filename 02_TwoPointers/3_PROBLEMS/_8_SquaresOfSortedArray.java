public class _8_SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        int pos = n - 1; 
        
        while (left <= right) { 
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
            
            pos--;
        }
        
        return result;
    }
    public static void main(String[] args) {
        _8_SquaresOfSortedArray solution = new _8_SquaresOfSortedArray();
        
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = solution.sortedSquares(nums1);
        // Output: [0, 1, 9, 16, 100]
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = solution.sortedSquares(nums2);
        // Output: [4, 9, 9, 49, 121]
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



















/**
 * LeetCode 977. Squares of a Sorted Array
 * Pattern: Two Pointer (Opposite Direction)
 * 
 * প্রবলেম: 
 * একটি Sorted Array দেওয়া আছে যেখানে নেগেটিভ এবং পজিটিভ সংখ্যা থাকতে পারে।
 * আপনাকে প্রতিটি সংখ্যার বর্গ (Square) করে একটি নতুন Array রিটার্ন করতে হবে, যা অবশ্যই Sorted হতে হবে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * যদি আমরা সবগুলোকে বর্গ করে তারপর সর্ট করি (যেমন Arrays.sort()), তবে Time Complexity হবে O(N log N)।
 * কিন্তু আমরা Two Pointer ব্যবহার করে O(N) এ করতে পারি।
 * 
 * Array টি সর্টেড, তাই নেগেটিভ সংখ্যাগুলো শুরুতে আছে এবং পজিটিভগুলো শেষে।
 * যখন আমরা বর্গ করব, তখন সবচেয়ে বড় সংখ্যাগুলো হয় একদম শুরুতে (নেগেটিভ বড় সংখ্যা) থাকবে, নাহয় একদম শেষে থাকবে।
 * 
 * লজিক:
 * ১. `left` পয়েন্টার 0 তে এবং `right` পয়েন্টার শেষে রাখব।
 * ২. একটি নতুন `result` Array নেব একই সাইজের এবং এর শেষের ইনডেক্স `pos` ট্র্যাক করব।
 * ৩. `left` এর স্কোয়ার এবং `right` এর স্কোয়ার তুলনা করব।
 * ৪. যে স্কোয়ারটি বড়, সেটিকে `result` এর শেষে (`pos`) বসাব এবং সেইদিকের পয়েন্টার মুভ করব।
 * ৫. `pos` এক ঘর বামে সরাব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) (For the result array)
 */