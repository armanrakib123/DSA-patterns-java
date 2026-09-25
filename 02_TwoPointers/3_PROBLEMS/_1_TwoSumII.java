public class _1_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                return new int[]{left + 1, right + 1};
            } 
            else if (currentSum < target) {
                left++;
            } 
            else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        _1_TwoSumII solution = new _1_TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
























/**
 * LeetCode 167. Two Sum II - Input Array Is Sorted
 * Pattern: Two Pointer (Opposite Direction)
 * 
 * প্রবলেম: 
 * আপনাকে একটি 1-indexed (১ থেকে শুরু হওয়া) Sorted Array দেওয়া হবে। 
 * আপনাকে এমন দুটি ইনডেক্স খুঁজে বের করতে হবে যাদের এলিমেন্টের যোগফল টার্গেটের সমান হয়।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * যেহেতু Array টি আগে থেকেই সর্টেড, আমরা Opposite Direction Two Pointer ব্যবহার করতে পারি।
 * ১. একটি পয়েন্টার (left) শুরু থেকে এবং আরেকটি (right) শেষ থেকে বসাব।
 * ২. যোগফল যদি target এর চেয়ে বড় হয়, তার মানে আমাদের ছোট সংখ্যা দরকার। তাই right পয়েন্টার এক ঘর বামে আনব (right--)
 * ৩. যোগফল যদি target এর চেয়ে ছোট হয়, তার মানে আমাদের বড় সংখ্যা দরকার। তাই left পয়েন্টার এক ঘর ডানে নেব (left++)
 * ৪. যেহেতু 1-indexed array, তাই রিটার্ন করার সময় ইনডেক্সগুলোর সাথে ১ যোগ করতে হবে।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */