public class single_number_ii {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                if (((n >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        single_number_ii sn2 = new single_number_ii();
        int[] nums = {2, 2, 3, 2};
        System.out.println("The single number is: " + sn2.singleNumber(nums));
    }
}
