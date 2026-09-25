import java.util.*;

public class _SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // মোট উইন্ডোর সংখ্যা
        int resultIndex = 0;
        
        // Deque এ আমরা ভ্যালু না রেখে Index রাখব, যাতে সহজেই বুঝতে পারি এলিমেন্টটি উইন্ডোর ভেতরে আছে কিনা।
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Step 1: Remove elements that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // Step 2: Remove smaller elements from the back
            // কারণ নতুন বড় এলিমেন্ট চলে আসায় এরা আর কখনোই ম্যাক্সিমাম হবে না
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Step 3: Add the current index to the back
            deque.offerLast(i);
            
            // Step 4: Record the maximum for the current window
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()]; // First element is always the max
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        _SlidingWindowMaximum solution = new _SlidingWindowMaximum();
        
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums1, k1))); // Output: [3, 3, 5, 5, 6, 7]
        
        int[] nums2 = {9, 11};
        int k2 = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums2, k2))); // Output: [11]
        
        int[] nums3 = {4, -2};
        int k3 = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums3, k3))); // Output: [4]
    }
}






















/**
 * LeetCode 239. Sliding Window Maximum (Hard)
 * Pattern: Sliding Window + Monotonic Queue (Deque)
 * 
 * প্রবলেম: 
 * একটি Array এবং একটি উইন্ডো সাইজ 'K' দেওয়া আছে। উইন্ডোটি Array এর বাম থেকে ডান দিকে স্লাইড করছে।
 * প্রতিটি উইন্ডোর জন্য আপনাকে সেই উইন্ডোর ম্যাক্সিমাম (সবচেয়ে বড়) এলিমেন্টটি বের করতে হবে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি Sliding Window এর সাথে Monotonic Queue প্যাটার্নের একটি চমৎকার মিশ্রণ।
 * ব্রুট ফোর্স এপ্রোচে প্রতিটি উইন্ডোর ম্যাক্স বের করতে O(N*K) সময় লাগবে, যা Time Limit Exceeded (TLE) খাবে।
 * O(N) এ করার জন্য আমাদের একটি Deque (Double Ended Queue) ব্যবহার করতে হবে।
 * 
 * Deque এর কাজ:
 * এটি সবসময় এলিমেন্টগুলোকে Decreasing Order (বড় থেকে ছোট) এ সাজিয়ে রাখবে (ইন্ডেক্স সেভ করে)।
 * অর্থাৎ Deque এর একেবারে সামনের (First) এলিমেন্টটিই হবে বর্তমান উইন্ডোর ম্যাক্সিমাম।
 * 
 * লজিক:
 * ১. উইন্ডো স্লাইড করার সময়, যে এলিমেন্টটি উইন্ডোর বাইরে চলে গেছে (index <= i - K), তাকে Deque এর First থেকে রিমুভ করব।
 * ২. নতুন এলিমেন্টটি Deque এ পুশ করার আগে, Deque এর Last এ থাকা এমন সব এলিমেন্ট রিমুভ করে দেব যারা 
 *    নতুন এলিমেন্টটির চেয়ে ছোট। কারণ তারা আর কখনোই ম্যাক্সিমাম হতে পারবে না (যেহেতু নতুন বড় এলিমেন্ট এসে গেছে)।
 * ৩. এরপর নতুন এলিমেন্টের ইনডেক্স Deque এ পুশ করব।
 * ৪. যখন আমরা অন্তত K সাইজের উইন্ডোতে পৌঁছাব (i >= K - 1), তখন Deque এর First এলিমেন্টটি হবে উইন্ডোর ম্যাক্স, 
 *    সেটিকে রেজাল্ট Array তে সেভ করব।
 * 
 * Time Complexity: O(N) (প্রতিটি এলিমেন্ট Deque এ একবার ঢুকে এবং একবার বের হয়)
 * Space Complexity: O(K)
 */