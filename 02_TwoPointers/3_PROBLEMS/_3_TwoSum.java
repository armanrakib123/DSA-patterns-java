
public class _3_TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        _3_TwoSum solution = new _3_TwoSum();

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}











/**
 * 🎯 Problem 1: Two Sum II - Input Array Is Sorted (LeetCode 167)
 * লেভেল: Easy / Medium
 * 
 * প্রশ্ন: আপনাকে একটি 1-indexed (১ থেকে ইনডেক্স শুরু) অ্যারে দেওয়া হবে যা ক্রমবর্ধমান (Ascending order) ভাবে সাজানো আছে।
 * আপনাকে এমন দুটি সংখ্যার ইনডেক্স বের করতে হবে যাদের যোগফল একটি নির্দিষ্ট টার্গেটের (target) সমান হয়।
 * 
 * 💡 Brute Force Approach:
 * দুটি নেস্টেড লูป ব্যবহার করে সব জোড়া (Pairs) চেক করা।
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * (এটি Software Company ইন্টারভিউতে রিজেক্টেড হবে)
 * 
 * 🚀 Optimal Approach (Two Pointers):
 * যেহেতু অ্যারেটি সাজানো (Sorted) আছে, আমরা দুটি পয়েন্টার নেব।
 * একটি অ্যারের শুরুতে (left) এবং অন্যটি অ্যারের শেষে (right)।
 * 
 * লজিক:
 * ১. যদি arr[left] + arr[right] == target হয়, তবে আমরা উত্তর পেয়ে গেছি।
 * ২. যদি arr[left] + arr[right] < target হয়, এর মানে আমাদের যোগফল বাড়াতে হবে। 
 *    যেহেতু অ্যারেটি সর্টেড, তাই left পয়েন্টার এক ঘর ডানে নিলে বড় সংখ্যা পাব। (left++)
 * ৩. যদি arr[left] + arr[right] > target হয়, এর মানে আমাদের যোগফল কমাতে হবে।
 *    তাই right পয়েন্টার এক ঘর বামে নিলে ছোট সংখ্যা পাব। (right--)
 * 
 * Time Complexity: O(N) (লুপটি সর্বোচ্চ একবারই পুরো অ্যারে ভিজিট করবে)
 * Space Complexity: O(1) (কোনো এক্সট্রা মেমোরি নেওয়া হয়নি)
 */
