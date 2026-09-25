# Writing the Feasibility Check (isValid function)

Binary Search on Answer প্রবলেমগুলোর মূল লজিক থাকে এই `isValid(mid)` বা `isPossible(mid)` ফাংশনের ভেতরে।
বাইনারি সার্চের লুপ লেখা খুবই সহজ, কিন্তু এই ফাংশনটি লেখাই হলো আসল খেলা।

## General Structure (সাধারণ গঠন)
এই ফাংশনটি সাধারণত $O(N)$ টাইমে একটি সিমুলেশন (Simulation) রান করে।
আমাদের টার্গেট হলো, একটি নির্দিষ্ট ক্যাপাসিটি বা স্পিড (যেটি `mid`) ব্যবহার করে প্রদত্ত শর্তটি (যেমন: নির্দিষ্ট দিন, নির্দিষ্ট ঘণ্টা, নির্দিষ্ট গরু) পূরণ করা যায় কি না তা চেক করা।

```java
private boolean isValid(int[] array, int maxAllowed, int limitCondition) {
    int currentSum = 0;
    int count = 1; // Sometimes starts at 0 depending on the problem
    
    for (int num : array) {
        // Essential check: If a single element is larger than the allowed capacity,
        // it's immediately impossible.
        if (num > maxAllowed) {
            return false; 
        }
        
        currentSum += num;
        
        if (currentSum > maxAllowed) {
            count++; // Start a new group/day
            currentSum = num; // The new group starts with the current element
        }
    }
    
    // Check if the total groups/days used is within the limit condition
    return count <= limitCondition;
}
```

## Step-by-Step Thought Process
যখন আপনি `isValid` ফাংশন লিখবেন, তখন নিজেকে এই প্রশ্নগুলো করবেন:
1. **কী কাউন্ট করছি?** দিন, ঘণ্টা, নাকি গরুর সংখ্যা?
2. **শুরুতে কাউন্ট কত হবে?** যদি দিন গোনেন, তবে প্রথম দিন তো শুরু হয়েই গেছে, তাই `count = 1`। যদি গরু বসানো গোনেন, তবে প্রথম গরু বসানো হয়ে গেছে, তাই `cowsPlaced = 1`।
3. **কখন কাউন্ট বাড়বে?** যখন বর্তমান ক্যাপাসিটি বা স্পিড দিয়ে আর কাজ চালানো যাচ্ছে না।
4. **শর্ত কী?** লুপ শেষে `return count <= requiredDays` হবে নাকি `return cowsPlaced >= requiredCows` হবে?

## Common Pitfalls (যে ভুলগুলো সবাই করে)
- **Data Types:** মাঝে মাঝে `currentSum` অনেক বড় হয়ে `Integer Overflow` হতে পারে। তাই `long` ব্যবহার করাটা সেফ।
- **Element > Mid Check:** যদি জাহাজের ক্যাপাসিটি হয় ৫, আর একটি প্যাকেজের ওজনই হয় ৬, তবে এটি কখনোই পাঠানো সম্ভব নয়। লুপের শুরুতেই `if (num > mid) return false;` লেখাটা অত্যন্ত জরুরি। এটি অনেক সময় `low` সেট করার সময় কভার করা হয়, কিন্তু `isValid` এর ভেতরে থাকাটা ডাবল প্রোটেকশন দেয়।
