package _18_Trie;

/**
 * Trie Implementation
 * LeetCode 208: Implement Trie (Prefix Tree) (Medium)
 * 
 * প্রবলেম: একটি Trie ক্লাস ডিজাইন করতে হবে যেখানে insert, search, এবং startsWith মেথড থাকবে।
 * 
 * Time Complexity (সবগুলো মেথডের জন্য): O(L) - যেখানে L হলো শব্দের দৈর্ঘ্য (Length of the word)।
 * Space Complexity: O(N * L) - যেখানে N হলো শব্দের সংখ্যা এবং L হলো গড় দৈর্ঘ্য।
 */
public class TrieImplementation {

    private TrieNode root;

    public TrieImplementation() {
        // রুট নোডে কোনো ক্যারেক্টার থাকে না, এটি শুধু শুরু করার পয়েন্ট
        root = new TrieNode(); 
    }

    /**
     * Insert a word into the trie.
     */
    public void insert(String word) {
        TrieNode current = root;
        
        for (char ch : word.toCharArray()) {
            // যদি এই ক্যারেক্টার আগে থেকে না থাকে, তবে নতুন একটি নোড তৈরি করি
            if (!current.containsKey(ch)) {
                current.put(ch, new TrieNode());
            }
            // সামনের দিকে (নিচের লেভেলে) এগিয়ে যাই
            current = current.get(ch);
        }
        
        // লুপ শেষে আমরা শব্দের শেষ ক্যারেক্টারে আছি, তাই इसे End মার্ক করে দিই
        current.setEnd();
    }

    /**
     * Returns true if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        // নোডটি যদি null না হয় এবং সেখানে যদি কোনো শব্দ শেষ হয়ে থাকে, তবেই true
        return node != null && node.isEnd();
    }

    /**
     * Returns true if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        // নোডটি null না হলেই হলো, সেটি শেষ (End) হোক বা না হোক
        return node != null;
    }

    /**
     * Helper method: একটি স্ট্রিং/প্রিফিক্স শেষ হওয়া পর্যন্ত নোডটি খুঁজে বের করে
     */
    private TrieNode searchPrefix(String prefix) {
        TrieNode current = root;
        
        for (char ch : prefix.toCharArray()) {
            if (current.containsKey(ch)) {
                // ক্যারেক্টার থাকলে সামনে এগিয়ে যাই
                current = current.get(ch);
            } else {
                // ক্যারেক্টার না থাকলে তার মানে এমন কোনো শব্দ/প্রিফিক্স নেই
                return null;
            }
        }
        
        return current; // প্রিফিক্স এর শেষ নোডটি রিটার্ন করি
    }

    public static void main(String[] args) {
        TrieImplementation trie = new TrieImplementation();
        
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));   // return true
        System.out.println("Search 'app': " + trie.search("app"));       // return false (app নামে কোনো সম্পূর্ণ শব্দ নেই)
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // return true (app দিয়ে শুরু হওয়া শব্দ আছে)
        
        trie.insert("app");
        System.out.println("Search 'app' after insert: " + trie.search("app")); // return true
    }
}
