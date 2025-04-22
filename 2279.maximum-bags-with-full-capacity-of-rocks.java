/*
 * @lc app=leetcode id=2279 lang=java
 *
 * [2279] Maximum Bags With Full Capacity of Rocks
 */

// @lc code=start
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff= new int[capacity.length];

        for(int i=0; i<capacity.length; i++){
            diff[i]= capacity[i] - rocks[i];
        }

        Arrays.sort(diff);
        int res = 0;

        for(int i=0; i<capacity.length; i++){
            if(additionalRocks < diff[i]){
                diff[i] = additionalRocks - diff[i];
            }
            else{
                additionalRocks -= diff[i];
                diff[i] = 0;
                res++;
            }
            
            if(additionalRocks == 0){
                break;
            }
        }


        return res;
    }
}
// @lc code=end

