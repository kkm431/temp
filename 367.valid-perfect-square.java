/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        
        if (num == 1) {
            return true; // Special case for 1, which is a perfect square
        }
        int left = 1, right = num / 2;
    
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;

            if (sq == num) {
                return true; // If num is found, return the index
            } else if (sq < num ) {
                left = (int)mid + 1; // Search right half
            } else {
                right = (int)mid - 1; // Search left half
            }
        }
    
        return false;
    }
}
// @lc code=end

