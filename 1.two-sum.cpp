/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> num_map;  // Store the number and its index
        vector<int> result;

        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];
            if (num_map.find(complement) != num_map.end()) {
                result.push_back(num_map[complement]);  // index of the complement
                result.push_back(i);  // current index
                return result;
            }
            num_map[nums[i]] = i;  // Store the number and its index
        }
        return result;  // If no solution, this returns an empty vector
    }
};

// @lc code=end

