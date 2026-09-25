package _19_LinkedList;

import COMMON.ListNode;

/**
 * Dummy Node Pattern Example
 * LeetCode 21: Merge Two Sorted Lists (Easy)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * দুটি সর্টেড Linked List দেওয়া আছে। তাদেরকে মার্জ করে একটি 
 * নতুন সর্টেড Linked List তৈরি করতে হবে।
 * 
 * এপ্রোচ (Dummy Node):
 * ১. যেহেতু নতুন লিস্টের হেড কোনটি হবে (list1 এর প্রথমটি নাকি list2 এর প্রথমটি) তা আমরা জানি না, 
 *    তাই একটি Dummy Node তৈরি করে নেওয়া সবচেয়ে ভালো।
 * ২. একটি current পয়েন্টার দিয়ে Dummy Node থেকে শুরু করব।
 * ৩. list1 এবং list2 এর মধ্যে যার ভ্যালু ছোট, current.next কে তার দিকে পয়েন্ট করব 
 *    এবং সেই লিস্টের পয়েন্টার একঘর সামনে বাড়াব।
 * ৪. যেকোনো একটি লিস্ট শেষ হয়ে গেলে, অন্য লিস্টের বাকি অংশটুকু current.next এ জুড়ে দেব।
 * ৫. শেষে dummy.next রিটার্ন করব (কারণ dummy.next হলো আমাদের আসল নতুন হেড)।
 * 
 * Time Complexity: O(N + M)
 * Space Complexity: O(1) - (নতুন কোনো নোড তৈরি করা হয়নি, শুধু পয়েন্টার চেঞ্জ করা হয়েছে)।
 */
public class MergeLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // ১. Dummy Node তৈরি
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // ২. দুটি লিস্টেই ইলিমেন্ট থাকা পর্যন্ত লুপ
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // ছোটটিকে জোড়া লাগানো
                list1 = list1.next;   // সামনে এগোনো
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // current কেও একঘর সামনে বাড়ানো
        }

        // ৩. যদি কোনো একটি লিস্ট বাকি থাকে, তবে সেটি জুড়ে দেওয়া
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // ৪. আসল হেড রিটার্ন করা
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeLists solution = new MergeLists();
        
        // list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        
        ListNode mergedHead = solution.mergeTwoLists(list1, list2);
        
        // প্রিন্ট করা: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
        System.out.print("Merged List: ");
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " -> ");
            mergedHead = mergedHead.next;
        }
        System.out.println("null");
    }
}
