package Software

Company_DSA_PATTERNS_MASTER.07_BINARY_SEARCH_ON_ANSWER;

/**
 * 🎯 Problem 2: Capacity To Ship Packages Within D Days (LeetCode 1011)
 * লেভেল: Medium
 * 
 * প্রশ্ন: একটি পরিবাহক বেল্টে (conveyor belt) কিছু প্যাকেজ আছে, যেগুলোর ওজন `weights` অ্যারেতে দেওয়া আছে।
 * প্যাকেজগুলো অবশ্যই অ্যারেতে দেওয়া সিরিয়াল অনুযায়ী جہাজে তুলতে হবে (আপনি চাইলে সিরিয়াল ভাঙতে পারবেন না)।
 * আপনাকে একটি জাহাজের ন্যূনতম ওজন ধারণক্ষমতা (Capacity) বের করতে হবে, যাতে `days` দিনের মধ্যে সব প্যাকেজ শিপ করা যায়।
 * 
 * 💡 Intuition (Search Space):
 * ক্যাপাসিটির সর্বনিম্ন মান কত হতে পারে? 
 * - জাহাজের ক্যাপাসিটি অবশ্যই সবচেয়ে ভারী প্যাকেজটির সমান বা বড় হতে হবে, নাহলে ওই প্যাকেজটি কখনোই জাহাজে তোলা যাবে না! (left = max(weights))
 * ক্যাপাসিটির সর্বোচ্চ মান কত হতে পারে?
 * - যদি ১ দিনেই সব প্যাকেজ নিয়ে যেতে হয়, তবে ক্যাপাসিটি হবে সব প্যাকেজের ওজনের যোগফল! (right = sum(weights))
 * 
 * আমাদের উত্তরের রেঞ্জ হলো: `[max(weights), sum(weights)]`
 * এই রেঞ্জের মধ্যে আমরা বাইনারি সার্চ চালাব।
 * 
 * 🚀 Optimal Approach:
 * ১. `left` এবং `right` বের করব।
 * ২. `mid` ক্যাপাসিটি ধরে একটি হেল্পার ফাংশন `canShip(mid)` দিয়ে চেক করব।
 * ৩. যদি শিপ করা যায়, তবে আরও ছোট ক্যাপাসিটি খুঁজব (`right = mid - 1`)।
 * 
 * Time Complexity: O(N * log(Sum - Max))
 * Space Complexity: O(1)
 */

public class CapacityToShipPackages {

    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;

        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int left = maxWeight;
        int right = totalWeight;
        int minCapacity = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, mid, days)) {
                minCapacity = mid; // সম্ভাব্য উত্তর
                right = mid - 1;   // আরও ছোট ক্যাপাসিটির খোঁজে
            } else {
                left = mid + 1;    // ক্যাপাসিটি খুব কম, বাড়াতে হবে
            }
        }

        return minCapacity;
    }

    private boolean canShip(int[] weights, int capacity, int targetDays) {
        int daysNeeded = 1;
        int currentWeightOnShip = 0;

        for (int weight : weights) {
            // যদি বর্তমান প্যাকেজটি যোগ করলে জাহাজের ক্যাপাসিটি ওভারফ্লো করে
            if (currentWeightOnShip + weight > capacity) {
                daysNeeded++; // পরের দিনের জন্য অপেক্ষা করো
                currentWeightOnShip = weight; // নতুন দিনে শুধু এই প্যাকেজটি তোলা হলো
            } else {
                currentWeightOnShip += weight; // একই দিনে প্যাকেজটি তোলা হলো
            }
        }

        return daysNeeded <= targetDays;
    }

    public static void main(String[] args) {
        CapacityToShipPackages solution = new CapacityToShipPackages();

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println("Minimum Ship Capacity: " + solution.shipWithinDays(weights, days));
        // Expected Output: 15
    }
}
