package _17_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge Intervals Example LeetCode 56: Merge Intervals (Medium) - Software
 * Company Favorite
 *
 * প্রবলেম স্টেটমেন্ট: অনেকগুলো ইন্টারভাল দেওয়া আছে। আপনাকে ওভারল্যাপ (Overlap)
 * করা সব ইন্টারভালগুলোকে মার্জ (Merge) করে একটি নন-ওভারল্যাপিং ইন্টারভাল লিস্ট
 * রিটার্ন করতে হবে।
 *
 * এপ্রোচ (Approach): ১. প্রথমে সবগুলো ইন্টারভালকে তাদের Start Time অনুযায়ী
 * সর্ট (Sort) করে নেব। ২. একটি List তৈরি করব রেজাল্ট রাখার জন্য। প্রথম
 * ইন্টারভালটি লিস্টে যোগ করে দেব। ৩. এরপর দ্বিতীয় ইন্টারভাল থেকে লুপ চালাব। ৪.
 * লিস্টের শেষের ইন্টারভালটি (Last added interval) নেব এবং চেক করব বর্তমান
 * ইন্টারভালের সাথে ওভারল্যাপ করে কি না। ৫. ওভারল্যাপ শর্ত: `current.start <=
 * lastAdded.end` ৬. যদি ওভারল্যাপ করে, তবে তাদের মার্জ করব: `lastAdded.end =
 * Math.max(lastAdded.end, current.end)` ৭. যদি ওভারল্যাপ না করে, তবে বর্তমান
 * ইন্টারভালটিকে লিস্টে নতুন করে যোগ করব।
 *
 * Time Complexity: O(N log N) - সর্ট করার জন্য। Space Complexity: O(N) -
 * রেজাল্ট লিস্টের জন্য।
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // ১. Start Time অনুযায়ী সর্ট করা
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();

        // ২. প্রথম ইন্টারভালটি লিস্টে যোগ করা
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        // ৩. বাকি ইন্টারভালগুলো চেক করা
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // বর্তমান লিস্টের শেষের ইন্টারভালের End (currentInterval[1]) 
            // এবং নতুন ইন্টারভালের Start (nextInterval[0]) তুলনা করা
            if (nextInterval[0] <= currentInterval[1]) {
                // ওভারল্যাপ করছে, তাই মার্জ করি (End টাইম আপডেট করি)
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // ওভারল্যাপ করছে না, তাই নতুন ইন্টারভালটি লিস্টে যোগ করি
                currentInterval = nextInterval;
                mergedList.add(currentInterval);
            }
        }

        // List<int[]> কে int[][] এ কনভার্ট করে রিটার্ন করা
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);

        System.out.println("Merged Intervals: ");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        // Output: [1, 6] [8, 10] [15, 18] 
        // Explanation: [1,3] এবং [2,6] ওভারল্যাপ করে, তাই তারা মার্জ হয়ে [1,6] হয়েছে।
    }
}
