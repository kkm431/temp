/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean solve(TreeNode left,TreeNode right) {
        // Your logic here
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && solve(left.left, right.right) && solve(left.right, right.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left, root.right);
    }
}
// @lc code=end

