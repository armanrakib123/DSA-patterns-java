
import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix Traversal LeetCode 54: Spiral Matrix (Medium) - Software
 * Company Favorite
 *
 * প্রবলেম স্টেটমেন্ট: একটি m x n ম্যাট্রিক্স দেওয়া আছে। ম্যাট্রিক্সের সবগুলো
 * ইলিমেন্টকে স্পাইরাল (Spiral বা প্যাঁচানো) অর্ডারে রিটার্ন করতে হবে।
 *
 * এপ্রোচ (Boundary Pointers): ১. স্পাইরাল প্রিন্ট করার জন্য আমাদের ৪টি
 * বাউন্ডারি ট্র্যাক করতে হবে: top (ওপর), bottom (নিচে), left (বাম), right
 * (ডান)। ২. ৪টি ধাপে আমরা লুপ চালাব: - Left থেকে Right: `top` বাউন্ডারিতে সব
 * ইলিমেন্ট নেব। এরপর `top++` করব। - Top থেকে Bottom: `right` বাউন্ডারিতে সব
 * ইলিমেন্ট নেব। এরপর `right--` করব। - Right থেকে Left: `bottom` বাউন্ডারিতে সব
 * ইলিমেন্ট নেব। এরপর `bottom--` করব। - Bottom থেকে Top: `left` বাউন্ডারিতে সব
 * ইলিমেন্ট নেব। এরপর `left++` করব। ৩. এই কাজগুলো একটি While লুপে চলতে থাকবে
 * যতক্ষণ না `top <= bottom` এবং `left <= right` থাকে।
 *
 * Time Complexity: O(M * N) - সবগুলো ইলিমেন্ট একবার করে ভিজিট করা হবে। Space
 * Complexity: O(1) - (রেজাল্ট লিস্ট বাদে)।
 */
public class _2_MatrixTraversal {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // ১. Left -> Right (Top Row)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Top বাউন্ডারি এক ধাপ নিচে নেমে এল

            // ২. Top -> Bottom (Right Column)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Right বাউন্ডারি এক ধাপ বামে সরে এল

            // চেক করা জরুরি: যদি ম্যাট্রিক্সে শুধু একটি রো বা কলাম থাকে, তবে ডাবল প্রিন্ট হতে পারে
            if (top <= bottom) {
                // ৩. Right -> Left (Bottom Row)
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Bottom বাউন্ডারি এক ধাপ ওপরে উঠে গেল
            }

            if (left <= right) {
                // ৪. Bottom -> Top (Left Column)
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Left বাউন্ডারি এক ধাপ ডানে সরে এল
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _2_MatrixTraversal solution = new _2_MatrixTraversal();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Spiral Order: " + solution.spiralOrder(matrix));
        // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
