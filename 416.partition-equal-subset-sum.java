/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private boolean solve(int[] nums, int idx, int tgt, HashMap<String, Boolean> memo){
        if(idx <0 || tgt<0){
            return false;
        }
        
        if(tgt == 0){
            return true;
        }
        String key= idx +"," + tgt;

        if(memo.containsKey(key)){
            return memo.get(key);
        }


        Boolean ans= solve(nums, idx-1, tgt - nums[idx], memo) || solve(nums, idx - 1, tgt, memo);
        memo.put(key, ans);

        return ans;
    }
    public Boolean canPartition(int[] nums) {
        int n= nums.length;

        int sum= 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum%2 != 0){
            return false;
        }
        HashMap<String, Boolean> memo= new HashMap<>();
        return solve(nums, n - 1, sum / 2, memo);

    }
}
// @lc code=end

