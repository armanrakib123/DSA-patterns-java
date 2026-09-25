public class _1_OppositeDirectionTemplate {
    
    public int solve(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return 0; 
        }
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            
            int currentSum = arr[left] + arr[right]; 

            if (currentSum == target) {
                return 1; 
            } 
            else if (currentSum < target) {
                left++;
            } 
            else {
                right--;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        _1_OppositeDirectionTemplate solution = new _1_OppositeDirectionTemplate();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 10;
        int result = solution.solve(arr, target);
        System.out.println("Pair found: " + (result == 1 ? "Yes" : "No"));
    }
}

















/**
 * ==========================================
 * TWO POINTER PATTERN (OPPOSITE DIRECTION)
 * ==========================================
 * 
 * কখন ব্যবহার করবেন: 
 * যখন আপনার কাছে একটি Sorted Array বা String থাকে এবং আপনাকে কোনো Pair খুঁজতে হয়
 * অথবা কিছু রিভার্স (Reverse)/প্যালিনড্রোম (Palindrome) চেক করতে হয়।
 * 
 * লজিক:
 * - একটি পয়েন্টার (left) একদম শুরুতে বসবে।
 * - আরেকটি পয়েন্টার (right) একদম শেষে বসবে।
 * - একটি কন্ডিশন চেক করে আমরা হয় left কে ডানে সরাব (left++), নাহয় right কে বামে সরাব (right--)।
 * - লুপ চলবে যতক্ষণ না left পয়েন্টার right পয়েন্টারকে ক্রস করে (left < right)।
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */