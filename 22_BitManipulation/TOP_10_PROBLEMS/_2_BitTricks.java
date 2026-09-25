// package _22_BitManipulation;

/**
 * Essential Bit Tricks
 * LeetCode 136: Single Number (Easy)
 * LeetCode 191: Number of 1 Bits (Easy)
 */
public class _2_BitTricks {

    /**
     * Trick 1: Single Number (LC 136)
     * একটি Array তে সব সংখ্যা দুবার করে আছে, শুধু একটি বাদে। সেটি বের করতে হবে।
     * 
     * এপ্রোচ: XOR ম্যাজিক!
     * আমরা জানি a ^ a = 0 এবং 0 ^ b = b.
     * তাই সবগুলোকে XOR করলে জোড়াগুলো 0 হয়ে যাবে, আর সিঙ্গেলটা বেঁচে থাকবে!
     * Time: O(N), Space: O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR অপারেশন
        }
        return result;
    }

    /**
     * Trick 2: Number of 1 Bits / Hamming Weight (LC 191)
     * একটি সংখ্যার বাইনারি ফরমেটে কতগুলো '1' আছে তা কাউন্ট করতে হবে।
     * 
     * এপ্রোচ: n & (n - 1)
     * এই অপারেশনটি প্রতিবার সবচেয়ে ডানদিকের '1' কে '0' বানিয়ে দেয়। 
     * যতক্ষণ সংখ্যাটি 0 না হচ্ছে, আমরা এই অপারেশন চালাব।
     * Time: O(1 এর সংখ্যা), যা O(32) বা O(1) এর সমান।
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // ডানদিকের 1 কে 0 করা
            count++;
        }
        return count;
    }

    /**
     * Trick 3: Power of Two (LC 231)
     * চেক করতে হবে সংখ্যাটি 2 এর পাওয়ার কি না (যেমন: 1, 2, 4, 8, 16...)
     * 
     * এপ্রোচ: 
     * 2 এর পাওয়ারগুলোর বাইনারিতে শুধুমাত্র একটি '1' থাকে! (যেমন: 4 = 100, 8 = 1000)
     * তাই n & (n - 1) করলে যদি 0 হয়, তবে এটি Power of 2.
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        _2_BitTricks solution = new _2_BitTricks();
        
        System.out.println("Single Number: " + solution.singleNumber(new int[]{4, 1, 2, 1, 2})); // Output: 4
        
        System.out.println("Number of 1 Bits in 11 (1011): " + solution.hammingWeight(11)); // Output: 3
        
        System.out.println("Is 16 Power of Two?: " + solution.isPowerOfTwo(16)); // Output: true
    }
}
