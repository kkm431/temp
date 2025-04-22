/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> hash= new HashMap<>();

    public int climbStairs(int n) {
        if(n <2){
            return 1;
        }
        
        if(hash.containsKey(n)){
            return hash.get(n);
        }
        int ways = climbStairs(n - 1) + climbStairs(n - 2);
        hash.put(n, ways);

        return ways;
    }
}
// @lc code=end

