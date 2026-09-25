package _14_MonotonicStack;

import java.util.Stack;

/**
 * Advanced Monotonic Stack Example
 * LeetCode 84: Largest Rectangle in Histogram (Hard)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি হিস্টোগ্রাম (Histogram) এর বার (Bar) গুলোর উচ্চতা দেওয়া আছে। 
 * প্রতিটি বারের প্রস্থ 1। আপনাকে সবচেয়ে বড় আয়তক্ষেত্র (Largest Rectangle) এর এরিয়া বের করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * একটি বার কতটুকু চওড়া (Wide) হতে পারবে তা নির্ভর করে তার বামে এবং ডানে প্রথম ছোট (Next Smaller) বার কোথায় আছে তার ওপর।
 * 
 * ১. একটি Monotonic Increasing Stack ব্যবহার করব (ছোট থেকে বড়)। 
 * ২. স্ট্যাকে ইনডেক্স রাখব।
 * ৩. যখনই কোনো বার স্ট্যাকের ওপরের বারের চেয়ে ছোট (Smaller) হবে, তার মানে 
 *    স্ট্যাকের ওপরের বারটি ডানদিকে আর ছড়াতে পারবে না!
 * ৪. তখন আমরা স্ট্যাক থেকে সেটি পপ (Pop) করে তার এরিয়া ক্যালকুলেট করব:
 *    - Height: পপ করা বারের উচ্চতা।
 *    - Width: বর্তমান ইনডেক্স `i` থেকে নতুন Stack Top এর ইনডেক্স বিয়োগ করে 1 বাদ দেব।
 * ৫. লুপ শেষে স্ট্যাকে কিছু বার থেকে গেলে তাদের জন্যও একই কাজ করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class Histogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // n পর্যন্ত লুপ চালাব (শেষের বারগুলো পপ করার জন্য i == n এ একটি ডামি ছোট বার চিন্তা করব)
        for (int i = 0; i <= n; i++) {
            
            // i == n হলে উচ্চতা 0 ধরব, যাতে স্ট্যাকের ভেতরের সব বার পপ হয়ে যায়
            int currentHeight = (i == n) ? 0 : heights[i];

            // যদি বর্তমান উচ্চতা স্ট্যাকের ওপরের উচ্চতার চেয়ে ছোট হয়
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                
                // পপ করে উচ্চতা নিলাম
                int h = heights[stack.pop()];
                
                // প্রস্থ বের করলাম
                // যদি স্ট্যাক খালি হয়, মানে এর বামে কোনো ছোট বার নেই (প্রস্থ i হবে)
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                
                // এরিয়া আপডেট
                maxArea = Math.max(maxArea, h * w);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Histogram solution = new Histogram();
        
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights)); 
        // Output: 10 (5 এবং 6 এর বার নিয়ে: উচ্চতা 5, প্রস্থ 2)
    }
}
