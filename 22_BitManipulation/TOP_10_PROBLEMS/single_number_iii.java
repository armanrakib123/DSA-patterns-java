public class single_number_iii {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) diff ^= n;
        
        diff &= -diff;
        
        int[] result = {0, 0};
        for (int n : nums) {
            if ((n & diff) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        single_number_iii sn3 = new single_number_iii();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = sn3.singleNumber(nums);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
}
