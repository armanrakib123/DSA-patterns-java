import java.util.HashSet;
import java.util.Set;

public class _8_LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        
        Set<Character> windowSet = new HashSet<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (!windowSet.contains(rightChar)) {
                windowSet.add(rightChar);
                maxLen = Math.max(maxLen, right - left + 1); 
                right++; 
            } 
            else {
                char leftChar = s.charAt(left);
                windowSet.remove(leftChar);
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        _8_LongestSubstringWithoutRepeating solution = new _8_LongestSubstringWithoutRepeating();
        
        String s = "abcabcbb";
        
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("Longest Substring Length: " + result); 
        // Expected Output: 3 (সাবস্ট্রিং "abc")
    }
}