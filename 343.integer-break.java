/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int n, HashMap<Integer, Integer> memo){
        if(n==0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int maxProduct= Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            maxProduct= Math.max(maxProduct, Math.max(i * (n-i), i * solve(n-i, memo)));
        }
        memo.put(n, maxProduct);
        return maxProduct;
    }
    public int integerBreak(int n) {
        HashMap<Integer, Integer> memo= new HashMap<>();

        return solve(n, memo);
    }
}
// @lc code=end

