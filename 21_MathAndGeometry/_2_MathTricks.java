import java.util.Arrays;

/**
 * Math Tricks Implementation
 * 
 * এখানে আমরা তিনটি সবচেয়ে গুরুত্বপূর্ণ Math অ্যালগরিদম দেখব:
 * 1. Sieve of Eratosthenes (প্রাইম নাম্বার)
 * 2. Euclidean GCD (গসাগু)
 * 3. Fast Exponentiation (দ্রুত পাওয়ার)
 */
public class _2_MathTricks {

    /**
     * 1. Sieve of Eratosthenes
     * 0 থেকে n পর্যন্ত কতগুলো প্রাইম নাম্বার আছে তা কাউন্ট করে।
     * Time Complexity: O(N log(log N))
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // শুরুতে সবাইকে প্রাইম ধরে নিই
        isPrime[0] = false;
        isPrime[1] = false;

        // শুধু √n পর্যন্ত লুপ চালালেই হবে
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // i যদি প্রাইম হয়, তবে i এর সকল গুণিতক (Multiples) প্রাইম নয় (false)
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    /**
     * 2. Euclidean GCD (Greatest Common Divisor)
     * দুটি সংখ্যার গসাগু বের করে।
     * Time Complexity: O(log(min(a, b)))
     */
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b); // ম্যাজিক!
    }

    /**
     * 3. Fast Exponentiation (Binary Exponentiation)
     * x^n বের করে O(log N) সময়ে।
     * LeetCode 50: Pow(x, n)
     */
    public double myPow(double x, int n) {
        // n নেগেটিভ হলে 1/x করে নিই (Long নেওয়ার কারণ -2^31 কে পজিটিভ করলে ওভারফ্লো হয়)
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            // যদি N বিজোড় (Odd) হয়, তবে একবার গুণ করে নিই
            if ((N % 2) == 1) {
                result *= currentProduct;
            }
            // পাওয়ার অর্ধেক করে দিই এবং ভ্যালু স্কোয়ার (Square) করে দিই
            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        _2_MathTricks math = new _2_MathTricks();
        
        System.out.println("Primes before 10: " + math.countPrimes(10)); // Output: 4 (2, 3, 5, 7)
        System.out.println("GCD of 48 and 18: " + math.gcd(48, 18));   // Output: 6
        System.out.println("2^10: " + math.myPow(2.0, 10));            // Output: 1024.0
    }
}
