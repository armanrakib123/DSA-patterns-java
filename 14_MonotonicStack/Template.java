package _14_MonotonicStack;

import java.util.Stack;

/**
 * Monotonic Stack Generic Templates
 * 
 * এই টেমপ্লেটগুলো মনে রাখলে Next Greater বা Next Smaller এর 
 * যেকোনো প্রবলেম এক পলকে সলভ করা সম্ভব।
 */
public class Template {

    /**
     * Pattern 1: Next Greater Element (Monotonic Decreasing Stack)
     * 
     * একটি Array এর প্রতিটি ইলিমেন্টের জন্য ডানদিকের (Right) প্রথম বড় সংখ্যা বের করা।
     * যদি না থাকে, তবে -1 বসানো।
     */
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // স্ট্যাকে ইনডেক্স রাখব

        for (int i = 0; i < n; i++) {
            // যতক্ষণ স্ট্যাক খালি নয় এবং বর্তমান ইলিমেন্ট স্ট্যাকের ওপরের ইলিমেন্টের চেয়ে বড়
            // তার মানে স্ট্যাকের ওপরের ইলিমেন্টটি তার 'Next Greater' পেয়ে গেছে!
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i]; // উত্তর সেভ করলাম
            }
            
            // বর্তমান ইনডেক্স স্ট্যাকে পুশ করলাম
            stack.push(i);
        }

        // লুপ শেষে স্ট্যাকে যেসব ইনডেক্স থেকে যাবে, তাদের কোনো Next Greater নেই
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }

    /**
     * Pattern 2: Next Smaller Element (Monotonic Increasing Stack)
     * 
     * একটি Array এর প্রতিটি ইলিমেন্টের জন্য ডানদিকের প্রথম ছোট সংখ্যা বের করা।
     */
    public int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < n; i++) {
            // শুধু > সাইনটি < হয়ে যাবে!
            // বর্তমান ইলিমেন্ট যদি স্ট্যাকের ওপরের ইলিমেন্টের চেয়ে ছোট হয়
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i]; // Next Smaller পেয়ে গেছি
            }
            
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }
}
