# Binary Search on Answer / Parametric Search (প্যারামেট্রিক সার্চ)

## Introduction (ভূমিকা)
এতক্ষণ আমরা Binary Search ব্যবহার করেছি একটি অ্যারের মধ্যে কোনো ডাটা (Target) খুঁজে বের করার জন্য।
কিন্তু FAANG ইন্টারভিউতে সবচেয়ে বেশি যেই প্যাটার্নটি আসে, সেটি হলো **"Binary Search on Answer"**।
এখানে কোনো অ্যারের ইনডেক্সে বাইনারি সার্চ চালানো হয় না, বরং **সম্ভাব্য উত্তরের (Possible Answer Space) উপর বাইনারি সার্চ চালানো হয়**।

## When to use it? (কখন ব্যবহার করবেন?)
যদি কোনো প্রশ্নে এই তিনটি বৈশিষ্ট্য থাকে, তবে চোখ বন্ধ করে এটি Binary Search on Answer এর প্রবলেম:
1. **Optimization Goal**: প্রশ্নটি "Minimum of the Maximum" বা "Maximum of the Minimum" বের করতে বলবে। (যেমন: "Find the minimum capacity required to ship all packages").
2. **Answer Range is Known**: উত্তরের একটি রেঞ্জ বা বাউন্ডারি আপনি লজিক্যালি চিন্তা করে বের করতে পারবেন (যেমন: ক্যাপাসিটি কমপক্ষে সর্বোচ্চ প্যাকেজের ওজনের সমান হবে, এবং সর্বোচ্চ সব প্যাকেজের মোট ওজনের সমান হবে)।
3. **Monotonicity (মনোটোনিসিটি)**: যদি আমি বলি "১০ ক্যাপাসিটি দিয়ে কি কাজটা করা সম্ভব?", আর উত্তর আসে "হ্যাঁ", তাহলে আমি চোখ বন্ধ করে বলতে পারি "১১, ১২ বা ১০০ ক্যাপাসিটি দিয়েও কাজটি করা সম্ভব"। 
   আর যদি উত্তর আসে "না", তার মানে ৯ বা ৮ দিয়েও করা সম্ভব নয়।
   এই **"Yes Yes Yes No No No"** বা **"No No No Yes Yes Yes"** প্যাটার্নটিকেই Monotonicity বলে, যা বাইনারি সার্চ অ্যাপ্লাই করার মূল শর্ত।

## How does it work? (কীভাবে কাজ করে?)
এর জন্য আমাদের দুটি জিনিস তৈরি করতে হবে:
1. **Search Space**: `low` এবং `high` সেট করা।
2. **Feasibility Check Function `isValid(mid)`**: এটি একটি আলাদা হেল্পার (Helper) ফাংশন যা `true` বা `false` রিটার্ন করে। এটি চেক করে যে বর্তমান `mid` ভ্যালুটি দিয়ে প্রদত্ত শর্ত পূরণ করা সম্ভব কি না।

### Structure (স্ট্রাকচার)
```java
long low = [Minimum possible answer];
long high = [Maximum possible answer];
long ans = -1;

while (low <= high) {
    long mid = low + (high - low) / 2;
    
    if (isValid(mid)) {
        ans = mid; // Possible answer, record it
        high = mid - 1; // Since we want the MINIMUM, search the lower half
    } else {
        low = mid + 1; // mid was not enough, search the upper half
    }
}
return ans;
```

পরবর্তী আর্টিকেলে আমরা শিখব কিভাবে এই Search Space (`low` এবং `high`) লজিক্যালি খুঁজে বের করতে হয় এবং `isValid` ফাংশনটি কিভাবে দ্রুত লিখতে হয়।
