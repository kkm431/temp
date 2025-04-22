/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    private char binarySearch(char[] letters, int length, char target) {
        int left = 0, right = length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                pos= mid;
                right = mid - 1;
                
            } else {
                left = mid + 1; // Search left half
            }
        }
    
        // If num is not found, `left` is the correct insertion index
        return (pos != -1)?(letters[pos]): letters[0];
    }

    public char nextGreatestLetter(char[] letters, char target) {
        return binarySearch(letters, letters.length, target);
    }
}
// @lc code=end

