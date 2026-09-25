public class number_of_1_bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        number_of_1_bits n1b = new number_of_1_bits();
        int n = 11; // Binary: 1011
        System.out.println("Number of 1 bits in " + n + ": " + n1b.hammingWeight(n));
    }
}
