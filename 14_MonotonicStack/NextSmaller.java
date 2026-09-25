package _14_MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater Element (Distance Variant)
 * LeetCode 739: Daily Temperatures (Medium) - FAANG Favorite
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি Array তে প্রতিদিনের তাপমাত্রা (temperatures) দেওয়া আছে। 
 * আপনাকে প্রতিটি দিনের জন্য বলতে হবে যে, কত দিন (Days) অপেক্ষা করলে 
 * একটি গরম দিন (উষ্ণ তাপমাত্রা) পাওয়া যাবে। যদি ভবিষ্যতে এমন কোনো দিন না থাকে, তবে 0 হবে।
 * 
 * এপ্রোচ (Approach):
 * এটি হুবহু Next Greater Element এর প্রবলেম! শুধু পার্থক্য হলো: 
 * আমরা ভ্যালু না চেয়ে, তাদের ইনডেক্সের দূরত্ব (Distance) চাচ্ছি।
 * 
 * ১. একটি Monotonic Decreasing Stack ব্যবহার করব।
 * ২. স্ট্যাকে আমরা 'তাপমাত্রা' না রেখে তার 'ইনডেক্স' (Index) রাখব।
 * ৩. যখনই স্ট্যাকের ওপরের দিনের চেয়ে বর্তমান দিনের তাপমাত্রা বেশি হবে, 
 *    আমরা বুঝব স্ট্যাকের ওপরের দিনটি তার 'গরম দিন' পেয়ে গেছে!
 * ৪. তখন দূরত্ব হবে: `বর্তমান ইনডেক্স - স্ট্যাক থেকে বের করা ইনডেক্স`।
 */
public class NextSmaller {

    // ক্লাসের নাম NextSmaller হলেও এটি Next Greater এর একটি ভ্যারিয়েশন (Distance based)
    // Next Smaller এর বেসিক টেমপ্লেটটি Template.java তে দেওয়া আছে।
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        // স্ট্যাকে ইনডেক্স রাখব
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            
            // যতক্ষণ বর্তমান তাপমাত্রা স্ট্যাকের ওপরের দিনের তাপমাত্রার চেয়ে বেশি
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // স্ট্যাকের ওপরের দিনটি তার গরম দিন পেয়ে গেছে!
                int prevDayIndex = stack.pop();
                
                // দূরত্ব (Days) ক্যালকুলেট করে রেজাল্টে রাখি
                result[prevDayIndex] = i - prevDayIndex;
            }
            
            // বর্তমান দিনের ইনডেক্স স্ট্যাকে রাখি
            stack.push(i);
        }

        // স্ট্যাকে যারা থেকে যাবে তাদের জন্য 0 বসবে (যা জাভাতে int array তে ডিফল্ট থাকে)
        return result;
    }

    public static void main(String[] args) {
        NextSmaller solution = new NextSmaller();
        
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution.dailyTemperatures(temps);
        
        System.out.println("Wait days: " + Arrays.toString(res)); 
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
