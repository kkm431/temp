/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start


import java.util.HashMap;

class Solution {
    private int solve(int[] coins, int amount, int idx, HashMap<String, Integer> memo) {
        if (idx < 0 || amount < 0) {
            return Integer.MAX_VALUE - 1;
        }
        if (amount == 0) {
            return 0;
        }

        String key = idx + "," + amount;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minCoins = Integer.MAX_VALUE - 1;

        if (coins[idx] <= amount) {
            int take = solve(coins, amount - coins[idx], idx, memo);
            int skip = solve(coins, amount, idx - 1, memo);

            minCoins = Math.min(take + 1, skip);
        } else {
            minCoins = solve(coins, amount, idx - 1, memo);
        }

        memo.put(key, minCoins);
        return minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        HashMap<String, Integer> memo = new HashMap<>();

        int result = solve(coins, amount, coins.length - 1, memo);

        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }
}

// @lc code=end

