package _16_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Max Heap Example
 * LeetCode 1046: Last Stone Weight (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * কিছু পাথর (stones) আছে যাদের ওজন Array তে দেওয়া আছে। 
 * প্রতি ধাপে আপনাকে সবচেয়ে ভারী (Heaviest) দুটি পাথর নিতে হবে এবং তাদের একে অপরের সাথে ভাঙতে (Smash) হবে।
 * যদি ওজন সমান হয়, দুটিই ধ্বংস হয়ে যাবে। যদি x < y হয় (যেখানে y বড়), তবে x ধ্বংস হবে এবং y এর নতুন ওজন হবে (y - x)।
 * সবশেষে কয়টি পাথর এবং কত ওজন থাকবে? (যদি কোনোটি না থাকে তবে 0)।
 * 
 * এপ্রোচ (Approach):
 * ১. যেহেতু আমাদের বারবার "সবচেয়ে বড়" দুটি ইলিমেন্ট দরকার, তাই আমরা Max Heap ব্যবহার করব।
 * ২. সব পাথর Max Heap এ ঢুকিয়ে দেব।
 * ৩. যতক্ষণ Heap এ ১টির বেশি পাথর আছে:
 *    - প্রথম বড় পাথরটি (y) পপ করব।
 *    - দ্বিতীয় বড় পাথরটি (x) পপ করব।
 *    - যদি y > x হয়, তবে নতুন পাথর (y - x) আবার Heap এ ঢুকিয়ে দেব।
 * ৪. শেষে Heap এ যদি কোনো পাথর থাকে তবে তার ওজন রিটার্ন করব, নাহলে 0।
 * 
 * Time Complexity: O(N log N) - N টি পাথর ঢোকাতে এবং বের করতে।
 * Space Complexity: O(N) - Heap এর জন্য।
 */
public class MaxHeap {

    public int lastStoneWeight(int[] stones) {
        // Max Heap বানানোর জন্য Collections.reverseOrder() ব্যবহার করতে হয়
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // সবগুলো পাথর হিপে ঢোকানো
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // যতক্ষণ ১টির বেশি পাথর আছে
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // সবচেয়ে ভারী
            int x = maxHeap.poll(); // দ্বিতীয় ভারী

            if (y > x) {
                maxHeap.offer(y - x); // ভাঙার পর অবশিষ্ট অংশ আবার হিপে
            }
        }

        // যদি হিপ খালি হয় তবে 0, নাহলে টপের পাথরটি
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        MaxHeap solution = new MaxHeap();
        
        int[] stones = {2, 7, 4, 1, 8, 1};
        
        System.out.println("Last Stone Weight: " + solution.lastStoneWeight(stones)); 
        // Output: 1
        // Explanation:
        // 8 এবং 7 নেব -> বাকি থাকবে 1
        // 4 এবং 2 নেব -> বাকি থাকবে 2
        // 2 এবং 1 (আগের 1) নেব -> বাকি থাকবে 1
        // 1 এবং 1 নেব -> 0
        // শুধু 1 পড়ে থাকবে।
    }
}
