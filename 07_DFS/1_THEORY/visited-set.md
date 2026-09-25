# Visited Set (ভিজিটেড সেট)

## Why do we need it? (কেন এটি প্রয়োজন?)
DFS বা যেকোনো গ্রাফ ট্রাভার্সালে সবচেয়ে বড় ভয় হলো **Infinite Loop** বা সাইকেল (Cycle)। 
ধরুন নোড A থেকে নোড B-তে যাওয়া যায়, আবার B থেকে A-তে আসা যায়। আপনি যদি কোনো ট্র্যাকিং না রাখেন, তবে অ্যালগরিদমটি A -> B -> A -> B... এভাবে চিরকাল ঘুরতে থাকবে এবং আপনার পিসি বা সার্ভার ক্র্যাশ করবে (Stack Overflow)।

## How it works?
আমরা একটি মেমরি লোকেশন রাখি যেখানে আমরা লিখে রাখি যে কোন কোন নোডে আমরা অলরেডি ঘুরে এসেছি। 
১. **Boolean Array:** যদি নোডগুলো ০ থেকে N পর্যন্ত নম্বর দেওয়া থাকে, তবে `boolean[] visited = new boolean[N]` ব্যবহার করা সবচেয়ে ফাস্ট।
২. **HashSet:** যদি নোডগুলো অবজেক্ট হয় বা নম্বরগুলো অনেক বড় হয়, তবে `HashSet<Integer> visited = new HashSet<>()` ব্যবহার করা হয়।

## The DFS Flow with Visited Set
```java
void dfs(int node, boolean[] visited) {
    // ১. চেক করো এই নোডে আগে এসেছি কি না
    if (visited[node]) return;
    
    // ২. মার্ক করো যে এই নোডে এখন আসলাম
    visited[node] = true;
    
    // ৩. প্রতিবেশীদের কাছে যাও
    for (int neighbor : adj[node]) {
        dfs(neighbor, visited);
    }
}
```

## Backtracking vs Graph DFS (Visited handling)
- **Graph DFS:** একবার `visited[node] = true` করলে সাধারণত আর `false` করা হয় না কারণ আমরা চাই প্রতিটি নোড একবারই ভিজিট করতে।
- **Backtracking (Paths):** এখানে আমরা একই নোড অন্য একটি রাস্তা দিয়ে পুনরায় ভিজিট করতে চাই। তাই কাজ শেষে `visited[node] = false` করে দেওয়া হয়। একে বলে "Unmarking"।

ভিজিটেড সেট সঠিকভাবে হ্যান্ডেল করা একজন প্রফেশনাল প্রোগ্রামারের অন্যতম লক্ষণ। 🚫🔄🛡️
