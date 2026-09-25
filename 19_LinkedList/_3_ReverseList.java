package _19_LinkedList;

import COMMON.ListNode;

/**
 * Reverse Linked List Example
 * LeetCode 206: Reverse Linked List (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি Singly Linked List এর হেড (head) দেওয়া আছে। 
 * পুরো লিস্টটিকে উল্টে (Reverse) দিতে হবে এবং নতুন হেড রিটার্ন করতে হবে।
 * 
 * এপ্রোচ (Iterative - Multiple Pointers):
 * ১. ৩টি পয়েন্টার নেব: prev (আগের নোড), curr (বর্তমান নোড), nextTemp (পরের নোড)।
 * ২. শুরুতে prev = null এবং curr = head।
 * ৩. লুপের ভেতরে:
 *    - nextTemp = curr.next (পরের নোডটি হারানো এড়াতে সেভ করে রাখব)
 *    - curr.next = prev (আসল রিভার্সিং! অ্যারো উল্টে দিলাম)
 *    - prev = curr (prev কে একঘর সামনে আনলাম)
 *    - curr = nextTemp (curr কে একঘর সামনে আনলাম)
 * ৪. লুপ শেষে prev হবে আমাদের নতুন হেড!
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ReverseList {

    // Iterative Approach (সবচেয়ে বেশি ব্যবহৃত)
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // সেভ করা
            curr.next = prev;              // উল্টে দেওয়া
            prev = curr;                   // সামনে এগোনো
            curr = nextTemp;               // সামনে এগোনো
        }

        return prev;
    }

    // Recursive Approach (ইন্টারভিউতে জিজ্ঞেস করতে পারে)
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: যদি হেড null হয় বা শেষ নোডে পৌঁছে যাই
        if (head == null || head.next == null) {
            return head;
        }

        // রিকার্সন দিয়ে বাকি লিস্ট রিভার্স করে নতুন হেড নিয়ে আসা
        ListNode newHead = reverseListRecursive(head.next);

        // ফেরার পথে অ্যারো উল্টে দেওয়া
        // উদাহরণ: 1 -> 2 -> 3 (head=2)
        // head.next (3) এর next হবে 2 (অর্থাৎ 3 -> 2)
        head.next.next = head; 
        
        // আগের কানেকশন (2 -> 3) ভেঙে দেওয়া (যাতে সাইকেল না হয়)
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseList solution = new ReverseList();
        
        // লিস্ট তৈরি: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode reversedHead = solution.reverseListIterative(head);
        
        // প্রিন্ট করা: 5 -> 4 -> 3 -> 2 -> 1 -> null
        System.out.print("Reversed List: ");
        ListNode temp = reversedHead;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
