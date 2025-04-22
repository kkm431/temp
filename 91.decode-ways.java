/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(String s, int idx, HashMap<Integer, Integer> memo){
        //BAse Case
        if (s.length() == 0){
            return 0;
        }

        if(idx == s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        int ways= solve(s, idx + 1, memo);

        //Just incase if we encounter 0
        //then need to parse previsou number and check for relevance
        if(idx < s.length() - 1){
            int twoDigit = Integer.parseInt(s.substring(idx, idx + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += solve(s, idx + 2, memo);
            }
        }
        
        memo.put(idx, ways);
        return ways;
    }
    public int numDecodings(String s) {
        HashMap<Integer, Integer> memo= new HashMap<>();

        return solve(s, 0, memo);
    }
}
// @lc code=end

