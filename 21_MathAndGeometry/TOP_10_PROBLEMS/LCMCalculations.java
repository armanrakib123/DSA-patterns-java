public class LCMCalculations {

    public long lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((long) a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        LCMCalculations lcmCalc = new LCMCalculations();
        int a = 12, b = 15;
        System.out.println("LCM of " + a + " and " + b + " is: " + lcmCalc.lcm(a, b));
    }
}





















//Problem explanation bangla:
/**
 * প্রশ্ন: দুটি সংখ্যার লসাগু (LCM) বের করো।
 * 
 * 💡 লজিক:
 * (a * b) = gcd(a, b) * lcm(a, b)
 * সুতরাং, lcm(a, b) = (a * b) / gcd(a, b)
 */
//এই প্রোগ্রামটি দুটি integer (a এবং b) কে ইনপুট হিসেবে নিয়ে তাদের LCM নির্ণয় করে।
//প্রথমে, আমরা চেক করি যদি a বা b এর মান 0 হয়, তাহলে LCM 0 হবে।
//তারপর, আমরা a এবং b এর absolute value নিয়ে কাজ করি যাতে LCM নির্ণয় সহজ হয়।
//আমরা একটি gcd method তৈরি করি যা Euclidean Algorithm ব্যবহার করে a এবং b এর GCD নির্ণয় করে।
//শেষে, আমরা LCM নির্ণয় করি (a * b) / gcd(a, b) এবং return করি।
//Example:
//Input: a = 12, b = 15
//Output: 60 (LCM of 12 and 15 is 60)