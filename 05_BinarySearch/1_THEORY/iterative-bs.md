# Iterative Binary Search (ইটারেটিভ বাইনারি সার্চ)

## Introduction (ভূমিকা)
Binary Search হলো এমন একটি অ্যালগরিদম যা একটি সর্টেড (Sorted) অ্যারের মধ্যে কোনো নির্দিষ্ট উপাদান খুঁজতে $O(\log N)$ সময় নেয়।
যেখানে Linear Search এ $O(N)$ সময় লাগে, সেখানে যদি অ্যারের সাইজ ১ বিলিয়ন ($10^9$) হয়, তবে Binary Search মাত্র ৩০টি ধাপে উত্তর খুঁজে বের করতে পারে ($2^{30} > 10^9$)।

## Core Concept (মূল কনসেপ্ট)
বাইনারি সার্চের মূল ভিত্তি হলো "Search Space (খোঁজার জায়গা)" কে প্রতি ধাপে অর্ধেক করে ফেলা।
১. অ্যারের মাঝখানের (Mid) উপাদানের সাথে টার্গেট (Target) চেক করা হয়।
২. যদি Mid টাই টার্গেট হয়, তবে উত্তর পেয়ে গেলাম।
৩. যদি Target ছোট হয়, তবে আমরা নিশ্চিত যে Target বাম পাশে আছে (কারণ অ্যারে সর্টেড)। তখন Search Space অর্ধেক করে বাম পাশে ফোকাস করি।
৪. যদি Target বড় হয়, তবে ডান পাশে ফোকাস করি।

## The Iterative Approach (লুপ ব্যবহার করে)
FAANG ইন্টারভিউতে সবসময় ইটারেটিভ (while লুপ) অ্যাপ্রোচকে প্রাধান্য দেওয়া হয়, কারণ এতে রিকার্সন (Recursion) এর মতো কোনো মেমরি স্ট্যাক ওভারহেড (Stack Overhead) থাকে না। এর স্পেস কমপ্লেক্সিটি $O(1)$।

### The Most Standard Template (স্ট্যান্ডার্ড টেমপ্লেট)
```java
public int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1; // Search Space is [left, right]
    
    while (left <= right) { // <= is extremely important!
        // Prevent Integer Overflow
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid; // Found it!
        } else if (nums[mid] < target) {
            left = mid + 1; // Target is strictly on the right
        } else {
            right = mid - 1; // Target is strictly on the left
        }
    }
    
    return -1; // Target not found
}
```

## FAANG Pro Tips (ইন্টারভিউ ট্রিকস)

### 1. Integer Overflow Prevention
আপনি যদি `mid = (left + right) / 2` লেখেন, আর `left` ও `right` এর মান যদি খুব বড় হয় (যেমন $10^9$), তবে তাদের যোগফল `int` এর ম্যাক্সিমাম লিমিট ($2 \times 10^9$) পার হয়ে যেতে পারে। এতে আপনি নেগেটিভ `mid` পাবেন এবং `ArrayIndexOutOfBoundsException` খাবেন। 
সবসময় `mid = left + (right - left) / 2` ব্যবহার করবেন।

### 2. The Loop Condition (`<=` vs `<`)
যখন আপনি `right = nums.length - 1` নিবেন, তার মানে আপনি ডানদিকের বাউন্ডারিকে (Boundary) অন্তর্ভুক্ত (Inclusive) করেছেন। তাই লুপটি `left <= right` হওয়া উচিত। যদি `right = nums.length` নিতেন (Exclusive), তখন `left < right` ব্যবহার করতে হতো। 
ইন্টারভিউতে কনফিউশন এড়াতে সবসময় `right = nums.length - 1` এবং `left <= right` টেমপ্লেটটি মুখস্ত করে ফেলুন।
