# Priority Queue (প্রায়োরিটি কিউ)

## What is a Priority Queue?
Priority Queue হলো একটি ডাটা স্ট্রাকচার যা অনেকটা সাধারণ Queue-এর মতোই কাজ করে, কিন্তু এখানে প্রতিটি এলিমেন্টের একটি **প্রায়োরিটি (Priority)** বা গুরুত্ব থাকে। 
- সাধারণ কিউ-তে যে আগে আসে, সে আগে বের হয় (FIFO)।
- প্রায়োরিটি কিউ-তে যার প্রায়োরিটি বেশি, সে আগে বের হয়।

## Implementation in Java
জাভাতে প্রায়োরিটি কিউ ইমপ্লিমেন্ট করার জন্য `java.util.PriorityQueue` ক্লাসটি ব্যবহার করা হয়। এটি ইন্টারনালি একটি **Min-Heap** ব্যবহার করে।
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // ডিফল্ট মিনিমাম হিপ
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // ম্যাক্সিমাম হিপ
```

## Custom Comparator
যদি আপনি অবজেক্ট নিয়ে কাজ করেন, তবে আপনাকে বলে দিতে হবে কিসের ভিত্তিতে প্রায়োরিটি নির্ধারিত হবে।
```java
PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
```

## Top K Pattern
প্রায়োরিটি কিউ-এর সবচেয়ে কমন ব্যবহার হলো একটি বড় ডাটা সেট থেকে সেরা K টি এলিমেন্ট খুঁজে বের করা। 
- **Top K Largest:** একটি সাইজ K-এর **Min-Heap** ব্যবহার করুন। যখনই নতুন ডাটা আসবে, যদি সেটি হিপ-এর টপ (মিনিমাম) থেকে বড় হয়, তবে টপ-কে ফেলে দিয়ে নতুন ডাটাটি ঢোকান। শেষে হিপ-এ থাকা K টি এলিমেন্টই হবে সবচেয়ে বড় K টি এলিমেন্ট।
- **Top K Smallest:** একইভাবে সাইজ K-এর **Max-Heap** ব্যবহার করুন।

এই ট্রিকটি ডাটা স্ট্রিমিং এবং লার্জ স্কেল সিস্টেম ডিজাইনে অনেক মেমরি সেভ করে। 📊👑✅
