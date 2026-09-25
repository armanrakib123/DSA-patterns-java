# Prefix Sum Optimizations (অপ্টিমাইজেশন টেকনিক)

## Space Optimization (স্পেস কমানো)
Prefix Sum সাধারণত $O(N)$ স্পেস (Space) নেয়, কারণ আমাদের একটি নতুন অ্যারে তৈরি করতে হয়। 
কিন্তু অনেক ক্ষেত্রে আমরা চাইলে **In-place Prefix Sum** করতে পারি, অর্থাৎ মূল অ্যারেটিকেই পরিবর্তন করে Prefix Sum অ্যারে বানিয়ে ফেলতে পারি।

```java
// In-place Prefix Sum
for (int i = 1; i < nums.length; i++) {
    nums[i] += nums[i - 1];
}
```
**কখন এটি করবেন?**
- যখন মূল অ্যারের ডেটা পরে আর আসল রূপে (Original Form) দরকার হবে না।
- ইন্টারভিউয়ার যদি অতিরিক্ত স্পেস ব্যবহার করতে নিষেধ করেন।

**কখন এটি করবেন না?**
- যদি অরিজিনাল ডেটা অন্য কোনো কাজে লাগে।
- ফাংশনের প্যারামিটার হিসেবে আসা ডেটা যদি Immutable (অপরিবর্তনযোগ্য) রাখা বেস্ট প্র্যাকটিস হয় (বিশেষ করে প্রোডাকশন কোডে অরিজিনাল প্যারামিটার মিউটেট/পরিবর্তন করা ভালো প্র্যাকটিস নয়)।

## Time Optimization using HashMap
অনেক সময় আমাদের শুধু "Target Sum" খুঁজতে হয়, পুরো Prefix Sum অ্যারে স্টোর করার দরকার হয় না। তখন আমরা শুধু একটি `runningSum` বা `currentSum` ভেরিয়েবল এবং একটি `HashMap` ব্যবহার করতে পারি। এটি Prefix Sum এর সবচেয়ে পপুলার অপ্টিমাইজেশন।

```java
int count = 0;
long currentSum = 0;
Map<Long, Integer> map = new HashMap<>();
map.put(0L, 1); // Base case

for (int num : nums) {
    currentSum += num;
    if (map.containsKey(currentSum - k)) {
        count += map.get(currentSum - k);
    }
    map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
}
```
**সুবিধা:**
- এখানে আমরা $O(N)$ টাইমে কাজ করছি।
- আলাদা কোনো `O(N)` Array লাগছে না, শুধু Map-এর স্পেস লাগছে।

## Array vs HashMap Optimization (Speed up)
যদি `Target Sum` এর মান এবং অ্যারের সাইজ একটি নির্দিষ্ট ছোট রেঞ্জের মধ্যে থাকে, তবে HashMap এর বদলে Array ব্যবহার করলে প্রোগ্রাম অনেক বেশি ফাস্ট (Fast) হয়। কারণ HashMap-এ Hashing এবং Collision Resolve করতে কিছুটা ওভারহেড (Overhead) থাকে, যেখানে Array তে ইন্ডেক্সিং $O(1)$ এবং খুবই ফাস্ট।
(যেমন: *Continuous Subarray Sum* বা *Count Vowel Strings in Ranges* প্রবলেমে)।

## Summary for Interviews
1. **Range Sum Queries**: Use 1-based index Prefix Sum Array. ($O(N)$ Space, $O(1)$ Query)
2. **Subarray Sum Equals K**: Use Running Sum + HashMap. ($O(N)$ Time, $O(N)$ Space)
3. **2D Range Queries**: Use 1-based 2D Prefix Sum Matrix. ($O(R \times C)$ Space, $O(1)$ Query)
