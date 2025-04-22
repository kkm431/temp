/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for(int i=1; i<=n; i++){
            res[i] = res[i & i -1] + 1;
        }

        return res;
    }
}
// @lc code=end

