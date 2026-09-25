package _18_Trie;

/**
 * Trie Node Structure
 * 
 * এটি Trie এর প্রতিটি নোডের ব্লুপ্রিন্ট।
 */
public class TrieNode {
    
    // a-z পর্যন্ত ২৬টি ইংরেজি ছোট হাতের অক্ষরের জন্য Array (Reference/Links)
    // যদি ক্যারেক্টারগুলো শুধু a-z না হয়ে সব রকম হয়, তবে HashMap<Character, TrieNode> ব্যবহার করা ভালো।
    public TrieNode[] children;
    
    // এই নোডে এসে কোনো সম্পূর্ণ শব্দ শেষ হয়েছে কি না
    public boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // শুরুতে সব null থাকবে
        isEndOfWord = false;
    }

    /**
     * Helper Methods (ঐচ্ছিক, কিন্তু কোড ক্লিন রাখে)
     */
    
    // ক্যারেক্টারটি এই নোডের চিলড্রেনে আছে কি না
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    // নতুন ক্যারেক্টারের জন্য নোড তৈরি করা
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    // ক্যারেক্টারের নোডটি (Reference) নেওয়া
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    // শব্দ শেষ মার্ক করা
    public void setEnd() {
        isEndOfWord = true;
    }

    // শব্দ শেষ কি না চেক করা
    public boolean isEnd() {
        return isEndOfWord;
    }
}
