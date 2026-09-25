import java.util.Arrays;
public class count_primes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Prime numbers print
        System.out.print("Prime numbers less than " + n + ": ");
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println();
        return count;
    }

    public static void main(String[] args) {

        count_primes cp = new count_primes();

        int n = 10;

        int total = cp.countPrimes(n);

        System.out.println("Total Prime Count: " + total);
    }
}





















//Problem explanation bangla:
//এই প্রোগ্রামটি একটি নির্দিষ্ট সংখ্যার নিচে কতগুলো prime সংখ্যা আছে তা গণনা করে।
//prime সংখ্যা হলো এমন সংখ্যা যা শুধুমাত্র ১ এবং নিজেই দ্বারা বিভাজ্য।
//উদাহরণস্বরূপ, ২, ৩, ৫, ৭ ইত্যাদি prime সংখ্যা। এই প্রোগ্রামটি একটি boolean array ব্যবহার করে যা প্রতিটি index কে prime সংখ্যা হিসেবে চিহ্নিত করে।
//প্রথমে সব index কে true সেট করা হয় এবং ০ ও ১ কে false করা হয় কারণ তারা prime নয়।
//তারপর, ২ থেকে শুরু করে প্রতিটি prime সংখ্যার জন্য তার গুণিতকগুলোকে false করা হয়। 
//এই প্রক্রিয়া চলতে থাকে যতক্ষণ না আমরা n এর বর্গমূল পর্যন্ত পৌঁছে যাই।
//শেষে, array এর মধ্যে যতগুলো true আছে তা গণনা করে return করা হয়, যা prime সংখ্যার মোট সংখ্যা হবে।  

//Example:
//Input: n = 10
//Output: 4 (primes are 2, 3, 5, 7)