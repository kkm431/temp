/*
 * @lc app=leetcode id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 */

// @lc code=start


class Solution {

    private int solve(int n, Map<Integer, Integer> memo) {
        if (n == 3) {
            return 5; // Base case for n = 3
        }
        if (n == 1) {
            return 1; // Base case for n = 1
        }
        if (n == 2) {
            return 2; // Base case for n = 2
        }

        if (memo.containsKey(n)) {
            return memo.get(n); // Return memoized result if already computed
        }

        // Recurrence relation
        int ans = (2 * solve(n - 1, memo) + solve(n - 3, memo)) % 1000000007;
        memo.put(n, ans); // Memoize the result for future use
        return ans;
    }

    public int numTilings(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return solve(n, memo); // Return the result for the full board size n
    }
}

// @lc code=end

