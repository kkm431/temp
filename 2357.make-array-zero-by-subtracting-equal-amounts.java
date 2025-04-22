/*
 * @lc app=leetcode id=2357 lang=java
 *
 * [2357] Make Array Zero by Subtracting Equal Amounts
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int minimumOperations(int[] nums) {
        HashSet set= new HashSet<>();

        for(int num: nums){
            if(num != 0){
                set.add(num);
            }
        }

        return set.size();
    }
}
// @lc code=end

