/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;  //0 nodes = empty tree possible
        dp[1] = 1;  //1 nodes = sinlge tree possible
        
        for(int i=2; i <= n; i++){  //
            for(int j=1; j <= i; j++){  // which number is root node
                dp[i] += dp[j - 1] * dp[i - j]; //j- 1 left subtree total node
                //i - j right ubtree total nodes
            }
        }
        return dp[n];
    }
}
// @lc code=end

