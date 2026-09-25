public class EuclideanGCD {

    // রিকার্সিভ পদ্ধতি
    public int gcdRecursive(int a, int b) {
        if (b == 0) return a;
        return gcdRecursive(b, a % b);
    }

    // ইটারেটিভ পদ্ধতি
    public int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        EuclideanGCD gcdCalc = new EuclideanGCD();
        int a = 48, b = 18;
        System.out.println("GCD of " + a + " and " + b + " (Recursive): " + gcdCalc.gcdRecursive(a, b));
        System.out.println("GCD of " + a + " and " + b + " (Iterative): " + gcdCalc.gcdIterative(a, b));
    }
}



















//Problem explanation bangla:
/**
 * প্রশ্ন: দুটি সংখ্যার সর্বোচ্চ সাধারণ বিভাজক (GCD) বের করো।
 * 
 * 💡 লজিক:
 * Euclidean Algorithm ব্যবহার করে GCD নির্ণয় করা হয়। 
 * GCD(a, b) = GCD(b, a % b) যতক্ষণ না b শূন্য হয়। 
 * যখন b শূন্য হয়, তখন a হল GCD।
 */
//এই প্রোগ্রামটি দুটি integer (a এবং b) কে ইনপুট হিসেবে নিয়ে তাদের GCD নির্ণয় করে।
//আমরা দুটি পদ্ধতি ব্যবহার করেছি: একটি রিকার্সিভ এবং একটি ইটারেটিভ।
//রিকার্সিভ পদ্ধতিতে, আমরা একটি base case চেক করি যেখানে b শূন্য হলে a return করি। অন্যথায়, আমরা GCD নির্ণয় করতে b এবং a % b কে recursive call করি।
//ইটারেটিভ পদ্ধতিতে, আমরা একটি while loop ব্যবহার করি যা চলতে থাকে যতক্ষণ না b শূন্য হয়। এই loop এর ভিতরে, আমরা b কে temp variable এ রাখি, b কে a % b দিয়ে আপডেট করি, এবং a কে temp দিয়ে আপডেট করি।
//শেষে, আমরা a return করি যা GCD হবে।

//Example:
//Input: a = 48, b = 18
//Output: 6 (GCD of 48 and 18 is 6)