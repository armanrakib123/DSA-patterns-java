
/**
 * LeetCode 76. Minimum Window Substring (Hard)
 * Pattern: Sliding Window (Shrinking / Variable)
 *
 * প্রবলেম:
 * দুটি String, 's' এবং 't' দেওয়া আছে। আপনাকে 's' এর মধ্যে সবচেয়ে ছোট (Minimum)
 * এমন একটি Substring খুঁজে বের করতে হবে যার ভেতরে 't' এর সবগুলো ক্যারেক্টার (Frequency সহ) থাকে।
 *
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি Software Company এর সবচেয়ে জনপ্রিয় Hard প্রবলেমগুলোর একটি।
 * ১. প্রথমে 't' এর সবগুলো ক্যারেক্টারের Frequency একটি Map বা Array (targetMap) তে সেভ করে নেব।
 * ২. আমাদের আরেকটি ভেরিয়েবল লাগবে `requiredMatchCount`, যা বলবে 't' এর মোট কয়টি ইউনিক ক্যারেক্টার মেলাতে হবে।
 * ৩. `left` এবং `right` পয়েন্টার দিয়ে 's' স্ক্যান শুরু করব।
 * ৪. যখন `right` দিয়ে কোনো ক্যারেক্টার পাব, সেটি উইন্ডোতে অ্যাড করব। যদি সেটি `targetMap` এর সাথে
 *    ম্যাচ করে যায়, তবে আমাদের `matchCount++` হবে।
 * ৫. যখন `matchCount == requiredMatchCount` হবে, তার মানে আমাদের বর্তমান উইন্ডোতে 't' এর সব কিছু আছে (Valid Window)!
 * ৬. এবার উইন্ডোটিকে Shrink (ছোট) করার পালা। আমরা `left` বাড়িয়ে উইন্ডো ছোট করতে থাকব এবং রেজাল্ট
 *    (minimum length) আপডেট করতে থাকব, যতক্ষণ না উইন্ডোটি Invalid হয়ে যাচ্ছে।
 * ৭. এই প্রসেসটি পুরো 's' স্ক্যান হওয়া পর্যন্ত চলবে।
 *
 * Time Complexity: O(S + T) (যেখানে S এবং T হলো স্ট্রিং দুটির সাইজ)
 * Space Complexity: O(1) (ASCII character array size is fixed, 128)
 */
public class _11_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // 't' এর ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি ম্যাপ
        int[] targetMap = new int[128];
        int requiredMatches = 0; // কয়টি ইউনিক ক্যারেক্টার মেলাতে হবে

        for (char c : t.toCharArray()) {
            if (targetMap[c] == 0) {
                requiredMatches++;
            }
            targetMap[c]++;
        }

        int[] windowMap = new int[128];
        int currentMatches = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0; // রেজাল্ট সাবস্ট্রিং এর শুরুর ইনডেক্স

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap[c]++;

            // যদি বর্তমান ক্যারেক্টারটি target এর কোনো ক্যারেক্টার হয় এবং তার ফ্রিকোয়েন্সি ম্যাচ করে
            if (targetMap[c] > 0 && windowMap[c] == targetMap[c]) {
                currentMatches++;
            }

            // উইন্ডোটি Valid (অর্থাৎ t এর সব ক্যারেক্টার উইন্ডোর ভেতর আছে)
            while (currentMatches == requiredMatches) {

                // রেজাল্ট আপডেট করো (আমরা যেহেতু Minimum খুঁজছি)
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // এবার left পয়েন্টার ডান দিকে সরিয়ে উইন্ডো Shrink করার চেষ্টা করি
                char leftChar = s.charAt(left);
                windowMap[leftChar]--;

                // যদি leftChar রিমুভ করার ফলে আমাদের উইন্ডো Invalid হয়ে যায়
                if (targetMap[leftChar] > 0 && windowMap[leftChar] < targetMap[leftChar]) {
                    currentMatches--;
                }

                left++; // Shrink
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
