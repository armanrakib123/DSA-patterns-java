/**
 * Pattern 1: Fixed Size Sliding Window
 * প্রবলেম: একটি Array তে K সাইজের উইন্ডোর ম্যাক্সিমাম যোগফল (Max Sum) বের করতে হবে।
 */


class _1_Template {

    public int fixed_Window_Template(int[] arr, int k) {
        if (arr == null || arr.length < k) return 0; 
        
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);

                windowSum -= arr[left];
                
                left++;
            }
        }
        
        return maxSum;
    }


    /**
     * Pattern 2: Variable Size Sliding Window (Longest/Maximum)
     * 
     * প্রবলেম: এমন একটি সাব-অ্যারের ম্যাক্সিমাম লেন্থ বের করুন যার যোগফল S এর সমান বা ছোট।
     */


    public int variable_Window_Longest_Template(int[] arr, int targetSum) {
        int windowSum = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            while (windowSum > targetSum) {
                windowSum -= arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }




    /**
     * Pattern 3: Variable Size Sliding Window (Shortest/Minimum)
     * 
     * প্রবলেম: এমন একটি সাব-অ্যারের মিনিমাম লেন্থ বের করুন যার যোগফল S এর সমান বা বড়।
     */


    public int variable_Window_Shortest_Template(int[] arr, int targetSum) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            while (windowSum >= targetSum) {
                minLength = Math.min(minLength, right - left + 1);
                
                windowSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
