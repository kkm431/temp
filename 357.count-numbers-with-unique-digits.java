/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }

        int result=10;
        int unique= 9;
        int available_digits= 9;

        for(int i=2; i<=n; i++){
            unique *= available_digits;

            result += unique;

            available_digits--;
        }

        return result;
    }
}
// @lc code=end

