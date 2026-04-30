class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize with a large value
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Base case
        dp[0] = 0;

        // Build DP
        for (int x = 1; x <= amount; x++) {
            for (int coin : coins) {

                if (x >= coin && dp[x - coin] != Integer.MAX_VALUE) {
                    dp[x] = Math.min(dp[x], dp[x - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
