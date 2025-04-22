/*
 * @lc app=leetcode id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int solve(int[][] books, int shelfWidth, int idx, HashMap<Integer, Integer> memo, int n) {
        // Your logic here
        if(idx >= n){
            return 0;
        }

        if(memo.containsKey(idx)){
            return memo.get(idx);
        }
        
        int width= 0;
        int minHeight= Integer.MAX_VALUE;
        int maxHeight= 0;

        for(int j=idx; j<n; j++){
            width += books[j][0];
            if(width > shelfWidth){
                break;
            }

            maxHeight= Math.max(maxHeight, books[j][1]);

            int totalHeight= maxHeight + solve(books, shelfWidth, j + 1, memo, n);

            minHeight= Math.min(minHeight, totalHeight);
            
        }

        memo.put(idx, minHeight);
        return minHeight;
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return solve(books, shelfWidth, 0, memo, books.length);

    }
}
// @lc code=end

