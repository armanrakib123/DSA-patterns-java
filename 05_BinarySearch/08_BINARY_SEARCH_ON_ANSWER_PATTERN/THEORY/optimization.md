# Optimizations in Binary Search on Answer

## 1. Tightening the Search Space (`low` and `high`)
আমরা চাইলে `low = 0` এবং `high = Integer.MAX_VALUE` দিয়ে সব প্রবলেম সলভ করতে পারি। বাইনারি সার্চ এতই ফাস্ট যে এটি কাজও করবে।
কিন্তু FAANG ইন্টারভিউতে এটি একটি "Red Flag"। 
আপনি যদি `low` এবং `high` কে ম্যাথমেটিক্যালি যতটা সম্ভব টাইট (Tight) করতে পারেন, তত আপনার কোড অপ্টিমাইজড হবে।
- যেমন: অ্যারের ম্যাক্সিমাম ভ্যালু এবং সাম (Sum) বের করে `low` এবং `high` সেট করা।

## 2. Using Math instead of Loops in `isValid`
কখনো কখনো `isValid` ফাংশনের ভেতরে লুপ না চালিয়ে শুধু ম্যাথ (Math) দিয়ে কাজ করা যায়।
উদাহরণ: "Koko Eating Bananas" এ, প্রতিটি পিল (Pile) শেষ করতে কত ঘণ্টা লাগবে তা বের করতে:
```java
// Slower:
int hours = 0;
while (pile > 0) {
    pile -= speed;
    hours++;
}

// Faster (O(1) Math):
int hours = (int) Math.ceil((double) pile / speed);

// Even Faster & Safer Math (Without floating point inaccuracies):
int hours = (pile + speed - 1) / speed; // Ceiling division trick!
```
এই `(pile + speed - 1) / speed` ট্রিকটি ইন্টারভিউয়ারকে মুগ্ধ করার জন্য যথেষ্ট।

## 3. Handling Integer Overflow for `high`
যদি `high` এর মান অনেক বড় হয় (যেমন সব প্যাকেজের ওজনের যোগফল), তখন সেটি `int` এর রেঞ্জ ($2 \times 10^9$) পার হয়ে যেতে পারে।
তাই `low`, `high` এবং `mid` ভেরিয়েবলগুলোকে `long` হিসেবে ডিক্লেয়ার করা সবচেয়ে সেফ (Safe) অপশন।

```java
long low = maxElement;
long high = totalSum;

while(low <= high) {
    long mid = low + (high - low) / 2;
    // ...
}
```

## 4. Sorting the Array
মাঝে মাঝে (যেমন: Aggressive Cows প্রবলেমে), `isValid` ফাংশনটি ঠিকমতো কাজ করার জন্য ইনপুট অ্যারেটি সর্টেড থাকতে হয়।
লুপের ভেতরে বা `isValid` ফাংশনের ভেতরে কখনোই `Arrays.sort()` কল করবেন না! এটি বাইনারি সার্চের আগে, মেইন ফাংশনের শুরুতেই একবার কল করে নিতে হবে।
