/*
 * @lc app=leetcode id=1525 lang=java
 *
 * [1525] Number of Good Ways to Split a String
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int numSplits(String s) {
        int n= s.length();
        
        int[] sleft= new int[n];
        int[] sright= new int[n];

        HashSet<Character> leftSet= new HashSet<>();
        HashSet<Character> rightSet= new HashSet<>();

        //left side traversal to store total unique character from start to end till idx
        for(int i=0; i<n; i++){
            leftSet.add(s.charAt(i));
            sleft[i]= leftSet.size();
        }

        for (int i = n-1; i >= 0; i--) {
            rightSet.add(s.charAt(i));
            sright[i] = rightSet.size();
        }
        int res=0;

        for(int i=0; i< n-1; i++){
            if(sleft[i] == sright[i+1]){
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

