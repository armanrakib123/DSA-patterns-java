public class _4_FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];        
            fast = nums[nums[fast]]; 
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow]; 
            fast = nums[fast]; 
        }

        return slow; 
    }

    public static void main(String[] args) {
        _4_FindDuplicateNumber solution = new _4_FindDuplicateNumber();
        
        int[] nums = {1, 3, 4, 2, 2};
        
        int result = solution.findDuplicate(nums);
        System.out.println("Duplicate Number is: " + result); 
        // Expected Output: 2
    }
}















/**
 * 🎯 Problem 3: Find the Duplicate Number (LeetCode 287)
 * লেভেল: Medium (খুবই ট্রিকি এবং ফেমাস একটি প্রবলেম)
 * 
 * প্রশ্ন: আপনাকে n + 1 সাইজের একটি অ্যারে দেওয়া হবে, যেখানে ১ থেকে n পর্যন্ত সংখ্যাগুলো আছে।
 * অ্যারেতে ঠিক একটি সংখ্যা ডুপ্লিকেট (একাধিকবার আছে)।
 * আপনাকে সেই ডুপ্লিকেট সংখ্যাটি বের করতে হবে।
 * 
 * 🚨 শর্ত (Constraints):
 * ১. আপনি মূল অ্যারে মোডিফাই করতে পারবেন না (No Sorting)।
 * ২. আপনাকে O(1) এক্সট্রা স্পেসে এটি সলভ করতে হবে (No HashSet/HashMap)।
 * 
 * 💡 Brute Force:
 * ১. Sorting: Array সর্ট করে পাশাপাশি চেক করা। (শর্ত ভেঙে যায় কারণ সর্ট করলে অ্যারে মোডিফাই হয়, O(N log N) time)।
 * ২. HashSet: সেটে রেখে চেক করা যে আগে থেকে আছে কিনা। (শর্ত ভেঙে যায় কারণ O(N) space লাগে)।
 * 
 * 🚀 Optimal Approach (Fast & Slow Pointers / Floyd's Cycle Detection):
 * এটি মূলত লিংকড লিস্টের "Find the starting node of a cycle" (LeetCode 142) প্রবলেমটির একটি অ্যারে ভার্সন।
 * যেহেতু সংখ্যাগুলো ১ থেকে n এর মধ্যে এবং অ্যারে ইনডেক্সও ০ থেকে n পর্যন্ত, আমরা সংখ্যাগুলোকে পয়েন্টার (ইনডেক্স) হিসেবে ভাবতে পারি।
 * arr[i] নির্দেশ করে পরবর্তী ইনডেক্সটি। 
 * যেহেতু একটি সংখ্যা একাধিকবার আছে, তাই একাধিক ইনডেক্স একই ভ্যালুকে (পরবর্তী ইনডেক্সকে) পয়েন্ট করবে, যার ফলে একটি সাইকেল (Cycle) তৈরি হবে।
 * 
 * লজিক:
 * Phase 1: slow এবং fast পয়েন্টার চালিয়ে সাইকেলের মিটিং পয়েন্ট (Meeting point) বের করা।
 * Phase 2: মিটিং পয়েন্ট পাওয়ার পর, fast কে আগের জায়গায় রেখে, slow কে একদম শুরুতে (0 ইনডেক্সে) নিয়ে আসা। 
 * এরপর দুজনকেই ১ ঘর করে বাড়ানো। তারা যেখানে মিলিত হবে, সেটাই সাইকেলের শুরু অর্থাৎ ডুপ্লিকেট সংখ্যা!
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */