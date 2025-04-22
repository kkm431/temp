/*
 * @lc app=leetcode id=1218 lang=java
 *
 * [1218] Longest Arithmetic Subsequence of Given Difference
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        // Initialize the maximum length to 1 (a single element is a subsequence)
        int maxLen = 1;

        // Create a HashMap to store the length of the longest arithmetic subsequence
        // ending at each number encountered so far.  This is our DP table.
        HashMap<Integer, Integer> memo = new HashMap<>();

        // Iterate through the input array 'nums'
        for (int num : nums) {
            // Calculate the previous number that would form an arithmetic sequence
            // with the current number 'num' and the given 'difference'.
            int prev = num - difference;

            // Get the length of the longest arithmetic subsequence ending at 'prev'.
            // If 'prev' is not in the HashMap (we haven't seen it yet), 
            // getOrDefault returns 0. We then add 1 to include the current number 'num'.
            int length = memo.getOrDefault(prev, 0) + 1;

            // Store the calculated length in the HashMap.  This updates the DP table.
            // We store the length of the longest arithmetic subsequence ending at 'num'.
            memo.put(num, length);

            // Update the overall maximum length found so far.
            maxLen = Math.max(length, maxLen);
        }

        // Return the overall maximum length.
        return maxLen;
    }

}
// @lc code=end

