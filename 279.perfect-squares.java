/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int n, HashMap<Integer, Integer> memo){
        if(n ==0){
            return 0; // reached tgt sum, need 0 perfect squares
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int minSquare= Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) { // Iterate through possible perfect squares (i*i) up to n
            // Check if using the perfect square i*i leads to a better solution
            // We add 1 because we're using one more perfect square (i*i)
            minSquare = Math.min(minSquare, 1 + solve(n - (i * i), memo)); 
        }

        memo.put(n, minSquare);

        return minSquare;
    }

    public int numSquares(int n) {
        HashMap<Integer, Integer> memo= new HashMap<>();

        return solve(n, memo);
    }
}
// @lc code=end

