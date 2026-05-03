class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp =new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,m-1,dp,obstacleGrid);
        
    }
    public int f(int i,int j,int[][] dp,int[][] obstacleGrid){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,dp,obstacleGrid);
        int down=f(i,j-1,dp,obstacleGrid);

        return dp[i][j]=up+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    int up=0;
                    int down=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) down=dp[i][j-1];
                    dp[i][j]=up+down;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
