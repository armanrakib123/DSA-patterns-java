package 

15_FAST_SLOW_POINTER_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 457. Circular Array Loop
 * Category: Medium (Fast & Slow in Array)
 * 
 * Problem: Determine if there is a cycle in a circular array. 
 * A cycle must be in a single direction (all forward or all backward) and length > 1.
 */
public class circular_array_loop {

    /**
     * Approach: Fast & Slow Pointers Each index i is a node, and the next node
     * is (i + nums[i]) % n. We run cycle detection for each starting index.
     *
     * Time Complexity: O(N) Space Complexity: O(1)
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;

            while (true) {
                slow = getNext(nums, slow, isForward);
                if (slow == -1) {
                    break;
                }

                fast = getNext(nums, fast, isForward);
                if (fast == -1) {
                    break;
                }
                fast = getNext(nums, fast, isForward);
                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }

            // Mark all nodes in this non-cycle path as 0 to avoid re-checking
            int curr = i;
            while (getNext(nums, curr, isForward) != -1) {
                int next = getNext(nums, curr, isForward);
                nums[curr] = 0;
                curr = next;
            }
        }
        return false;
    }

    private int getNext(int[] nums, int curr, boolean isForward) {
        int n = nums.length;
        boolean currDir = nums[curr] > 0;
        if (isForward != currDir) {
            return -1;
        }

        int next = (curr + nums[curr]) % n;
        if (next < 0) {
            next += n;
        }

        if (next == curr) {
            return -1; // Length must be > 1

                }return next;
    }

    /*
     * Software Company Interview Note:
     * This is a very complex cycle detection problem. 
     * Handling the direction change and length-1 cycle are the key hurdles.
     */
}
