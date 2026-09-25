package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 860. Lemonade Change
 * Category: Easy (Greedy)
 */
public class lemonade_change {

    /**
     * Approach: Greedy (Keep larger bills for future change)
     * When change for $20 is needed, prioritize giving $10 + $5 over $5 + $5 + $5.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
