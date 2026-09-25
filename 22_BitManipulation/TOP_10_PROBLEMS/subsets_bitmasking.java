import java.util.ArrayList;
public class subsets_bitmasking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n
        
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // If j-th bit of i is set
                if (((i >> j) & 1) == 1) {
                    current.add(nums[j]);
                }
            }
            result.add(current);
        }
        return result;
    }
    public static void main(String[] args) {
        subsets_bitmasking sb = new subsets_bitmasking();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = sb.subsets(nums);
        System.out.println("Subsets: " + subsets);
    }
}
