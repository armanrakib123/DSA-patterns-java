package _14_MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Next Greater Element Example
 * LeetCode 496: Next Greater Element I (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * দুটি Array (nums1 এবং nums2) দেওয়া আছে। nums1 হলো nums2 এর একটি সাবসেট (Subset)।
 * nums1 এর প্রতিটি ইলিমেন্টের জন্য nums2 তে তার Next Greater Element (ডানদিকের প্রথম বড় সংখ্যা) বের করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. প্রথমে আমরা Monotonic Stack (টেমপ্লেট ১) ব্যবহার করে nums2 এর সবার Next Greater বের করব।
 * ২. যেহেতু nums1 এর ইলিমেন্টগুলো খুঁজতে হবে, তাই আমরা একটি HashMap এ 
 *    (Element -> Next Greater Element) সেভ করে রাখব, যাতে O(1) এ উত্তর পাওয়া যায়।
 * ৩. এরপর nums1 এ লুপ চালিয়ে ম্যাপ থেকে উত্তরগুলো নিয়ে একটি Array তে রিটার্ন করব।
 * 
 * Time Complexity: O(N + M) - যেখানে N হলো nums2 এর সাইজ এবং M হলো nums1 এর সাইজ।
 * Space Complexity: O(N) - Stack এবং HashMap এর জন্য।
 */
public class NextGreater {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // ম্যাপে রাখব: <সংখ্যা, তার Next Greater>
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // স্টেপ ১: nums2 এর সবার Next Greater বের করা
        for (int num : nums2) {
            // যদি বর্তমান সংখ্যাটি স্ট্যাকের ওপরের সংখ্যার চেয়ে বড় হয়
            while (!stack.isEmpty() && num > stack.peek()) {
                // স্ট্যাকের ওপরের সংখ্যাটি তার Next Greater পেয়ে গেছে!
                map.put(stack.pop(), num);
            }
            // বর্তমান সংখ্যাটিকে স্ট্যাকে রাখি
            stack.push(num);
        }

        // স্ট্যাকে যারা থেকে গেছে, তাদের Next Greater নেই (-1)
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // স্টেপ ২: nums1 এর জন্য উত্তর তৈরি করা
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreater solution = new NextGreater();
        
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println("Next Greater Elements: " + Arrays.toString(result)); 
        // Output: [-1, 3, -1]
        // Explanation: 
        // 4 এর ডানে কেউ বড় নেই (-1)
        // 1 এর ডানে প্রথম বড় 3
        // 2 এর ডানে কেউ বড় নেই (-1)
    }
}
