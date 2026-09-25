public class _10_ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);

            if (!Character.isLetterOrDigit(charLeft)) {
                left++;
            }
            else if (!Character.isLetterOrDigit(charRight)) {
                right--;
            }
            else {
                if (Character.toLowerCase(charLeft) != Character.toLowerCase(charRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        _10_ValidPalindrome solution = new _10_ValidPalindrome();
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s1)); // Output: true

        String s2 = "race a car";
        System.out.println(solution.isPalindrome(s2)); // Output: false
    }
}






















/**
 * LeetCode 125. Valid Palindrome
 * Pattern: Two Pointer (Opposite Direction)
 * 
 * প্রবলেম: 
 * একটি String দেওয়া আছে। আপনাকে বলতে হবে এটি প্যালিনড্রোম কিনা। 
 * প্যালিনড্রোম মানে হলো এদিক ওদিক দুদিক থেকেই পড়লে একই মনে হয় (যেমন: "racecar")।
 * তবে শর্ত হলো: শুধুমাত্র Alphanumeric ক্যারেক্টার (a-z, A-Z, 0-9) কনসিডার করতে হবে 
 * এবং case-insensitive (ছোট হাতের, বড় হাতের অক্ষর একই ধরা হবে) হতে হবে।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * ১. আমরা String এর শুরু থেকে (left) এবং শেষ থেকে (right) দুটি পয়েন্টার নেব।
 * ২. যদি current ক্যারেক্টার alphanumeric না হয়, তবে আমরা সেটি স্কিপ করব (পয়েন্টার এক ঘর এগিয়ে নেব)।
 * ৩. এরপর আমরা left এবং right ক্যারেক্টার দুটিকে lowercase করে চেক করব তারা সমান কিনা।
 * ৪. যদি কোনো এক পর্যায়ে সমান না হয়, তবে এটি প্যালিনড্রোম নয় (return false)।
 * ৫. পুরো লুপ শেষ হয়ে গেলে তার মানে এটি প্যালিনড্রোম (return true)।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */