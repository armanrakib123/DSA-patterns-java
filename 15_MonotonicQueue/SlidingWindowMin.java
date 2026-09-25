package _15_MonotonicQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Monotonic Queue (Minimum Variant)
 * 
 * প্রবলেম: Sliding Window Maximum (LC 239) এর মতো, 
 * কিন্তু এবার প্রতিটি উইন্ডোর Minimum ভ্যালু বের করতে হবে।
 * 
 * এপ্রোচ (Monotonic Increasing Deque):
 * ১. ম্যাক্সিমামের ক্ষেত্রে আমরা বড় থেকে ছোট সাজিয়েছিলাম (যাতে টপে ম্যাক্সিমাম থাকে)।
 * ২. এবার আমরা ছোট থেকে বড় (Increasing) সাজাব, যাতে টপে (Front) মিনিমাম থাকে।
 * ৩. রুল ২ এ শুধু সাইন চেঞ্জ হবে: যদি নতুন ইলিমেন্ট পেছনের ইলিমেন্টগুলোর চেয়ে 
 *    ছোট (বা সমান) হয়, তবে পেছনের বড় ইলিমেন্টগুলোকে পপ করব।
 */
public class SlidingWindowMin {

    public int[] minSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            
            // রুল ১: উইন্ডোর বাইরের ইলিমেন্ট বাদ দেওয়া
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // রুল ২: বড় ইলিমেন্টগুলোকে পেছন থেকে বাদ দেওয়া (এটাই একমাত্র পরিবর্তন)
            while (!deque.isEmpty() && nums[i] <= nums[deque.peekLast()]) {
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
        SlidingWindowMin solution = new SlidingWindowMin();
        
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        System.out.println("Sliding Window Minimums: " + Arrays.toString(solution.minSlidingWindow(nums, k))); 
        // Output: [-1, -3, -3, -3, 3, 3]
    }
}
