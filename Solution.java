/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start

public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n= tops.length;

        int[] topCnt= new int[7];
        int[] bottomCnt= new int[7];
        int[] same= new int[7];

        for(int i=0; i<n; i++){
            topCnt[tops[i]]++;
            bottomCnt[bottoms[i]]++;

            if(tops[i] == bottoms[i]){
                same[tops[i]]++;
            }
        }

        int ans= Integer.MAX_VALUE;
        //Find minimum swap either to top of bottom
        for(int i=1; i<7; i++){
            if(topCnt[i] + bottomCnt[i] - same[i] >= n){
                int swap= Math.min(topCnt[i], bottomCnt[i]) - same[i];
                ans= Math.min(swap, ans);
                
            }
        }

        return ans == Integer.MAX_VALUE? -1: ans;
    }

}
// @lc code=end

