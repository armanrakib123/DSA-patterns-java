public class bit_manipulation_template {

    /**
     * Get the i-th bit of a number
     */
    public int getBit(int n, int i) {
        return (n & (1 << i)) != 0 ? 1 : 0;
    }

    /**
     * Set the i-th bit to 1
     */
    public int setBit(int n, int i) {
        return n | (1 << i);
    }

    /**
     * Clear the i-th bit (Set to 0)
     */
    public int clearBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }

    /**
     * Update i-th bit to a specific value (0 or 1)
     */
    public int updateBit(int n, int i, int bitValue) {
        int mask = ~(1 << i);
        return (n & mask) | (bitValue << i);
    }

    /**
     * Count total set bits (Hamming Weight)
     * Brian Kernighan's Algorithm: O(Number of set bits)
     */
    public int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        bit_manipulation_template bmp = new bit_manipulation_template();
        
        int n = 29; // Binary: 11101
        int i = 2;

        System.out.println("Get Bit at index " + i + ": " + bmp.getBit(n, i)); // Output: 1
        System.out.println("Set Bit at index " + i + ": " + bmp.setBit(n, i)); // Output: 29 (unchanged)
        System.out.println("Clear Bit at index " + i + ": " + bmp.clearBit(n, i)); // Output: 25 (Binary: 11001)
        System.out.println("Update Bit at index " + i + " to 0: " + bmp.updateBit(n, i, 0)); // Output: 25
        System.out.println("Count Set Bits in " + n + ": " + bmp.countSetBits(n)); // Output: 4
    }
}
