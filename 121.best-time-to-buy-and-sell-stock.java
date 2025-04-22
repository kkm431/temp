/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int j= 1;
        int n = prices.length;

        int profit = 0;

        while(j < n){
            if(prices[i] < prices[j]){
                profit= Math.max(profit, prices[j] - prices[i]);
            }
            else{
                i = j;
            }
            j++;
        }
        return profit;
    }
}

// @lc code=end

