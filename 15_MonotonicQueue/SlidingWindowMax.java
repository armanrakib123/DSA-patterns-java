package _15_MonotonicQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Monotonic Queue Example LeetCode 239: Sliding Window Maximum (Hard) -
 * Software Company Favorite
 *
 * প্রবলেম স্টেটমেন্ট: একটি integer array এবং একটি উইন্ডো সাইজ k দেওয়া আছে।
 * উইন্ডোটি array এর বাম থেকে ডানে স্লাইড করছে। প্রতিটি উইন্ডোর ম্যাক্সিমাম
 * ভ্যালুগুলো নিয়ে একটি array রিটার্ন করতে হবে।
 *
 * এপ্রোচ (Monotonic Decreasing Deque): ১. একটি Deque (ডেক) নেব যেখানে
 * ইনডেক্সগুলো রাখব (যাতে উইন্ডোর সাইজ চেক করা যায়)। ২. Deque এর ভেতরে
 * ভ্যালুগুলো সবসময় বড় থেকে ছোট (Decreasing) অর্ডারে থাকবে। অর্থাৎ,
 * deque.peekFirst() সবসময় বর্তমান উইন্ডোর ম্যাক্সিমাম ভ্যালু দেবে। ৩. লুপ
 * চালিয়ে রুলস ফলো করব: - রুল ১: যদি Deque এর প্রথম ইনডেক্সটি উইন্ডোর সাইজের (i
 * - k) বাইরে চলে যায়, তবে তাকে পপ করব। - রুল ২: যদি নতুন ইলিমেন্টটি Deque এর
 * শেষের ইলিমেন্টগুলোর চেয়ে বড় হয়, তবে ছোটগুলোকে পপ করব। - রুল ৩: নতুন
 * ইলিমেন্টের ইনডেক্স পুশ করব। - রুল ৪: যদি উইন্ডোটি পূর্ণ সাইজ (i >= k - 1) এ
 * পৌঁছায়, তবে ম্যাক্সিমাম (First Element) রেজাল্টে যোগ করব।
 *
 * Time Complexity: O(N) - প্রতিটি ইলিমেন্ট সর্বোচ্চ একবার Deque তে ঢোকে এবং
 * একবার বের হয়। Space Complexity: O(K) - Deque এর সাইজ সর্বোচ্চ K হতে পারে।
 */
public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // Deque তে ইনডেক্স রাখব
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // রুল ১: উইন্ডোর বাইরের ইলিমেন্ট বাদ দেওয়া
            // i - k + 1 হলো উইন্ডোর শুরুর ইনডেক্স। যদি Deque এর প্রথম ইনডেক্স এর চেয়ে ছোট হয়, মানে সে বাইরে!
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // রুল ২: ছোট ইলিমেন্টগুলোকে পেছন থেকে বাদ দেওয়া
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // রুল ৩: নতুন ইনডেক্স পুশ করা
            deque.offerLast(i);

            // রুল ৪: উইন্ডো সাইজ K তে পৌঁছালে রেজাল্ট সেভ করা
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMax solution = new SlidingWindowMax();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Sliding Window Maximums: " + Arrays.toString(solution.maxSlidingWindow(nums, k)));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
