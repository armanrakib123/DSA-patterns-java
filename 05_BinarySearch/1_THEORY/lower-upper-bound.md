# Lower Bound and Upper Bound (লোয়ার বাউন্ড ও আপার বাউন্ড)

## What is it? (এটি কী?)
সি++ (C++) এ `lower_bound` এবং `upper_bound` নামে দুটি বিল্ট-ইন (Built-in) ফাংশন আছে। কিন্তু জাভাতে সরাসরি এগুলো নেই (хоть `Arrays.binarySearch` আছে, কিন্তু ডাটা ডুপ্লিকেট থাকলে সেটি নির্দিষ্ট ইন্ডেক্স রিটার্ন করার গ্যারান্টি দেয় না)।
তাই FAANG ইন্টারভিউতে "Find First and Last Position of Element in Sorted Array" এর মতো প্রশ্নে আপনাকে নিজে হাতে এই লজিকটি ইমপ্লিমেন্ট করতে হবে।

## Lower Bound (প্রথম উপস্থিতি)
লোয়ার বাউন্ড হলো কোনো নির্দিষ্ট টার্গেটের **প্রথম উপস্থিতি (First Occurrence)** অথবা এমন একটি পজিশন যেখানে টার্গেটটিকে ইনসার্ট (Insert) করলে অ্যারের সর্টেড (Sorted) অবস্থা ঠিক থাকবে।

**লজিক**: যখন `nums[mid] == target` হবে, আমরা সাথে সাথে রিটার্ন করব না। কারণ টার্গেটটি এর বাম পাশেও থাকতে পারে। আমরা `right = mid - 1` করে বাম দিকে খোঁজা চালিয়ে যাব, কিন্তু বর্তমান `mid` কে একটি ভেরিয়েবলে সেভ করে রাখব।

```java
int findLowerBound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    int ans = -1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            ans = mid; // Might be the answer, but keep looking left
            right = mid - 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}
```

## Upper Bound (শেষ উপস্থিতি)
আপার বাউন্ড হলো কোনো নির্দিষ্ট টার্গেটের **শেষ উপস্থিতি (Last Occurrence)**।
C++ এ অবশ্য Upper Bound বলতে বোঝায় এমন প্রথম ইলিমেন্ট যা টার্গেটের চেয়ে strictly বড় (>)। কিন্তু লেটকোডের প্রবলেমে সাধারণত "Last Occurrence" কেই ফোকাস করা হয়।

**লজিক**: যখন `nums[mid] == target` হবে, তখন আমরা `left = mid + 1` করে ডান দিকে খোঁজা চালিয়ে যাব, যাতে সবচেয়ে ডানদিকের টার্গেটটি (Last Occurrence) খুঁজে পাই।

```java
int findUpperBound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    int ans = -1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            ans = mid; // Might be the answer, but keep looking right
            left = mid + 1;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}
```

## The Search Insert Position (LeetCode 35)
যদি প্রশ্ন করা হয়, "একটি টার্গেট দেওয়া আছে, যদি থাকে তবে ইন্ডেক্স দাও, না থাকলে কোথায় ইনসার্ট করলে সর্টেড থাকবে তার ইন্ডেক্স দাও।"
এটি হুবহু সাধারণ বাইনারি সার্চের লজিক, শুধু শেষে `-1` রিটার্ন করার বদলে `left` পয়েন্টারটি রিটার্ন করতে হয়! 
কারণ যখন লুপ ব্রেক হয় (`left > right`), তখন `left` সবসময় ঠিক সেই পজিশনেই গিয়ে থামে যেখানে টার্গেটটি বসার কথা। এটি একটি চমৎকার ম্যাথমেটিকাল প্রপার্টি।
