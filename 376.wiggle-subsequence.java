/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int idx, boolean pos, int[] nums, HashMap<Integer, Integer> memo){
        if(idx == nums.length){
            return 0;

        }
        int take=0;
        int notTake=0;

        if((pos && nums[idx] > nums[idx - 1]) || (!pos && nums[idx] < nums[idx - 1])){
            take = 1 + solve(idx + 1, !pos, nums, memo);
        }
        else{
            notTake= solve(idx + 1, pos, nums, memo);
        }
        memo.put(idx, Math.max(take, notTake));
        return Math.max(take, notTake);
    }
    public int wiggleMaxLength(int[] nums) {
        HashMap<Integer, Integer> memo= new HashMap<>();

        return Math.max(solve(1, true, nums, memo), solve(1, false, nums, memo)) + 1;
    }
}
// @lc code=end

