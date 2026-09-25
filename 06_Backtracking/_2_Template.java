/**
 * Backtracking Generic Template 
 * মূলমন্ত্র: Choose -> Explore -> Unchoose
 */



import java.util.ArrayList;
import java.util.List;

public class _2_Template {

    public List<List<Integer>> backtrackTemplate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, int start) {
        
        // ১. Goal (লক্ষ্য / Base Case)
        // কখন আমরা থামব এবং currentList কে result এ যোগ করব?
        /*
        if (currentList.size() == targetSize বা নির্দিষ্ট কন্ডিশন মেলে) {
            // জাভাতে Object রেফারেন্স হিসেবে পাস হয়, তাই currentList এর একটি নতুন কপি বানিয়ে যোগ করতে হয়
            result.add(new ArrayList<>(currentList));
            return;
        }
        */

        // ২. Choices (আমাদের কাছে কী কী অপশন আছে)
        for (int i = start; i < nums.length; i++) {
            
            // (Optional) Constraints: যদি কোনো অপশন ভ্যালিড না হয়, তবে স্কিপ (continue) করুন
            /*
            if (!isValid(nums[i])) {
                continue;
            }
            */

            // ৩. CHOOSE (পছন্দ করা)
            currentList.add(nums[i]);

            // ৪. EXPLORE (রিকার্সন কল করে গভীরে যাওয়া)
            // Permutation এর ক্ষেত্রে start এর বদলে 0 পাস করতে হতে পারে, 
            // Subset/Combination এর ক্ষেত্রে i + 1 পাস করতে হয়
            backtrack(result, currentList, nums, i + 1);

            // ৫. UN-CHOOSE / BACKTRACK (পিছিয়ে আসা)
            // রিকার্সন থেকে ফেরার পর শেষের ইলিমেন্টটি মুছে ফেলা যেন লুপের পরের অপশন ট্রাই করা যায়
            currentList.remove(currentList.size() - 1);
        }
    }
}
