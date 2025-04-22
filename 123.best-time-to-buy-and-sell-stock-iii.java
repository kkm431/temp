/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start


class Solution {
    private int solve(int[] prices, int idx, int n, int transaction, boolean canBuy, int[][][] memo) {
        // Base case: No days left or no transactions left
        if (idx >= n || transaction == 0) {
            return 0;
        }

        // Check if the result is already computed
        if (memo[idx][transaction][canBuy ? 1 : 0] != -1) {
            return memo[idx][transaction][canBuy ? 1 : 0];
        }

        int profit = 0;

        if (canBuy) {
            // Option 1: Buy stock on the current day
            int buy = -prices[idx] + solve(prices, idx + 1, n, transaction, false, memo);
            // Option 2: Skip buying and move to the next day
            int noBuy = solve(prices, idx + 1, n, transaction, true, memo);
            profit = Math.max(buy, noBuy); // Max profit from either buying or skipping
        } else {
            // Option 1: Sell stock on the current day
            int sell = prices[idx] + solve(prices, idx + 1, n, transaction - 1, true, memo);
            // Option 2: Skip selling and move to the next day
            int noSell = solve(prices, idx + 1, n, transaction, false, memo);
            profit = Math.max(sell, noSell); // Max profit from either selling or skipping
        }

        // Memoize the result for this state
        memo[idx][transaction][canBuy ? 1 : 0] = profit;

        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Create a 3D memoization array
        int[][][] memo = new int[n][3][2];

        // Initialize memo array with -1 (meaning uncomputed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return solve(prices, 0, n, 2, true, memo); // Starting at day 0 with 2 transactions remaining and we can buy
    }
    
}
// @lc code=end

