/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    
    private int solve(int[] nums, int idx, HashMap<Integer, Integer> memo){
        if(idx < 0){
            return 0;
        }
        if(memo.containsKey(idx)){
            return memo.get(idx);
        }
        int rob = Math.max(nums[idx] + solve(nums, idx - 2, memo), solve(nums, idx - 1, memo));
        memo.put(idx, rob);
        return rob;
    }
    public int rob(int[] nums) {
        
        HashMap<Integer, Integer> memo= new HashMap<>();
        int n= nums.length;
        return Math.max(solve(nums, n-1, memo), solve(nums, n-2, memo));
    }
}
// @lc code=end

