import java.util.*;
public class math_template {

    public boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return isPrime;
    }

    /**
     * GCD (Greatest Common Divisor) - Euclidean Algorithm
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Fast Exponentiation (Binary Exponentiation)
     * Calculate (base^exp) % mod in O(log exp)
     */
    public long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    
    public static void main(String[] args) {
        math_template mt = new math_template();
        
        // Example usage of Sieve of Eratosthenes
        int n = 30;
        boolean[] primes = mt.sieve(n);
        System.out.println("Primes up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) System.out.print(i + " ");
        }
        System.out.println();

        // Example usage of GCD
        int a = 48, b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + mt.gcd(a, b));

        // Example usage of Fast Exponentiation
        long base = 2, exp = 10, mod = 1000;
        System.out.println(base + "^" + exp + " % " + mod + " is: " + mt.power(base, exp, mod));
    }
}
