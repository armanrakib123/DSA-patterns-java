public class _2_FixedWindowTemplate {

    public int solveFixedWindow(int[] arr, int K) {
        if (arr == null || arr.length == 0 || K <= 0 || K > arr.length) {
            return 0; 
        }

        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }
        
        maxSum = windowSum;

        for (int i = K; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - K];
            
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        _2_FixedWindowTemplate solution = new _2_FixedWindowTemplate();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int K = 3;
        int result = solution.solveFixedWindow(arr, K);
        System.out.println("Maximum sum of subarray of size " + K + " is: " + result);
        
        // Output: Maximum sum of subarray of size 3 is: 15
    }
}




















/**
 * ==========================================
 * SLIDING WINDOW PATTERN (FIXED SIZE)
 * ==========================================
 * 
 * কখন ব্যবহার করবেন: 
 * যখন আপনাকে একটি Array বা String দেওয়া হবে এবং ঠিক 'K' সাইজের 
 * একটি Subarray বা Substring নিয়ে কিছু বের করতে বলা হবে 
 * (যেমন: Max sum of subarray of size K)।
 * 
 * লজিক:
 * ১. প্রথমে 0 থেকে K-1 পর্যন্ত এলিমেন্টগুলো নিয়ে প্রথম উইন্ডো তৈরি করুন।
 * ২. এরপর উইন্ডোটিকে এক ঘর করে ডান দিকে সরাতে থাকুন (index K থেকে শেষ পর্যন্ত)।
 * ৩. প্রতি ধাপে নতুন এলিমেন্ট অ্যাড করুন এবং উইন্ডোর বাইরের (পুরনো) এলিমেন্টটি বাদ দিন।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */