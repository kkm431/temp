/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    

    public int deleteAndEarn(int[] nums) {
        int maxVal= 0;

        HashMap<Integer, Integer> sum = new HashMap<>();
        

        for(int i: nums){
            sum.put(i, sum.getOrDefault(i, 0) + i);
            maxVal= Math.max(maxVal, i);
            
        }

        int[] dp= new int[maxVal+1];

        dp[0]= 0;
        dp[1]= sum.getOrDefault(1, 0);

        for(int i=2; i<=maxVal; i++){
            dp[i]= Math.max(dp[i-1], dp[i-2] + sum.getOrDefault(i, 0));
        }

        return dp[maxVal];
    }
}

// @lc code=end

