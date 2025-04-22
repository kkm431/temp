/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort pairs based on the second element (right part of the pair)
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Initialize the length of the longest chain and the end of the last selected pair
        int longestChain = 0;
        int currentEnd = Integer.MIN_VALUE;
        
        // Iterate through the sorted pairs
        for (int[] pair : pairs) {
            // If the current pair's start is greater than the end of the last selected pair
            if (pair[0] > currentEnd) {
                // Include this pair in the chain
                longestChain++;
                // Update the currentEnd to the end of the current pair
                currentEnd = pair[1];
            }
        }
        
        return longestChain;
    }
}


// @lc code=end

