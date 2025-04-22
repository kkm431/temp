/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    private int binarySearch(int num) {
        long left = 1, right = num;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coin = mid * (mid + 1) / 2;
            if (coin <= num) {
                ans = mid;
                left = mid + 1; 
            } else {
                right = mid - 1; // Search left half
            }
        }
    
        // If num is not found, `left` is the correct insertion index
        return (int) ans;
    }
    public int arrangeCoins(int n) {
        return binarySearch(n);
    }
}
// @lc code=end

