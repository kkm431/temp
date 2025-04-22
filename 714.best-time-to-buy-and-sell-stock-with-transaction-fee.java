/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int[] prices, int fee, int idx, Boolean canBuy, HashMap<String, Integer> memo){
        if(idx >= prices.length){
            return 0;
        }
        
        String key= idx + "-" + (canBuy?1:0);
        if(memo.containsKey(key)){
            return memo.get(key);
        }


        int bought= Integer.MIN_VALUE;
        int sold= Integer.MIN_VALUE;

        if(canBuy){
            int buy= -prices[idx] + solve(prices, fee, idx+1, false, memo);
            int noBuy= solve(prices, fee, idx+1, true, memo);
            bought= Math.max(buy, noBuy);
        }
        else{
            canBuy= !canBuy;
            int sell= prices[idx] - fee + solve(prices, fee, idx+1, true, memo);
            int noSell= solve(prices, fee, idx+1, false, memo);
            sold= Math.max(noSell, sell);
        }

        int res= Math.max(sold, bought);
        memo.put(key, res);
        return res;
    }
    public int maxProfit(int[] prices, int fee) {
        HashMap<String, Integer> memo= new HashMap<>();

        int n = prices.length;

        return solve(prices, fee, 0, true, memo);
    }
}
// @lc code=end

