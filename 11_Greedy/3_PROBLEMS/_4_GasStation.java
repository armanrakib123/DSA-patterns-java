public class _4_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasBalance = 0;
        int currentGasBalance = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int balance = gas[i] - cost[i];
            totalGasBalance += balance;
            currentGasBalance += balance;

            // যদি বর্তমান ট্যাংক খালি হয়ে যায়
            if (currentGasBalance < 0) {
                // তার মানে আগের কোনো স্টেশন থেকেই শুরু করা সম্ভব নয়
                startStation = i + 1; // পরের স্টেশন থেকে শুরু করো
                currentGasBalance = 0; // নতুন যাত্রার জন্য ট্যাংক খালি
            }
        }

        // যদি মোট গ্যাস মোট খরচের চেয়ে কম হয়
        return (totalGasBalance < 0) ? -1 : startStation;
    }

    public static void main(String[] args) {
        _4_GasStation solution = new _4_GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        
        System.out.println("Start station index: " + solution.canCompleteCircuit(gas, cost));
        // Expected: 3
    }
}























/**
 * 🎯 Problem 2: Gas Station (LeetCode 134)
 * লেভেল: Medium (Greedy Optimization)
 * 
 * প্রশ্ন: একটি গোল রাস্তায় `n` টি গ্যাস স্টেশন আছে। প্রতিটি স্টেশনে `gas[i]` পরিমাণ গ্যাস পাওয়া যায় 
 * এবং পরবর্তী স্টেশনে যেতে `cost[i]` পরিমাণ খরচ হয়। আপনি একটি খালি ট্যাংক নিয়ে যাত্রা শুরু করবেন। 
 * আপনাকে বের করতে হবে কোন স্টেশন থেকে শুরু করলে আপনি পুরো রাস্তা ঘুরে আবার আগের জায়গায় ফিরতে পারবেন। 
 * যদি সম্ভব না হয়, তবে -1 রিটার্ন করুন।
 * 
 * 💡 ইন্টুইশন:
 * ১. যদি মোট গ্যাসের পরিমাণ মোট খরচের চেয়ে কম হয় (`totalGas < totalCost`), তবে কোনোভাবেই যাত্রা সম্পন্ন করা সম্ভব নয়।
 * ২. গ্রীডি লজিক: আমরা যদি কোনো স্টেশন `i` থেকে শুরু করে `j` স্টেশনে গিয়ে আটকে যাই (ট্যাংক খালি হয়), 
 *    তার মানে `i` থেকে `j` এর মধ্যে কোনো স্টেশন থেকেই যাত্রা শুরু করা সম্ভব ছিল না। 
 *    তাই আমরা আমাদের পরবর্তী যাত্রা `j+1` থেকে শুরু করার চেষ্টা করব।
 * 
 * 🚀 সল্যুশন স্টেপস:
 * ১. `totalGas` এবং `currentGas` ট্র্যাক করুন।
 * ২. প্রতিটি স্টেশনের জন্য `gas[i] - cost[i]` বর্তমান ট্যাংকে যোগ করুন।
 * ৩. যদি `currentGas < 0` হয়:
 *    - বর্তমান স্টার্ট পয়েন্ট ইনভ্যালিড। 
 *    - স্টার্ট পয়েন্ট সেট করুন `i + 1` এবং `currentGas` রিসেট করুন 0 তে।
 * ৪. শেষে যদি `totalGas >= 0` হয়, তবে স্টার্ট পয়েন্টটি রিটার্ন করুন।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */