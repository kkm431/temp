/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    private int binarySearch(int[] sub, int num, int length) {
        int left = 0, right = length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sub[mid] == num) {
                return mid; // If num is found, return the index
            } else if (sub[mid] < num) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
    
        // If num is not found, `left` is the correct insertion index
        return left;
    }
    
    public int hIndex(int[] citations) {
        
    }
}
// @lc code=end

