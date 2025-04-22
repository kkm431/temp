/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start

import java.util.HashMap;
/*
Steps to solve the "Best Time to Buy and Sell Stock with Cooldown" problem using recursion and memoization:

1. **Base Case:** When `idx` goes beyond the `prices` array, there are no more days to consider, so the profit is 0.

2. **Memoization Check:** Before doing any calculations, check if the result for the current state (`idx` and `canBuy`) is already stored in `memo`. If it is, return the stored value.

3. **Initialize Profit:** Initialize `profit` to the smallest possible integer value. This will be updated later.

4. **Handle Buying (`canBuy` is true):**
   - **Buy:** Calculate the profit if we buy at the current price (`-prices[idx]`) and recursively call `solve` for the next day (`idx + 1`) with `canBuy` set to `false` (because we just bought).
   - **Don't Buy:** Calculate the profit if we don't buy and recursively call `solve` for the next day (`idx + 1`) with `canBuy` remaining `true`.
   - Choose the maximum profit between buying and not buying.

5. **Handle Selling (`canBuy` is false):**
   - **Sell:** Calculate the profit if we sell at the current price (`prices[idx]`) and recursively call `solve` for the day after the next (`idx + 2`, skipping one day for the cooldown) with `canBuy` set to `true` (because we can buy after the cooldown).
   - **Don't Sell:** Calculate the profit if we don't sell and recursively call `solve` for the next day (`idx + 1`) with `canBuy` remaining `false`.
   - Choose the maximum profit between selling and not selling.

6. **Memoize and Return:** Store the calculated `profit` in the `memo` table for future use and return it.

7. **`maxProfit` Function:**
   - Handle edge cases: If `prices` is null or has less than 2 days, no profit can be made, so return 0.
   - Initialize the memoization table (`memo`).
   - Start the recursive process by calling `solve` with `idx = 0` and `canBuy = true` (we can initially buy).
*/

class Solution {
    private int solve(int[] prices, int idx, boolean canBuy, HashMap<Integer, Integer> memo){
        if(idx >= prices.length){
            return 0;
        }

        int key= idx *2 + (canBuy?0:1);

        if(memo.containsKey(key)){
            return memo.get(key);
        }


        int profit= Integer.MIN_VALUE;

        if(canBuy){
            int buy= -prices[idx] + solve(prices, idx + 1, false, memo);
            int noBuy= solve(prices, idx + 1, true, memo);
            profit= Math.max(buy, noBuy);
        }
        else{
            int sell = prices[idx] + solve(prices, idx + 2, true, memo);
            int noSell= solve(prices, idx + 1, false, memo);
            profit= Math.max(sell, noSell);
        }

        memo.put(key, profit);
        return profit;
    }

    public int maxProfit(int[] prices) {
        HashMap<Integer, Integer> memo= new HashMap<>();

        int n = prices.length;

        return solve(prices, 0, true, memo);
    }
}
// @lc code=end

