import java.util.ArrayList;
import java.util.List;

public class _4_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            
            if (currentList.contains(nums[i])) {
                continue; 
            }

            // ১. Choose
            currentList.add(nums[i]);

            // ২. Explore
            backtrack(result, currentList, nums);

            // ৩. Un-choose (Backtrack)
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        _4_Permutations solution = new _4_Permutations();
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> allPermutations = solution.permute(nums);
        System.out.println("All Permutations: " + allPermutations);
        // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}



















/**
 * Permutations Example
 * LeetCode 46: Permutations (Medium)
 * 
 * প্রবলেম স্টেটমেন্ট:
 * একটি integer array দেওয়া আছে। এর সবগুলো সম্ভাব্য বিন্যাস (Permutations) বের করতে হবে।
 * 
 * এপ্রোচ (Approach):
 * Subsets এর সাথে এর পার্থক্য হলো: 
 * ১. Permutation এ সবসময় সবগুলো ইলিমেন্ট থাকতে হবে (সাইজ সমান হতে হবে)।
 * ২. অর্ডার משנה (Order matters) - অর্থাৎ [1,2] এবং [2,1] আলাদা।
 * 
 * তাই এখানে আমরা `start` ইনডেক্স ব্যবহার করব না। বরং সবসময় 0 থেকে লুপ চালাব এবং 
 * চেক করব ইলিমেন্টটি আগে থেকেই লিস্টে আছে কি না।
 * 
 * Time Complexity: O(N * N!)
 * Space Complexity: O(N)
 */