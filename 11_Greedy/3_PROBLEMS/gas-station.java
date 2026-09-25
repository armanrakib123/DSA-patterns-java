package 24_GREEDY_PATTERN.TOP_10_PROBLEMS;

/**
 * LeetCode 134. Gas Station
 * Category: Medium (Greedy)
 * 
 * Problem: Find the starting gas station's index if you can travel around the circuit once 
 * in the clockwise direction, otherwise return -1.
 */
public class gas_station {

    /**
     * Approach: Greedy (Total cost vs Current tank)
     * 1. If total gas < total cost, it's impossible.
     * 2. If we run out of gas at station i, the start must be after i.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];
            
            // If tank is empty, we cannot have started before this index
            if (currentTank < 0) {
                start = i + 1;
                currentTank = 0;
            }
        }
        
        return (totalGas >= totalCost) ? start : -1;
    }

    /*
     * FAANG Interview Note:
     * The greedy insight is: if a car starts at A and cannot reach B, 
     * then it cannot reach B from any station between A and B.
     */
}
