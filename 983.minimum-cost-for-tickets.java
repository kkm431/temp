/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start


class Solution {
    private int solve(int[] days, int[] cost, int idx, int n, HashMap<Integer, Integer> memo) {
        if (idx >= n) {
            return 0;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        // Buy a 1-day pass
        int cost1 = cost[0] + solve(days, cost, idx + 1, n, memo);

        // Buy a 7-day pass
        int nextIdx = idx;
        while (nextIdx < n && days[nextIdx] < days[idx] + 7) {
            nextIdx++;
        }
        int cost7 = cost[1] + solve(days, cost, nextIdx, n, memo);

        // Buy a 30-day pass
        nextIdx = idx;
        while (nextIdx < n && days[nextIdx] < days[idx] + 30) {
            nextIdx++;
        }
        int cost30 = cost[2] + solve(days, cost, nextIdx, n, memo);

        // Minimum of all three choices
        int ans = Math.min(cost1, Math.min(cost7, cost30));

        memo.put(idx, ans);
        return ans;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        HashMap<Integer, Integer> memo = new HashMap<>();
        return solve(days, costs, 0, n, memo);
    }
}

// @lc code=end

