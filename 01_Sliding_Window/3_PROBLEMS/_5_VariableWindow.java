/**
 * Variable Size Sliding Window Example
 * LeetCode 3: Longest Substring Without Repeating Characters (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি String (s) দেওয়া আছে। আপনাকে এমন একটি সাব-স্ট্রিং (substring) খুঁজে বের করতে হবে, 
 * যা সবচেয়ে বড় এবং তার মধ্যে কোনো ক্যারেক্টার দুইবার (repeat) নেই। 
 * সাব-স্ট্রিংটির লেন্থ (length) রিটার্ন করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * ১. এখানে উইন্ডোর সাইজ ফিক্সড নয়। তাই আমরা একটি Variable Sliding Window ব্যবহার করব।
 * ২. `left` এবং `right` নামে দুটি পয়েন্টার রাখব।
 * ৩. ডুপ্লিকেট ক্যারেক্টার ট্র্যাক করার জন্য একটি `HashSet` ব্যবহার করব।
 * ৪. `right` পয়েন্টার দিয়ে আমরা সামনের দিকে এগোতে থাকব এবং ক্যারেক্টারগুলো সেটে যোগ করব।
 * ৫. যদি কোনো ক্যারেক্টার আগে থেকেই সেটে থাকে (অর্থাৎ ডুপ্লিকেট পাওয়া গেছে), 
 *    তখন আমরা `left` পয়েন্টার সামনের দিকে সরাতে থাকব এবং সেট থেকে ওই ইলিমেন্টগুলো মুছতে থাকব, 
 *    যতক্ষণ না ডুপ্লিকেট ক্যারেক্টারটি রিমুভ হচ্ছে।
 * ৬. প্রতি ধাপে আমরা ম্যাক্সিমাম লেন্থ আপডেট করব: `max(maxLength, right - left + 1)`.
 * 
 * Time Complexity: O(N) - কারণ প্রতিটি ক্যারেক্টার সর্বোচ্চ দুইবার ভিজিট হবে (একবার right দিয়ে, একবার left দিয়ে)।
 * Space Complexity: O(K) - যেখানে K হলো distinct characters এর সংখ্যা (সর্বোচ্চ 26, তাই O(1) ও বলা যায়)।
 */




import java.util.HashSet;

 public class _5_VariableWindow {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> windowSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (windowSet.contains(currentChar)) {
                windowSet.remove(s.charAt(left));
                left++;
            }

            windowSet.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        _5_VariableWindow solution = new _5_VariableWindow();
        String s = "abcabcdbb";
        
        System.out.println("Longest Substring Length: " + solution.lengthOfLongestSubstring(s));
        // Output হবে 4, কারণ "abcd" হলো longest substring without repeating characters.
    }
}
