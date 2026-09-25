class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class _2_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      
            fast = fast.next.next; 

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _2_LinkedListCycle solution = new _2_LinkedListCycle();
        
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeMinus4 = new ListNode(-4);
        
        head.next = node2;
        node2.next = node0;
        node0.next = nodeMinus4;
        nodeMinus4.next = node2;
        
        boolean result = solution.hasCycle(head);
        System.out.println("Has Cycle? " + result); 
    }
}











/**
 * 🎯 Problem 1: Linked List Cycle (LeetCode 141)
 * লেভেল: Easy
 * 
 * প্রশ্ন: আপনাকে একটি singly linked list এর head দেওয়া হবে। আপনাকে বলতে হবে এই লিস্টের মধ্যে কোনো সাইকেল (Cycle/Loop) আছে কিনা।
 * সাইকেল থাকার অর্থ হলো, লিস্টের কোনো একটি নোডের `next` পয়েন্টার যদি পেছনের কোনো নোডকে পয়েন্ট করে থাকে, 
 * তবে ট্রাভার্স করার সময় সেটি একটি অসীম লুপে (Infinite loop) পড়ে যাবে।
 * 
 * 💡 Brute Force Approach:
 * একটি HashSet ব্যবহার করা। প্রতিটি নোডে যাওয়ার সময় সেটি সেটে সেভ করে রাখা। 
 * যদি কোনো নোড আগে থেকেই সেটে থাকে, তার মানে সাইকেল আছে।
 * Time Complexity: O(N)
 * Space Complexity: O(N) (সেটের জন্য এক্সট্রা মেমোরি)
 * 
 * 🚀 Optimal Approach (Fast & Slow Pointers / Floyd's Cycle Finding Algorithm):
 * আমরা O(1) স্পেসে এটি সলভ করব।
 * দুটি পয়েন্টার নেব: slow (প্রতি স্টেপে ১ ঘর যাবে) এবং fast (প্রতি স্টেপে ২ ঘর যাবে)।
 * যদি লিস্টে কোনো সাইকেল থাকে, তবে দ্রুতগামী পয়েন্টার (fast) একসময় লুপের ভেতরে ঘুরতে ঘুরতে 
 * ধীরগামী পয়েন্টারকে (slow) পেছন থেকে এসে ধরে ফেলবে।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */