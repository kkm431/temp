/*
 * @lc app=leetcode id=1736 lang=java
 *
 * [1736] Latest Time by Replacing Hidden Digits
 */

// @lc code=start
class Solution {
    public String maximumTime(String time) {
        char[] temp= time.toCharArray();

        if(temp[0] == '?'){
            if(temp[1] == '?'){
                temp[0] = '2';
            }
            else {
                temp[0] = (temp[1] > '3' ? '1': '2');
            }
        }
            

        if(temp[1] == '?')
            temp[1] = (temp[0] > '1' ? '3': '9');

        if(temp[3] == '?')
            temp[3] = '5';
        
        if(temp[4] == '?')
            temp[4] = '9';

        time= temp.toString();

        return new String(temp);
    }
}
// @lc code=end

