/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;

class Solution {
    private static int binarySearch(int[] sub, int num, int length) {
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
    
        return left;
    }

    public static int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] sub= new int[n];
        int subLen= 0;

        for(int num: nums){
            int pos= binarySearch(sub, num, subLen);

            if(pos == subLen){
                sub[subLen++]= num;
            }
            else{
                sub[pos] = num;
            }
        }

        return subLen;
    }        
    
    
    
}
// @lc code=end

