/*
 * @lc app=leetcode id=1509 lang=java
 *
 * [1509] Minimum Difference Between Largest and Smallest Value in Three Moves
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        int res= Integer.MAX_VALUE;
        int n= nums.length;

        if(n <= 4){
            return 0;
        }
        res= Math.min(res, nums[n-4] - nums[0]);
        res= Math.min(res, nums[n-3] - nums[1]);
        res= Math.min(res, nums[n-2] - nums[2]);
        res= Math.min(res, nums[n-1] - nums[3]);

        return res;
    }
}
// @lc code=end

