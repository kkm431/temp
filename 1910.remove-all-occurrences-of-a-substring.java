/*
 * @lc app=leetcode id=1910 lang=java
 *
 * [1910] Remove All Occurrences of a Substring
 */

// @lc code=start
class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
// @lc code=end

