import java.util.HashMap;
import java.util.Map;

/**
 * 🎯 Problem 3: Minimum Window Substring (LeetCode 76)
 * লেভেল: Hard (FAANG's Most Asked Sliding Window Problem)
 * 
 * প্রশ্ন: দুটি স্ট্রিং `s` এবং `t` দেওয়া আছে। আপনাকে `s` এর মধ্যে সবচেয়ে ছোট সাবস্ট্রিং 
 * (Minimum window substring) বের করতে হবে, যার মধ্যে `t` এর সমস্ত অক্ষর (ডুপ্লিকেটসহ) উপস্থিত থাকে।
 * 
 * 💡 Intuition:
 * ১. প্রথমে `t` এর ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি (Frequency) গুনে রাখব।
 * ২. একটি উইন্ডো (left, right) নিয়ে স্ট্রিং `s` ট্রাভার্স করব।
 * ৩. উইন্ডোর ভেতরে `t` এর ক্যারেক্টারগুলো পেলে গুনে রাখব (matched count)।
 * ৪. যখন আমাদের উইন্ডোতে `t` এর সবগুলো ক্যারেক্টার পেয়ে যাব, তখন উইন্ডোটি "ভ্যালিড"।
 * ৫. উইন্ডো ভ্যালিড হওয়ার পর, আমরা চেষ্টা করব বাম দিক থেকে (left পয়েন্টার) ক্যারেক্টার বাদ দিয়ে 
 *    উইন্ডোটিকে যতটা সম্ভব ছোট (Shrink) করতে, যতক্ষণ না সেটি ইনভ্যালিড হয়ে যায়।
 * 
 * Time Complexity: O(N + M) (যেখানে N হলো s এর দৈর্ঘ্য এবং M হলো t এর দৈর্ঘ্য)
 * Space Complexity: O(1) (কারণ ইংলিশ লেটার মাত্র ২৬ বা ৫২টি, তাই হ্যাশম্যাপের সাইজ কনস্ট্যান্ট)
 */

public class _7_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // t এর ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি ম্যাপ তৈরি
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int matched = 0; // কতগুলো ক্যারেক্টার মিলেছে তার হিসাব
        int minLen = Integer.MAX_VALUE;
        int minStart = 0; // সবচেয়ে ছোট উইন্ডোর শুরুর ইনডেক্স

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // যদি ক্যারেক্টারটি targetMap এ থাকে এবং এর ফ্রিকোয়েন্সিও মিলে যায়
            if (targetMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() == targetMap.get(rightChar).intValue()) {
                matched++;
            }

            // যখন উইন্ডোটি ভ্যালিড (সব ক্যারেক্টার মিলে গেছে)
            while (matched == targetMap.size()) {
                // সবচেয়ে ছোট উইন্ডো আপডেট করা
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // বাম দিক থেকে ক্যারেক্টার রিমুভ করে উইন্ডো ছোট (Shrink) করার চেষ্টা
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // রিমুভ করার পর যদি ভ্যালিডিটি নষ্ট হয়ে যায়, তবে matched কমিয়ে দাও
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    matched--;
                }

                left++; // উইন্ডো শ্রিঙ্ক
            }
            
            right++; // উইন্ডো ডানে বাড়াও
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        _7_MinimumWindowSubstring solution = new _7_MinimumWindowSubstring();
        
        String s = "ADOBECODEBANC";
        String t = "ABC";
        
        String result = solution.minWindow(s, t);
        System.out.println("Minimum Window Substring: " + result); 
        // Expected Output: "BANC"
    }
}
