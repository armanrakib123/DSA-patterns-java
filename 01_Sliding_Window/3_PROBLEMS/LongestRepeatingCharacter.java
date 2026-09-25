public class LongestRepeatingCharacter {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // নতুন ক্যারেক্টারের কাউন্ট বাড়াও
            char cRight = s.charAt(right);
            count[cRight - 'A']++;
            
            // উইন্ডোর সবচেয়ে বেশি থাকা ক্যারেক্টারের সংখ্যা আপডেট করো
            maxFreq = Math.max(maxFreq, count[cRight - 'A']);
            
            // উইন্ডোটি কি Invalid? (বাকি ক্যারেক্টারগুলো রিপ্লেস করতে K এর বেশি অপারেশন লাগবে?)
            int windowLength = right - left + 1;
            if (windowLength - maxFreq > k) {
                // Invalid, তাই উইন্ডো Shrink করতে হবে
                char cLeft = s.charAt(left);
                count[cLeft - 'A']--;
                left++;
            }
            
            // (এখানে windowLength আবার ক্যালকুলেট করার দরকার নেই কারণ if block এ ঢুকলে left এবং right দুটিই ১ করে বাড়ে, তাই size সেইম থাকে)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        LongestRepeatingCharacter solution = new LongestRepeatingCharacter();
        
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(solution.characterReplacement(s1, k1)); // Output: 4
        
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(solution.characterReplacement(s2, k2)); // Output: 4
    }
}


























/**
 * LeetCode 424. Longest Repeating Character Replacement
 * Pattern: Sliding Window (Variable / Max Frequency)
 * 
 * প্রবলেম: 
 * একটি String দেওয়া আছে (শুধুমাত্র বড় হাতের ইংরেজি অক্ষর)। 
 * আপনি সর্বোচ্চ 'K' সংখ্যক ক্যারেক্টার পরিবর্তন (Replace) করতে পারবেন। 
 * ক্যারেক্টার পরিবর্তন করার পর একই ক্যারেক্টার দিয়ে তৈরি সবচেয়ে লম্বা সাবস্ট্রিং এর length কত হবে?
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * একটি উইন্ডো কখন ভ্যালিড থাকে? 
 * উইন্ডোর মোট length থেকে যদি উইন্ডোর সবচেয়ে বেশি থাকা ক্যারেক্টারের সংখ্যা (maxFreq) বাদ দিই, 
 * তবে যে কয়টি ক্যারেক্টার বাকি থাকে (যেগুলো আলাদা), সেগুলোকেই আমাদের Replace করতে হবে।
 * অর্থাৎ, (Window Length - maxFreq) হলো সেই ক্যারেক্টারগুলোর সংখ্যা যাদের রিপ্লেস করতে হবে।
 * যদি এই সংখ্যাটি K এর সমান বা ছোট হয়, তবে উইন্ডোটি ভ্যালিড।
 * শর্ত: `(right - left + 1) - maxFreq <= K`
 * 
 * লজিক:
 * ১. `right` পয়েন্টার দিয়ে ক্যারেক্টার কাউন্ট বাড়াব এবং `maxFreq` ট্র্যাক করব।
 * ২. যদি উইন্ডোটি ইনভ্যালিড হয়ে যায় (`Window Length - maxFreq > K`), 
 *    তবে `left` পয়েন্টার এক ঘর সরিয়ে দেব। (এখানে while এর বদলে if ব্যবহার করলেই হয়, কারণ আমরা শুধু max length খুঁজছি)।
 * ৩. উইন্ডো ভ্যালিড থাকা অবস্থায় `maxLength` আপডেট করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */