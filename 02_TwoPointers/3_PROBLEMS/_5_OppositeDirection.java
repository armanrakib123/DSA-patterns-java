/**
 * Opposite Direction Two Pointers Example
 * LeetCode 167: Two Sum II - Input Array Is Sorted (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি সর্টেড (Sorted) array (1-indexed) এবং একটি target নম্বর দেওয়া আছে।
 * আপনাকে এমন দুটি ইলিমেন্টের ইনডেক্স খুঁজে বের করতে হবে যাদের যোগফল target এর সমান।
 * আপনাকে এক্সট্রা কোনো মেমরি (যেমন HashMap) ব্যবহার না করে O(1) space এ সলভ করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. যেহেতু Array টি আগে থেকেই Sorted, তাই আমরা Opposite Direction Two Pointers ব্যবহার করব।
 * ২. `left` পয়েন্টারকে ইনডেক্স 0 তে এবং `right` পয়েন্টারকে শেষ ইনডেক্সে রাখব।
 * ৩. এই দুই পয়েন্টারের ভ্যালু যোগ (sum) করব।
 * ৪. যদি `sum == target` হয়, তবে আমরা উত্তর পেয়ে গেছি!
 * ৫. যদি `sum < target` হয়, এর মানে আমাদের যোগফল বাড়াতে হবে। 
 *    যেহেতু Array সর্টেড, তাই বাম দিকে ছোট ভ্যালু আছে। তাই আমরা `left++` করে একটু বড় ভ্যালুর দিকে যাব।
 * ৬. যদি `sum > target` হয়, এর মানে আমাদের যোগফল কমাতে হবে। 
 *    তাই আমরা `right--` করে ছোট ভ্যালুর দিকে আসব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

 
import java.util.Arrays;

 public class _5_OppositeDirection {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                return new int[] {left + 1, right + 1};
            } 
            else if (currentSum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        _5_OppositeDirection solution = new _5_OppositeDirection();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + Arrays.toString(result)); 
        // Output হবে [1, 2] কারণ numbers[0] + numbers[1] = 2 + 7 = 9.
    }
}