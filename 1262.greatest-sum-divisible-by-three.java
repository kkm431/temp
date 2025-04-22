/*
 * @lc app=leetcode id=1262 lang=java
 *
 * [1262] Greatest Sum Divisible by Three
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] rem = new int[3]; // dp[i] stores the maximum sum with remainder i
        Arrays.fill(rem, 0); // Initialize dp array
        
        for (int num : nums) {
            int[] temp = rem.clone(); // Clone to prevent modifying in-place
            for (int sum : temp) {
                int newSum = sum + num;
                rem[newSum % 3] = Math.max(rem[newSum % 3], newSum);
            }
        }

        return rem[0]; // Maximum sum that is divisible by 3
    }
    
    

}
// @lc code=end

