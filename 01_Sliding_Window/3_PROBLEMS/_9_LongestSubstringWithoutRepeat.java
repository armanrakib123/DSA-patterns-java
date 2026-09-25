import java.util.*;

/**
 * LeetCode 3. Longest Substring Without Repeating Characters
 * Pattern: Sliding Window (Variable / Dynamic)
 * 
 * প্রবলেম: 
 * একটি String দেওয়া আছে। আপনাকে সবচেয়ে বড় (Longest) Substring এর length বের করতে হবে 
 * যেখানে কোনো ক্যারেক্টার দুইবার (Repeat) আসেনি।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি Variable Sliding Window এর প্রবলেম।
 * ১. আমরা `left` এবং `right` দুটি পয়েন্টার ব্যবহার করব।
 * ২. ক্যারেক্টারগুলো ট্র্যাকিং করার জন্য একটি `HashSet` (বা `boolean[]` বা `HashMap`) ব্যবহার করব।
 * ৩. `right` পয়েন্টার দিয়ে আমরা ক্যারেক্টার স্ক্যান করতে থাকব:
 *    - যদি ক্যারেক্টারটি সেটে না থাকে (Valid), তবে সেটে অ্যাড করব এবং `max_length` আপডেট করব।
 *    - যদি ক্যারেক্টারটি আগে থেকেই সেটে থাকে (Invalid), তার মানে Repeat হয়ে গেছে।
 *      তখন আমাদের উইন্ডোটি ছোট (Shrink) করতে হবে। আমরা `left` পয়েন্টারের ক্যারেক্টারগুলো 
 *      সেট থেকে রিমুভ করতে থাকব এবং `left++` করতে থাকব, যতক্ষণ না ডুপ্লিকেট ক্যারেক্টারটি রিমুভ হয়।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(K) বা O(1) (ইংরেজি অক্ষরের জন্য সর্বোচ্চ 128 বা 256 সাইজ, যা কনস্ট্যান্ট)
 */
public class _9_LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Set<Character> windowSet = new HashSet<>();
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // যদি current ক্যারেক্টারটি আগে থেকেই থাকে, তবে left পয়েন্টার সরাতে হবে
            while (windowSet.contains(currentChar)) {
                windowSet.remove(s.charAt(left));
                left++; // Shrinking the window
            }
            
            // এখন উইন্ডোটি Valid, তাই নতুন ক্যারেক্টারটি সেটে অ্যাড করো
            windowSet.add(currentChar);
            
            // ম্যাক্সিমাম লেংথ আপডেট করো
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
