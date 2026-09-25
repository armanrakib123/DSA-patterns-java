public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        
        // s1 এর ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি বের করো
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }
        
        int left = 0;
        
        // s2 এর ওপর Sliding Window চালাও
        for (int right = 0; right < s2.length(); right++) {
            // নতুন ক্যারেক্টার অ্যাড করো
            char cRight = s2.charAt(right);
            s2Map[cRight - 'a']++;
            
            // উইন্ডো সাইজ s1 এর সাইজের সমান হলে চেক করো
            if (right - left + 1 == s1.length()) {
                if (matches(s1Map, s2Map)) {
                    return true;
                }
                
                // উইন্ডো স্লাইড করার জন্য বামের ক্যারেক্টার রিমুভ করো
                char cLeft = s2.charAt(left);
                s2Map[cLeft - 'a']--;
                left++;
            }
        }
        
        return false;
    }
    
    // দুটি ফ্রিকোয়েন্সি অ্যারে সমান কিনা তা চেক করার Helper method
    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        
        String s1_1 = "ab";
        String s2_1 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1_1, s2_1)); // Output: true (because "ba" is a permutation of "ab")
        
        String s1_2 = "abc";
        String s2_2 = "eidboaoo";
        System.out.println(solution.checkInclusion(s1_2, s2_2)); // Output: false
    }
}

























/**
 * LeetCode 567. Permutation in String
 * Pattern: Sliding Window (Fixed) + Hash Map/Array
 * 
 * প্রবলেম: 
 * দুটি String 's1' এবং 's2' দেওয়া আছে। আপনাকে বলতে হবে 's2' এর ভেতরে 's1' এর কোনো 
 * Permutation (বিন্যাস) সাবস্ট্রিং হিসেবে আছে কিনা। 
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * একটি স্ট্রিং এর Permutation মানে হলো ক্যারেক্টারগুলো একই থাকবে, শুধু তাদের পজিশন ভিন্ন হতে পারে।
 * অর্থাৎ, যদি 's1' এবং 's2' এর কোনো সাবস্ট্রিং এর Character Frequency (ক্যারেক্টার কাউন্ট) হুবহু মিলে যায়, 
 * তবে তারা একে অপরের Permutation।
 * 
 * যেহেতু আমরা 's1' এর Permutation খুঁজছি, তাই আমাদের উইন্ডোর সাইজ ফিক্সড (Fixed Window) হবে, 
 * যা 's1' এর Length এর সমান!
 * 
 * লজিক:
 * ১. প্রথমে 's1' এর ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি একটি অ্যারেতে (`s1Map`) সেভ করব।
 * ২. এরপর 's2' এর ওপর `s1.length()` সাইজের একটি Fixed Sliding Window চালাব।
 * ৩. উইন্ডোটিকে ডানদিকে স্লাইড করার সময়:
 *    - নতুন ক্যারেক্টারটি উইন্ডোর ম্যাপে (`s2Map`) অ্যাড করব।
 *    - উইন্ডোর সাইজ যদি `s1` এর সাইজের সমান হয়ে যায়, তখন চেক করব `s1Map` এবং `s2Map` সমান কিনা।
 *    - সমান হলে `true` রিটার্ন করব।
 *    - সমান না হলে উইন্ডোটিকে এক ঘর ডানে সরাতে হবে, তাই পেছনের (left) ক্যারেক্টারটি রিমুভ করব।
 * 
 * Time Complexity: O(N) (যেখানে N হলো s2 এর লেংথ)
 * Space Complexity: O(1) (26 সাইজের অ্যারে ব্যবহার করা হয়েছে)
 */