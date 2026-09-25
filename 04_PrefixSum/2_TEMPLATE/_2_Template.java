/**
 * Pattern 1: Building Prefix Sum Array and Range Query
 * একটি Array থেকে Prefix Sum তৈরি করে Range Query এর উত্তর দেওয়া।
 */


import java.util.HashMap;

class _2_Template {

    public int[] buildPrefixSum(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        
        int n = arr.length;
        int[] prefixSum = new int[n + 1]; 
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        return prefixSum;
    }

    public int getRangeSum(int[] prefixSum, int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }



/**
 * Pattern 2: Prefix Sum with HashMap 
 * প্রবলেম: একটি Array তে কতগুলো সাব-অ্যারে আছে যাদের যোগফল k এর সমান?
 * এটি LC 560 (Subarray Sum Equals K) এর টেমপ্লেট।
 */




    public int subarraySumTemplate(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1); 
        
        int currentPrefixSum = 0;
        int count = 0;

        for (int num : arr) {
            currentPrefixSum += num; 

            int targetPrefix = currentPrefixSum - k;
            
            if (map.containsKey(targetPrefix)) {
                count += map.get(targetPrefix);
            }

            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }
}