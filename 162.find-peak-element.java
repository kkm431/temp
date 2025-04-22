/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    private int binarySearch(int[] num, int length) {
        int left = 0, right = length - 1;
        int idx= -1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (num[mid] < num[mid + 1] ) {
                left = mid + 1; // If num is found
            } else {
                right = mid ; // Search left half
            }
        }
        // If num is not found, `left` is the correct insertion index
        return left;
    }
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, nums.length);
    }
}
// @lc code=end

