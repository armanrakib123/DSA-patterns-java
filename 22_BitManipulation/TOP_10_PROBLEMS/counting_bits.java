public class counting_bits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }




    
    public static void main(String[] args) {
        counting_bits cb = new counting_bits();
        int n = 5;
        int[] result = cb.countBits(n);
        System.out.println("Number of 1's in binary representation from 0 to " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.println(i + ": " + result[i]);
        }
    }
}
