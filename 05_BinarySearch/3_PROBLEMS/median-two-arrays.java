package 07_BINARY_SEARCH_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 4. Median of Two Sorted Arrays
 * Category: Hard (One of the most famous Hard problems in FAANG)
 * 
 * Problem: Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class median_two_arrays {

    /**
     * Approach: Binary Search on the smaller array
     * The median splits the combined array into two equal halves.
     * We can find a "Partition" in nums1 and a corresponding "Partition" in nums2 
     * such that the left half has the same number of elements as the right half.
     * 
     * Time Complexity: O(log(min(M, N)))
     * Space Complexity: O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize the binary search space
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x; // We binary search the partition index, so it can go up to x
        
        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            // The total elements in the left half should be (x + y + 1) / 2
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            // Edge cases: If partition is at 0, there is nothing on the left
            // If partition is at length, there is nothing on the right
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            
            // Check if we found the perfect partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total length is even
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } 
                // If total length is odd
                else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } 
            // We are too far on the right side of X, need to move left
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } 
            // We are too far on the left side of X, need to move right
            else {
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    /*
     * FAANG Interview Note:
     * This is the Boss Level of Binary Search.
     * The intuition is NOT searching for the number itself, but searching for the PARTITION.
     * Making sure `nums1` is always the smaller array ensures we don't get 
     * `ArrayIndexOutOfBoundsException` when calculating `partitionY`.
     */
}
