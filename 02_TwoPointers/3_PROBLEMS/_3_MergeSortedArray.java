public class _3_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = m - 1;     
        int p2 = n - 1;
        int p = m + n - 1;   
        
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1]; 
                p1--;      
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }
    public static void main(String[] args) {
        _3_MergeSortedArray solution = new _3_MergeSortedArray();
        
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        
        solution.merge(nums1, m, nums2, n);
        
        // Output: [1, 2, 2, 3, 5, 6]
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}


















/**
 * LeetCode 88. Merge Sorted Array
 * Pattern: Two Pointer (Backwards / Reverse Direction)
 * 
 * প্রবলেম: 
 * দুটি Sorted Array (nums1 এবং nums2) দেওয়া আছে। nums1 এর সাইজ m+n, যেখানে প্রথম m টি এলিমেন্ট ভ্যালিড 
 * এবং শেষের n টি এলিমেন্ট 0 (ফাঁকা জায়গা)। 
 * আপনাকে nums2 কে nums1 এর সাথে Merge করে একটি সিঙ্গেল Sorted Array বানাতে হবে In-place (nums1 এর ভেতরেই)।
 * 
 * সলিউশন (বাংলা এক্সপ্লানেশন):
 * যদি আমরা শুরু থেকে (Index 0) Two Pointer চালাই এবং Merge করা শুরু করি, তবে nums1 এর ডেটা ওভাররাইট (Overwrite) 
 * হয়ে যাওয়ার ভয় থাকে। 
 * যেহেতু nums1 এর শেষের দিকটা ফাঁকা (0 দেওয়া আছে), আমরা যদি পেছন দিক থেকে (Backwards) কাজ শুরু করি, 
 * তবে ওভাররাইট হওয়ার কোনো চান্স নেই!
 * 
 * ১. `p1` পয়েন্টার: nums1 এর শেষ ভ্যালিড এলিমেন্টে (m - 1)।
 * ২. `p2` পয়েন্টার: nums2 এর শেষ এলিমেন্টে (n - 1)।
 * ৩. `p` পয়েন্টার: nums1 এর একেবারে শেষ প্রান্তে (m + n - 1), যেখানে বড় সংখ্যাটি বসবে।
 * ৪. p1 এবং p2 এর মধ্যে যে সংখ্যাটি বড়, সেটি p পজিশনে বসাব এবং পয়েন্টারগুলো কমাব।
 * 
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */