public class pow_x_n {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1;
        double currentProduct = x;
        
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                result = result * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        return result;
    }
    public static void main(String[] args) {
        pow_x_n pxn = new pow_x_n();
        double x = 2.0;
        int n = 10;
        System.out.println(x + " raised to the power of " + n + " is: " + pxn.myPow(x, n));
    }
}


















//Problem explanation bangla:
//এই প্রোগ্রামটি একটি double সংখ্যা (x) এবং একটি integer (n) কে ইনপুট হিসেবে নিয়ে x এর n তম পাওয়ার নির্ণয় করে।
//প্রথমে, আমরা n কে long টাইপে কাস্ট করি যাতে overflow এর সমস্যা থেকে বাঁচা যায়।
//যদি n নেগেটিভ হয়, তাহলে আমরা x কে 1/x করে ফেলি এবং n কে পজিটিভ করে ফেলি।
//তারপর, আমরা একটি result variable তৈরি করি যা শুরুতে 1 এ সেট করা হয় এবং একটি currentProduct variable যা শুরুতে x এর মান রাখে।
//আমরা একটি for loop ব্যবহার করি যা চলতে থাকে যতক্ষণ না i (যা N থেকে শুরু করে) 0 এর থেকে বড় থাকে।
//এই loop এর ভিতরে, আমরা চেক করি যদি i odd হয়, তাহলে result কে currentProduct এর সাথে গুণ করি।
//তারপর, আমরা currentProduct কে তার নিজের সাথে গুণ করি (currentProduct = currentProduct * currentProduct) যাতে আমরা x এর গুণিতকগুলোকে দ্রুত বাড়াতে পারি।
//শেষে, আমরা result কে return করি যা x এর n তম পাওয়ার হবে।   

//Example:
//Input: x = 2.0, n = 10
//Output: 1024.0 (2.0 raised to the power of 10 is 1024.0)
