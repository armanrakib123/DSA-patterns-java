public class divide_two_integers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int res = 0;
        
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
    public static void main(String[] args) {
        divide_two_integers dti = new divide_two_integers();
        int dividend = 10, divisor = 3;
        System.out.println("Result of " + dividend + " / " + divisor + ": " + dti.divide(dividend, divisor));
    }
}















//Problem explanation bangla:
//এই প্রোগ্রামটি দুটি পূর্ণসংখ্যা (dividend এবং divisor) কে ভাগ করে তাদের ভাগফল নির্ণয় করে।
//প্রথমে, আমরা কিছু edge case চেক করি, যেমন যখন dividend হল Integer.MIN_VALUE এবং divisor হল -1, তখন ফলাফল Integer.MAX_VALUE হবে কারণ এটি overflow ঘটায়।  
//তারপর, আমরা dividend এবং divisor এর absolute value নিয়ে কাজ করি যাতে division সহজ হয়।
//আমরা একটি while loop ব্যবহার করি যা চলতে থাকে যতক্ষণ না dividend (dvd) divisor (dvs) থেকে বড় বা সমান থাকে।
//এই loop এর ভিতরে, আমরা একটি temp variable ব্যবহার করি যা divisor এর value কে left shift করে বাড়ায় যতক্ষণ না temp এর value dividend থেকে বড় হয়ে যায়।
//এইভাবে আমরা divisor এর গুণিতকগুলোকে দ্রুত বাড়াতে পারি।
//প্রতিবার যখন temp divisor এর গুণিতক হয়ে যায়, তখন আমরা dividend থেকে temp কে বিয়োগ করি এবং ফলাফল (res) এ multiple যোগ করি।
//শেষে, আমরা চেক করি যে dividend এবং divisor একই সাইন আছে কিনা, এবং সেই অনুযায়ী ফলাফলকে positive বা negative করে return করি। 

//Example:
//Input: dividend = 10, divisor = 3
//Output: 3 (10 / 3 = 3.333... so we return the integer part which is 3)   