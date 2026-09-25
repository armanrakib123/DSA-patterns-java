# Monotonicity in Binary Search (মনোটোনিসিটি)

## What is Monotonicity? (এটি কী?)
গণিতের ভাষায়, একটি ফাংশনকে Monotonic বলা হয় যদি সেটি শুধুমাত্র বাড়ে (Non-decreasing) অথবা শুধুমাত্র কমে (Non-increasing)। এটি কখনো বাড়ে-কমে এমন জিগজ্যাগ (Zigzag) হতে পারে না।

Binary Search কাজ করার একমাত্র এবং প্রধান শর্ত হলো এই মনোটোনিসিটি।
যদি আমরা একটি ফাংশন `isValid(x)` ডিফাইন করি, তবে ইনপুট $x$ এর মান বাড়ার সাথে সাথে এর রেজাল্ট অবশ্যই একটি নির্দিষ্ট প্যাটার্ন ফলো করবে।

## Two Types of Monotonic Patterns in "Binary Search on Answer"

### Pattern 1: F F F F T T T T (False to True)
- **Problem Type**: "Find the MINIMUM value..."
- **Example**: Koko Eating Bananas. কোকো যদি স্পিড ২ এ খায়, সে সব শেষ করতে পারবে না (`False`)। স্পিড ৩ তেও পারবে না (`False`)। কিন্তু স্পিড ৪ এ পারবে (`True`)। তাহলে স্পিড ৫, ৬, ১০০ তেও চোখ বন্ধ করে সে পারবে (`True`)।
- **Goal**: আমাদের বের করতে হবে প্রথম `True` কোথায় আছে (প্রথম T)।
- **Logic**:
  - `if (isValid(mid) == true)`: এটি একটি সম্ভাব্য উত্তর। কিন্তু আমরা আরো ছোট উত্তর খুঁজতে বামে যাব। `high = mid - 1`।
  - `if (isValid(mid) == false)`: এই স্পিডে হবে না। আরো বড় স্পিড লাগবে। ডানে যাব। `low = mid + 1`।

### Pattern 2: T T T T F F F F (True to False)
- **Problem Type**: "Find the MAXIMUM value..."
- **Example**: Aggressive Cows (গরুগুলোকে এমনভাবে বসাও যেন তাদের মধ্যে মিনিমাম দূরত্ব ম্যাক্সিমাম হয়)। 
  - দূরত্ব ১ রাখা সম্ভব (`True`)। দূরত্ব ২ রাখা সম্ভব (`True`)। দূরত্ব ৩ সম্ভব (`True`)। কিন্তু দূরত্ব ৪ রাখা সম্ভব নয় (`False`)। তাহলে ৫, ৬ দূরত্ব রাখাও সম্ভব নয় (`False`)।
- **Goal**: আমাদের বের করতে হবে শেষ `True` কোথায় আছে (শেষ T)।
- **Logic**:
  - `if (isValid(mid) == true)`: এটি একটি সম্ভাব্য উত্তর। কিন্তু আমরা আরো বড় উত্তর খুঁজতে ডানে যাব। `low = mid + 1`।
  - `if (isValid(mid) == false)`: এত বড় দূরত্ব সম্ভব নয়। দূরত্ব কমাতে হবে। বামে যাব। `high = mid - 1`।

## Why do Software Company Interviewers care about this?
অনেক ক্যান্ডিডেট Binary Search on Answer এর কোড মুখস্ত করে যায় এবং বুঝতে পারে না কখন `low = mid + 1` আর কখন `high = mid - 1` লিখতে হবে।
যদি আপনি ইন্টারভিউয়ারের সামনে এই F F F T T T প্যাটার্নটি ড্র (Draw) করে বলেন, "Since it's an F F F T T pattern and I need the minimum, I will move left when it's True", তাহলে ইন্টারভিউয়ার বুঝবে আপনার ফাউন্ডেশন কতটা শক্ত!
