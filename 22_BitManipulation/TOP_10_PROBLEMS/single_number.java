public class single_number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
    public static void main(String[] args) {
        single_number sn = new single_number();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("The single number is: " + sn.singleNumber(nums));
    }
}