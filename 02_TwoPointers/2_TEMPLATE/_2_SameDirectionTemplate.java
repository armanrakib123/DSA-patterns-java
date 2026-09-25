public class _2_SameDirectionTemplate {
    
    public int solve(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int slow = 0; 
        
        for (int fast = 0; fast < arr.length; fast++) {
            
            if (arr[fast] != 0) { 
                
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                
                slow++;
            }
        }
        return slow; 
    }
    public static void main(String[] args) {
        _2_SameDirectionTemplate solution = new _2_SameDirectionTemplate();
        int[] arr = {0, 1, 0, 3, 12};
        int newLength = solution.solve(arr);
        System.out.println("New length after moving zeros: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}



























/**
 * ==========================================
 * TWO POINTER PATTERN (SAME DIRECTION / FAST & SLOW)
 * ==========================================
 * 
 * কখন ব্যবহার করবেন: 
 * যখন আপনাকে একই Array এর ওপর In-place মডিফিকেশন করতে হবে (যেমন duplicate রিমুভ করা)
 * অথবা Linked List এর Cycle/Middle element বের করতে হবে।
 * 
 * লজিক:
 * - দুটি পয়েন্টারই (slow এবং fast) সাধারণত শুরু থেকে (Index 0 বা 1) যাত্রা শুরু করে।
 * - Fast পয়েন্টারটি প্রতিটি লুপে এক ঘর করে সামনে আগায় (fast++) এবং ডাটা ভেরিফাই করে।
 * - যদি Fast পয়েন্টার এমন কোনো ডাটা পায় যা আমাদের দরকার (শর্ত পূরণ করে), 
 *   তবে সেটি Slow পয়েন্টারের জায়গায় বসিয়ে দেওয়া হয় এবং Slow পয়েন্টারকে এক ঘর বাড়ানো হয় (slow++)।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */