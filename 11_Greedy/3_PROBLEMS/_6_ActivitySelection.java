public class _6_ActivitySelection {

    public int maxActivities(int[] start, int[] end) {
        if (start.length == 0) return 0;

        int count = 1; // প্রথম কাজটি আমরা সবসময় করব (কারণ এটি সবার আগে শেষ হয়)
        int currentEnd = end[0];

        System.out.println("Selected Activity 0 (Start: " + start[0] + ", End: " + end[0] + ")");

        for (int i = 1; i < start.length; i++) {
            // যদি বর্তমান কাজের শুরুর সময়, আগের কাজের শেষ হওয়ার সময়ের পরে বা সমান হয়
            if (start[i] >= currentEnd) {
                count++;
                currentEnd = end[i]; // End Time আপডেট
                System.out.println("Selected Activity " + i + " (Start: " + start[i] + ", End: " + end[i] + ")");
            }
        }

        return count;
    }

    public static void main(String[] args) {
        _6_ActivitySelection solution = new _6_ActivitySelection();
        
        // 6 টি কাজ। end time অনুযায়ী সর্টেড আছে: 2, 4, 6, 7, 9, 9
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};
        
        int max = solution.maxActivities(start, end);
        System.out.println("Maximum activities possible: " + max);
        // Output: 4 (Activity 0, 1, 3, 4)
    }
}















// প্রবলেম স্টেটমেন্ট:
// অনেকগুলো ইন্টারভাল (intervals) দেওয়া আছে, যেখানে intervals[i] = [start, end]।
// আপনাকে বলতে হবে মিনিমাম কয়টি ইন্টারভাল রিমুভ (Remove) করলে বাকি ইন্টারভালগুলোর মধ্যে 
// কোনো ওভারল্যাপিং (Overlapping) বা সংঘর্ষ থাকবে না।
