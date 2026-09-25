package _16_Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Top K Frequent Elements Example
 * LeetCode 347: Top K Frequent Elements (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array এবং একটি সংখ্যা K দেওয়া আছে। 
 * আপনাকে Array এর মধ্যে সবচেয়ে বেশিবার (Top K Frequent) আসা K টি ইলিমেন্ট বের করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * এটি Heap এর অন্যতম বিখ্যাত প্রবলেম।
 * 
 * ১. প্রথমে একটি HashMap ব্যবহার করে প্রতিটি নাম্বারের ফ্রিকোয়েন্সি (Frequency) গুনে রাখব।
 * ২. এরপর একটি Min Heap বানাবো। কিন্তু এখানে Heap টি নাম্বার অনুযায়ী সর্ট হবে না, 
 *    সর্ট হবে তাদের ফ্রিকোয়েন্সি অনুযায়ী! (Custom Comparator ব্যবহার করে)।
 * ৩. ম্যাপের সবগুলো এন্ট্রি (Key-Value) Heap এ ঢোকাবো।
 * ৪. যখনই Heap এর সাইজ K এর চেয়ে বড় হবে, আমরা টপ ইলিমেন্ট (যার ফ্রিকোয়েন্সি সবচেয়ে কম) পপ করে দেব।
 * ৫. লুপ শেষে Heap এ যে K টি ইলিমেন্ট থাকবে, তারাই হলো Top K Frequent!
 * 
 * Time Complexity: O(N log K) - N টি ইলিমেন্ট ঢোকাচ্ছি, কিন্তু সাইজ K এ লিমিট রাখছি।
 * Space Complexity: O(N) - HashMap এর জন্য।
 */
public class TopK {

    public int[] topKFrequent(int[] nums, int k) {
        // ১. ফ্রিকোয়েন্সি কাউন্ট করা
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // ২. Min Heap তৈরি করা (ফ্রিকোয়েন্সি অনুযায়ী)
        // a এবং b হলো ম্যাপের কী (Key)। আমরা map.get(a) এবং map.get(b) এর মধ্যে তুলনা করছি।
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(map.get(a), map.get(b))
        );

        // ৩. Heap এ ডেটা পুশ করা
        for (int num : map.keySet()) {
            minHeap.offer(num);

            // যদি সাইজ K এর চেয়ে বড় হয়, তবে সবচেয়ে কম ফ্রিকোয়েন্সির ইলিমেন্টটি বাদ দিয়ে দিই
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // ৪. রেজাল্ট তৈরি করা
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopK solution = new TopK();
        
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        System.out.println("Top " + k + " Frequent Elements: " + Arrays.toString(solution.topKFrequent(nums, k))); 
        // Output: [2, 1] বা [1, 2] (অর্ডার ম্যাটার করে না)
    }
}
