/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    private int solve(int[] cost, int n){
        if(n < 0){
            return 0;
        }
        if(n < 2){
            return cost[n];
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }


        int minCost= cost[n] + Math.min(solve(cost, n-1), solve(cost, n-2));
        memo.put(n, minCost);

        return minCost;
    }
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(cost, cost.length - 1), solve(cost, cost.length - 2));
    }
}
// @lc code=end

