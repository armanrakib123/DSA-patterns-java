package _17_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval Example
 * LeetCode 57: Insert Interval (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি নন-ওভারল্যাপিং ইন্টারভাল লিস্ট দেওয়া আছে (যা আগে থেকেই Start Time অনুযায়ী সর্টেড)।
 * আপনাকে একটি নতুন ইন্টারভাল (newInterval) ওই লিস্টে ইনসার্ট (Insert) করতে হবে 
 * এবং যদি কোনো ওভারল্যাপ তৈরি হয়, তবে তাদের মার্জ (Merge) করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * এটি LC 56 (Merge Intervals) এর মতোই, কিন্তু যেহেতু এটি আগে থেকেই সর্টেড, 
 * তাই আমরা O(N) এ (সর্ট না করেই) সলভ করতে পারি।
 * 
 * ১. একটি লুপ চালাব। তিন ধরনের অবস্থা (State) হতে পারে:
 *    - অবস্থা ১: বর্তমান ইন্টারভালটি newInterval এর আগে শেষ হয়ে গেছে (End < newStart)। 
 *                এদের সরাসরি লিস্টে যোগ করব।
 *    - অবস্থা ২: বর্তমান ইন্টারভালটি newInterval এর পরে শুরু হয়েছে (Start > newEnd)। 
 *                এর মানে newInterval এর জায়গা পার হয়ে গেছে। তাই newInterval কে লিস্টে যোগ করব।
 *    - অবস্থা ৩: ওভারল্যাপ করছে! তখন আমরা newInterval এর ভ্যালু আপডেট করে (Merge) মার্জ করব:
 *                `newStart = min(start, newStart)` এবং `newEnd = max(end, newEnd)`।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // অবস্থা ১: যে ইন্টারভালগুলো newInterval এর আগে আছে (ওভারল্যাপ করে না)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // অবস্থা ৩ (মাঝখানে): ওভারল্যাপ করছে, তাই মার্জ করি
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // মার্জ করা চূড়ান্ত newInterval টি লিস্টে যোগ করি
        result.add(newInterval);

        // অবস্থা ২: যে ইন্টারভালগুলো newInterval এর পরে আছে (ওভারল্যাপ করে না)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        
        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {4,8}; // এটি {3,5}, {6,7}, {8,10} এর সাথে ওভারল্যাপ করবে
        
        int[][] result = solution.insert(intervals, newInterval);
        
        System.out.println("After Insertion: ");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        // Output: [1, 2] [3, 10] [12, 16] 
    }
}
