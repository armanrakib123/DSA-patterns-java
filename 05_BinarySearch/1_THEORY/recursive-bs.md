# Recursive Binary Search (রিকার্সিভ বাইনারি সার্চ)

## Introduction (ভূমিকা)
রিকার্সন (Recursion) ব্যবহার করে বাইনারি সার্চ ইমপ্লিমেন্ট করা কোডকে অনেক বেশি রিডেবল (Readable) করে তোলে, বিশেষ করে যখন আমরা ট্রি (Tree) বা গ্রাফ (Graph) এর ভেতরে বাইনারি সার্চের লজিক অ্যাপ্লাই করি (যেমন: Binary Search Tree)।

## The Concept
রিকার্সনের মূল কথা হলো একটি বড় সমস্যাকে ছোট সাব-প্রবলেমে (Sub-problem) ভাগ করা।
এখানে আমাদের একটি ফাংশন থাকে যা `(left, right)` রেঞ্জ নিয়ে কাজ করে। 
- যদি `left > right` হয়ে যায়, তার মানে Search Space শেষ। (Base Case)
- যদি `nums[mid]` টার্গেট হয়, তবে উত্তর রিটার্ন করি।
- অন্যথায় আমরা একই ফাংশনটিকে অর্ধেক রেঞ্জ `(left, mid - 1)` অথবা `(mid + 1, right)` দিয়ে পুনরায় কল (Call) করি।

## Java Implementation

```java
public int binarySearchRecursive(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
}

private int search(int[] nums, int target, int left, int right) {
    // Base Case: Invalid range (Search Space exhausted)
    if (left > right) {
        return -1;
    }
    
    // Calculate mid to prevent integer overflow
    int mid = left + (right - left) / 2;
    
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        // Target is on the right half
        return search(nums, target, mid + 1, right);
    } else {
        // Target is on the left half
        return search(nums, target, left, mid - 1);
    }
}
```

## Recursive vs Iterative (কোনটি ভালো?)

### Time Complexity
উভয় ক্ষেত্রেই Time Complexity হলো $O(\log N)$।

### Space Complexity (মেমরি)
- **Iterative**: $O(1)$ (কারণ শুধু `left`, `right`, `mid` ভেরিয়েবল ব্যবহার হয়)।
- **Recursive**: $O(\log N)$ (কারণ রিকার্সন যত গভীরে যায়, ফাংশন কলের জন্য ততগুলো মেমরি স্ট্যাক ফ্রেম (Stack Frame) তৈরি হয়)।

### FAANG Interview Tip
কোডিং ইন্টারভিউতে যদি আপনাকে সরাসরি "Binary Search" লিখতে বলা হয়, তবে **সবসময় Iterative পদ্ধতি ব্যবহার করবেন**। কারণ এটি স্পেস অপ্টিমাইজড।
তবে যদি আপনি Divide & Conquer (যেমন: Merge Sort, Quick Sort) বা Tree Traversal এর সাথে কাজ করেন, তখন Recursive পদ্ধতিটি বেশি মানানসই। ইন্টারভিউয়ারকে এই Trade-off টি (পার্থক্যটি) বুঝিয়ে বলাটা আপনার এক্সপার্টিজ (Expertise) প্রমাণ করে।
