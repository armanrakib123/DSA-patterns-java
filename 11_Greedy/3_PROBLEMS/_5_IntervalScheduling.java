import java.util.Arrays;

public class _5_IntervalScheduling {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removeCount = 0;
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < currentEnd) {
                removeCount++; 
            } else {
                currentEnd = end;
            }
        }

        return removeCount;
    }

    public static void main(String[] args) {
        _5_IntervalScheduling solution = new _5_IntervalScheduling();
        
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println("Minimum intervals to remove: " + solution.eraseOverlapIntervals(intervals)); 
        // Output: 1 (আমরা [1,3] রিমুভ করলে বাকিগুলো ওভারল্যাপ করবে না)
    }
}
























/**
 * Interval Scheduling / Activity Selection
 * LeetCode 435: Non-overlapping Intervals (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * অনেকগুলো ইন্টারভাল (intervals) দেওয়া আছে, যেখানে intervals[i] = [start, end]।
 * আপনাকে বলতে হবে মিনিমাম কয়টি ইন্টারভাল রিমুভ (Remove) করলে বাকি ইন্টারভালগুলোর মধ্যে 
 * কোনো ওভারল্যাপিং (Overlapping) বা সংঘর্ষ থাকবে না।
 * 
 * এপ্রোচ (Approach):
 * এটি ক্লাসিক Activity Selection প্রবলেমের একটি ভিন্ন রূপ। 
 * মিনিমাম কয়টি রিমুভ করতে হবে = (মোট ইন্টারভাল - ম্যাক্সিমাম নন-ওভারল্যাপিং ইন্টারভাল)।
 * 
 * ১. প্রথমে আমরা ইন্টারভালগুলোকে তাদের End Time অনুযায়ী সর্ট (Sort) করব।
 *    কেন End Time? কারণ একটি কাজ যত তাড়াতাড়ি শেষ হবে, পরের কাজ শুরু করার জন্য 
 *    তত বেশি সময় পাওয়া যাবে (Greedy Choice)।
 * ২. এরপর লুপ চালিয়ে দেখব কোন কাজগুলো করা যায়। 
 * ৩. যদি কোনো কাজের Start Time আগের কাজের End Time এর চেয়ে ছোট হয়, তার মানে 
 *    তারা ওভারল্যাপ করছে! তখন আমরা সেটিকে রিমুভ করব (রিমুভ কাউন্ট বাড়াব)।
 * 
 * Time Complexity: O(N log N) - সর্ট করার জন্য।
 * Space Complexity: O(1) বা O(log N) সর্টিং অ্যালগরিদমের উপর ভিত্তি করে।
 */