/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int[] stones, int idx, int n,int sum, HashMap<String, Integer> memo, int subSetSum) {
        // Your logic here

        if(idx == n){
            return Math.abs(subSetSum*2 - sum);
        }

        String key= idx + "-" + subSetSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int take = solve(stones, idx + 1, n, sum, memo, subSetSum + stones[idx]);
        int skip = solve(stones, idx + 1, n, sum , memo, subSetSum);
        
        int ans= Math.min(take, skip);
        
        memo.put(key, ans);
        return ans;
    }
    public int lastStoneWeightII(int[] stones) {
        int n= stones.length;
        int sum =0;
        for( int i=0; i<n; i++){
            sum += stones[i];
        }

        HashMap<String, Integer> memo = new HashMap<>();
        
        return solve(stones, 0, n, sum, memo, 0);
    }
}
// @lc code=end

