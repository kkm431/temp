/*
 * @lc app=leetcode id=935 lang=java
 *
 * [935] Knight Dialer
 */

// @lc code=start
class Solution {
    public int knightDialer(int n) {
        int[][] keypad= {
            {4,6}, {8,6}, {7,9}, {4,8}, {3,9,0}, {}, {1,7,0}, {2,6}, {1,3}, {2,4}
        };

        int[] ans= new int[10];

        //for n==1 -> length of number 
        for(int digit=0; digit<10; digit++){
            ans[digit]=1;
        }

        //for n>1

        for(int i=1; i<n; i++){
            int[] tempAns= new int[10];
            for(int digit=0; digit<10; digit++){
                for(int dial: keypad[digit]){
                    tempAns[dial] = (tempAns[dial] + ans[digit])%1000000007;
                }
            }
            ans= tempAns;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + ans[i]) %1000000007;
        }
        return result;
    }
}
// @lc code=end

