/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    private int binarySearch(int num) {
        int left = 1, right = num;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1; // Search left half
            }
        }
    
        // If num is not found, `left` is the correct insertion index
        return left;
    }
    public int firstBadVersion(int n) {
        return binarySearch(n);
    }
}
// @lc code=end

