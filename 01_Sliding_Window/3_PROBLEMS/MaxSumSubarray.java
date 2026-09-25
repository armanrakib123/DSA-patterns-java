public class MaxSumSubarray {

    public long maximumSumSubarray(int K, int[] arr) {
        if (arr == null || arr.length == 0 || K <= 0) return 0;
        
        long windowSum = 0;
        long maxSum = 0;
        
        // Step 1: প্রথম K সাইজের উইন্ডোর যোগফল বের করা
        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        
        // Step 2: উইন্ডো স্লাইড করা
        for (int i = K; i < arr.length; i++) {
            // নতুন এলিমেন্ট যোগ করা হচ্ছে এবং পুরোনো এলিমেন্ট বাদ দেওয়া হচ্ছে
            windowSum += arr[i] - arr[i - K];
            
            // ম্যাক্স আপডেট করা
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    public static void main(String[] args) {
        MaxSumSubarray solution = new MaxSumSubarray();
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int K1 = 2;
        System.out.println(solution.maximumSumSubarray(K1, arr1)); // Output: 9 (4 + 5)
        
        int[] arr2 = {2, 1, 5, 1, 3, 2};
        int K2 = 3;
        System.out.println(solution.maximumSumSubarray(K2, arr2)); // Output: 9 (5 + 1 + 3)
        
        int[] arr3 = {1, -2, 3, -1, 4};
        int K3 = 2;
        System.out.println(solution.maximumSumSubarray(K3, arr3)); // Output: 4 (3 + -1)
    }
}























/**
 * GeeksForGeeks / Common Problem: Max Sum Subarray of size K
 * Pattern: Sliding Window (Fixed)
 * 
 * প্রবলেম: 
 * একটি Array এবং একটি integer 'K' দেওয়া আছে। আপনাকে 'K' সাইজের এমন একটি 
 * Subarray খুঁজে বের করতে হবে যার যোগফল (Sum) সবচেয়ে বেশি (Maximum)।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * এটি একদম ক্লাসিক Fixed Sliding Window প্রবলেম।
 * ১. প্রথমে আমরা ০ থেকে K-1 পর্যন্ত ইনডেক্সের এলিমেন্টগুলো যোগ করে প্রথম উইন্ডোটি তৈরি করব।
 * ২. এরপর আমরা K ইনডেক্স থেকে লুপ চালানো শুরু করব।
 * ৩. প্রতি ধাপে, নতুন এলিমেন্টটি (arr[i]) উইন্ডোতে যোগ করব এবং একদম পেছনের এলিমেন্টটি (arr[i-K]) বাদ দেব।
 * ৪. ম্যাক্সিমাম যোগফল ট্র্যাক করতে থাকব।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */