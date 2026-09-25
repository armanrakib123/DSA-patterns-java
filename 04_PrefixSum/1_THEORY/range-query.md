# Range Query Using Prefix Sum (রেঞ্জ কুয়েরি)

## The Problem Statement (সমস্যাটি কী?)
আপনাকে `N` সাইজের একটি অ্যারে দেওয়া হলো এবং `Q` সংখ্যক কুয়েরি (Queries) দেওয়া হলো। প্রতিটি কুয়েরিতে দুটি ইনডেক্স `L` এবং `R` দেওয়া থাকবে। আপনাকে বলতে হবে `L` থেকে `R` ইনডেক্স পর্যন্ত সবগুলো সংখ্যার যোগফল কত।

**Brute Force Approach**: প্রতিটি কুয়েরির জন্য আপনি একটি লুপ চালাবেন `L` থেকে `R` পর্যন্ত।
- টাইম কমপ্লেক্সিটি: $O(Q \times N)$
- যদি $N = 10^5$ এবং $Q = 10^5$ হয়, তবে $10^{10}$ অপারেশন হবে, যা Time Limit Exceeded (TLE) খাবে।

## The Optimal Approach (সঠিক পদ্ধতি)
Prefix Sum ব্যবহার করে আমরা এই কাজটিকে প্রি-প্রসেসিং এ $O(N)$ এবং প্রতিটি কুয়েরির জন্য $O(1)$ এ নিয়ে আসব।

### গাণিতিক সূত্র:
আমরা জানি `P[i]` হলো `0` থেকে `i` পর্যন্ত যোগফল।
তাহলে `L` থেকে `R` পর্যন্ত যোগফল হবে:
`Sum(L, R) = P[R] - P[L - 1]` (যদি $L > 0$ হয়)
যদি `L == 0` হয়, তবে `Sum(0, R) = P[R]`

### 1-Based Indexing Trick (মাস্টার ট্রিক!)
ইফ-এলস (`if L == 0`) এর ঝামেলা এড়ানোর জন্য FAANG ইঞ্জিনিয়াররা একটি স্মার্ট ট্রিক ব্যবহার করেন। তারা Prefix Sum অ্যারের সাইজ ১ বাড়িয়ে (`N+1`) দেন এবং 1-based indexing ব্যবহার করেন।

`P` অ্যারেটি `N+1` সাইজের হবে।
`P[0] = 0`
`P[i] = P[i-1] + nums[i-1]` (এখানে `P` এর ইনডেক্স ১ থেকে শুরু, আর `nums` এর ০ থেকে)

এই ক্ষেত্রে `L` থেকে `R` (0-based) এর রেঞ্জ সাম হবে:
`Sum(L, R) = P[R + 1] - P[L]`
কোনো ইফ-এলস এর দরকার নেই!

## Code Example (জাভা ইমপ্লিমেন্টেশন)

```java
class RangeQuery {
    private long[] prefixSum;

    // Pre-processing
    public RangeQuery(int[] nums) {
        int n = nums.length;
        // 1-based indexing for prefix sum to avoid OutOfBounds
        prefixSum = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            // P[i+1] stores sum up to index i of nums
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // O(1) query
    public long sumRange(int left, int right) {
        // sum from left to right is P[right+1] - P[left]
        return prefixSum[right + 1] - prefixSum[left];
    }
}
```

## FAANG Perspective
"Range Sum Query - Immutable" (LeetCode 303) এই প্যাটার্নের বেস প্রবলেম। ইন্টারভিউতে সরাসরি এটি আসবে না, তবে যখন আপনি একটি কঠিন ডাইনামিক প্রোগ্রামিং (DP) বা স্লাইডিং উইন্ডো সমস্যা সমাধান করবেন, তখন ভেতরের কোনো একটি স্টেপে রেঞ্জ সাম বের করতে হতে পারে। সেখানে যদি আপনি $O(N)$ লুপ ব্যবহার করেন, ইন্টারভিউয়ার সাথে সাথে আপনাকে রিজেক্ট করে দেবে। এই $O(1)$ অপটিমাইজেশনটাই আপনার দক্ষতার প্রমাণ।
