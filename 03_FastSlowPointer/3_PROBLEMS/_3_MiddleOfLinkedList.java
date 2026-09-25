public class _3_MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;  
        }

        return slow;
    }

    public static void main(String[] args) {
        _3_MiddleOfLinkedList solution = new _3_MiddleOfLinkedList();
        
        // লিস্ট তৈরি করা হচ্ছে: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode middle = solution.middleNode(head);
        System.out.println("Middle Node Value: " + middle.val); 
        // Expected Output: 3
        
        // জোড় সংখ্যক নোডের জন্য চেক: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        head.next.next.next.next.next = new ListNode(6);
        ListNode middleEven = solution.middleNode(head);
        System.out.println("Middle Node Value (Even list): " + middleEven.val); 
        // Expected Output: 4
    }
}










/**
 * 🎯 Problem 2: Middle of the Linked List (LeetCode 876)
 * লেভেল: Easy
 * 
 * প্রশ্ন: একটি singly linked list এর head দেওয়া আছে। আপনাকে এর মাঝখানের (Middle) নোডটি রিটার্ন করতে হবে।
 * যদি লিস্টে জোড় সংখ্যক নোড থাকে (যেমন ৬টি), তবে দুটি মাঝখানের নোডের মধ্যে দ্বিতীয়টি (অর্থাৎ ৪র্থ নোড) রিটার্ন করতে হবে।
 * 
 * 💡 Brute Force Approach:
 * প্রথমে একবার পুরো লিস্ট ট্রাভার্স করে এর মোট দৈর্ঘ্য (N) বের করা।
 * এরপর আবার লিস্টের শুরু থেকে N/2 তম নোড পর্যন্ত ট্রাভার্স করা।
 * Time Complexity: O(N) + O(N/2) ≈ O(N)
 * Space Complexity: O(1)
 * সমস্যা: এখানে লিস্টটিকে দুইবার ট্রাভার্স (Two passes) করতে হচ্ছে।
 * 
 * 🚀 Optimal Approach (Fast & Slow Pointers / One Pass):
 * আমরা এক পাসেই (One pass) এটি সলভ করতে পারি ফাস্ট-স্লো পয়েন্টার দিয়ে।
 * slow পয়েন্টার ১ ঘর যাবে, fast পয়েন্টার ২ ঘর যাবে।
 * যখন fast পয়েন্টার লিস্টের একদম শেষে পৌঁছাবে, তখন slow পয়েন্টার ঠিক মাঝখানে থাকবে! 
 * (কারণ fast পয়েন্টার দ্বিগুণ স্পিডে গেছে, তাই slow অর্ধেক রাস্তা অতিক্রম করেছে)।
 * 
 * Time Complexity: O(N) (শুধুমাত্র একবার ট্রাভার্স করা হচ্ছে)
 * Space Complexity: O(1)
 */