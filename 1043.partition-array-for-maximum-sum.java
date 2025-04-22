/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int[] arr, int k, int idx, HashMap<Integer, Integer> memo) {
        // Your logic here
        if(idx >= arr.length){
            return 0;
        }

        if(memo.containsKey(idx)){
            return memo.get(idx);
        }

        int maxElement= 0, sum=0;
        
        for(int j=0; j<k && (idx + j < arr.length); j++){
            maxElement= Math.max(maxElement, arr[idx + j] );
            int currSum= (j+1) * maxElement + solve(arr, k, idx + j +1, memo);
            sum= Math.max(currSum, sum);
            
        }

        memo.put(idx, sum);
        return sum;
        
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return solve(arr, k, 0, memo);
    }
}
// @lc code=end

