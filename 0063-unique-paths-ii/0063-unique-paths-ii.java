class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If starting cell or ending cell has an obstacle, no path exists
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1; // Base case: starting point

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // Obstacle blocks any path to/through this cell
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // dp[j] (from top) + dp[j-1] (from left)
                }
            }
        }

        return dp[n - 1];
    }
}