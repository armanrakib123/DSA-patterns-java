import java.util.*;

public class FruitsIntoBaskets {

    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxFruits = 0;
        Map<Integer, Integer> basket = new HashMap<>(); // <FruitType, Count>
        
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            
            // ফলটি ঝুড়িতে রাখো
            basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);
            
            // যদি ২ ধরনের বেশি ফল হয়ে যায়, তবে উইন্ডো Shrink করো
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                
                // যদি কোনো ফলের সংখ্যা 0 হয়ে যায়, তবে সেটি ঝুড়ি থেকে ফেলে দাও
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                
                left++; // Shrinking
            }
            
            // উইন্ডো ভ্যালিড, রেজাল্ট আপডেট করো
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
    public static void main(String[] args) {
        FruitsIntoBaskets solution = new FruitsIntoBaskets();
        
        int[] fruits1 = {1, 2, 1};
        System.out.println(solution.totalFruit(fruits1)); // Output: 3
        
        int[] fruits2 = {0, 1, 2, 2};
        System.out.println(solution.totalFruit(fruits2)); // Output: 3
        
        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println(solution.totalFruit(fruits3)); // Output: 4
    }
}



















/**
 * LeetCode 904. Fruit Into Baskets
 * Pattern: Sliding Window (Variable / Growing-Shrinking)
 * 
 * প্রবলেম: 
 * আপনার কাছে একটি Array আছে যা বিভিন্ন ধরণের ফলের গাছ রিপ্রেজেন্ট করে। 
 * আপনার কাছে মাত্র দুটি ঝুড়ি (Baskets) আছে এবং প্রতিটি ঝুড়িতে শুধুমাত্র এক প্রকারের ফলই রাখা যায়। 
 * আপনি পর পর গাছ থেকে ফল পাড়তে পারবেন, কিন্তু যদি এমন কোনো গাছে পৌঁছান যার ফলের টাইপ আপনার 
 * কোনো ঝুড়ির সাথেই মেলে না এবং আপনার ঝুড়ি দুটিও ফুল, তখন আপনাকে থামা লাগবে।
 * প্রশ্ন হলো: আপনি সর্বোচ্চ কয়টি ফল সংগ্রহ করতে পারবেন?
 * 
 * প্রবলেমের আসল অর্থ (Translation):
 * "Find the length of the longest subarray with at most 2 distinct elements."
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি ক্লাসিক Variable Sliding Window প্রবলেম।
 * ১. আমরা একটি HashMap ব্যবহার করে উইন্ডোর ভেতরের ফলের টাইপ এবং ফ্রিকোয়েন্সি ট্র্যাক করব।
 * ২. `right` পয়েন্টার দিয়ে ফল অ্যাড করতে থাকব। 
 * ৩. যদি HashMap এর সাইজ (ইউনিক ফলের প্রকার) 2 এর বেশি হয়ে যায়, তবে আমাদের উইন্ডোটি Invalid হয়ে গেছে।
 * ৪. তখন আমরা `left` পয়েন্টার বাড়িয়ে ফল বাদ দিতে থাকব যতক্ষণ না HashMap এর সাইজ আবার 2 (বা তার কম) হয়।
 * ৫. প্রতি ভ্যালিড স্টেপে আমরা ম্যাক্সিমাম ফল (উইন্ডোর সাইজ) আপডেট করব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) (HashMap এ সর্বোচ্চ ৩টি এলিমেন্ট থাকবে)
 */