/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int res= 0;

        for(int[] box: boxTypes){
            //add all boxes in truck
            if(truckSize >= box[0]){
                truckSize -= box[0];
                res += (box[0] * box[1]);
            }
            else{
                res += truckSize * box[1];
                truckSize = 0;
                break;
                

            }
            
        }

        return res;
    }
}
// @lc code=end

