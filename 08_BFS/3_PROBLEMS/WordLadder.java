import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // যদি টার্গেট শব্দ পেয়ে যাই
                if (currentWord.equals(endWord)) return steps;

                // প্রতিটি পজিশনের ক্যারেক্টার বদলে নতুন শব্দ তৈরির চেষ্টা করো
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // ভিজিটেড হিসেবে মার্ক করতে রিমুভ করো
                        }
                    }
                    wordChars[j] = originalChar; // আগের অবস্থায় ফিরিয়ে নাও
                }
            }
            steps++;
        }

        return 0;
    }

    // টাইম কমপ্লেক্সিটি: O(N * M^2) - N হলো লিস্টের শব্দ সংখ্যা, M হলো শব্দের দৈর্ঘ্য।
    // স্পেস কমপ্লেক্সিটি: O(N * M) - wordSet এবং queue এর জন্য।
}

























/**
 * 🎯 Problem: Word Ladder (LeetCode 127)
 * লেভেল: Hard (Interview Favorite)
 * 
 * প্রশ্ন: একটি startWord এবং একটি endWord দেওয়া আছে। wordList থেকে শব্দ ব্যবহার করে 
 * এক ক্যারেক্টার পরিবর্তনের মাধ্যমে কত ধাপে endWord এ পৌঁছানো সম্ভব?
 * 
 * 💡 BFS ইন্টুইশন:
 * এটি মূলত একটি গ্রাফ প্রবলেম। প্রতিটি শব্দ একটি নোড এবং এক ক্যারেক্টার ডিফারেন্স 
 * থাকা শব্দগুলোর মধ্যে এজ আছে। যেহেতু আমরা শর্টেস্ট পাথ চাই, তাই BFS ব্যবহার করব।
 */