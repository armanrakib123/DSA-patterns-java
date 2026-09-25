import java.util.Arrays;

public class _3_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIdx = 0;
        int cookieIdx = 0;

        // ২. গ্রীডি ট্রাভার্সাল
        while (childIdx < g.length && cookieIdx < s.length) {
            // যদি কুকিটি বাচ্চার চাহিদা পূরণ করতে পারে
            if (s[cookieIdx] >= g[childIdx]) {
                childIdx++; // বাচ্চা খুশি!
            }
            // বাচ্চার চাহিদা পূরণ হোক বা না হোক, এই কুকিটি ব্যবহার করা শেষ (বা এটি ছোট)
            cookieIdx++;
        }

        return childIdx;
    }

    public static void main(String[] args) {
        _3_AssignCookies solution = new _3_AssignCookies();
        int[] g = {1, 2, 3}; // Greed levels
        int[] s = {1, 1};    // Cookie sizes
        
        System.out.println("Content children: " + solution.findContentChildren(g, s));
        // Expected: 1 (শুধু প্রথম বাচ্চা খুশি হবে)
    }
}























/**
 * 🎯 Problem 1: Assign Cookies (LeetCode 455)
 * লেভেল: Easy (Foundation of Greedy)
 * 
 * প্রশ্ন: আপনার কাছে কিছু বাচ্চা আছে এবং কিছু কুকি আছে। প্রতিটি বাচ্চার একটি `greed factor` (g[i]) আছে, 
 * যা হলো সর্বনিম্ন সাইজের কুকি যা পেলে সে খুশি হবে। প্রতিটি কুকির একটি সাইজ (s[j]) আছে। 
 * আপনাকে সর্বোচ্চ কতজন বাচ্চাকে খুশি করতে পারবেন তা বের করতে হবে।
 * 
 * 💡 ইন্টুইশন:
 * আমরা যদি সবচেয়ে কম greed ওয়ালা বাচ্চাকে সবচেয়ে ছোট (কিন্তু তার greed পূরণ করে এমন) কুকি দিই, 
 * তবে আমরা বাকি বড় কুকিগুলো বড় greed ওয়ালা বাচ্চাদের জন্য বাঁচাতে পারব। এটাই গ্রীডি লজিক।
 * 
 * 🚀 সল্যুশন স্টেপস:
 * ১. বাচ্চাদের greed অ্যারে (g) এবং কুকির সাইজ অ্যারে (s) সর্ট করুন।
 * ২. দুটি পয়েন্টার নিন: একটি বাচ্চার জন্য (i), অন্যটি কুকির জন্য (j)।
 * ৩. লুপ চালিয়ে দেখুন:
 *    - যদি কুকির সাইজ `s[j] >= g[i]` হয়: বাচ্চা খুশি! পরবর্তী বাচ্চার কাছে যান (i++) এবং পরের কুকির কাছে যান (j++)।
 *    - নতুবা: এই কুকিটি ছোট, তাই বড় কুকি খুঁজুন (j++)।
 * 
 * Time Complexity: O(N log N + M log M) (সর্টিংয়ের জন্য)
 * Space Complexity: O(1)
 */