package _16_Heap;

import java.util.PriorityQueue;

/**
 * Min Heap Example (The Golden Rule)
 * LeetCode 215: Kth Largest Element in an Array (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি আনসর্টেড Array থেকে K-তম বড় (Kth Largest) ইলিমেন্টটি বের করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * রুল: K-th LARGEST বের করতে হলে MIN HEAP ব্যবহার করব।
 * 
 * ১. একটি Min Heap (PriorityQueue) বানাবো।
 * ২. Array এর ইলিমেন্টগুলো একে একে Heap এ ঢোকাবো।
 * ৩. যদি Heap এর সাইজ K এর চেয়ে বড় হয়ে যায়, তবে টপের (Top) ইলিমেন্টটি পপ (Poll) করে দেব।
 *    যেহেতু এটি Min Heap, তাই সবচেয়ে ছোট ইলিমেন্টটি পপ হয়ে যাবে!
 * ৪. লুপ শেষে Heap এ শুধুমাত্র সবচেয়ে বড় K টি ইলিমেন্ট থাকবে। 
 *    আর টপে (Root এ) থাকবে ওই K জনের মধ্যে সবচেয়ে ছোট জন, অর্থাৎ পুরো Array এর K-তম বড় ইলিমেন্ট!
 * 
 * Time Complexity: O(N log K) - N টি ইলিমেন্ট ঢোকাচ্ছি, কিন্তু সাইজ K এ লিমিট রাখছি।
 * Space Complexity: O(K) - Heap এর সাইজ।
 */
public class MinHeap {

    public int findKthLargest(int[] nums, int k) {
        // জাভাতে PriorityQueue বাই ডিফল্ট Min Heap হিসেবে কাজ করে
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            // হিপে যোগ করি
            minHeap.offer(num);

            // যদি সাইজ K এর চেয়ে বেশি হয়ে যায়, তবে সবচেয়ে ছোটটি বের করে দিই
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // টপে K-th Largest ইলিমেন্টটি থেকে যাবে
        return minHeap.peek();
    }

    public static void main(String[] args) {
        MinHeap solution = new MinHeap();
        
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        System.out.println(k + "nd Largest Element is: " + solution.findKthLargest(nums, k)); 
        // Output: 5 (সর্ট করলে হবে 1, 2, 3, 4, 5, 6. তাই ২য় বড় হলো 5)
    }
}
