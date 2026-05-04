class Solution {
    public boolean TargetSum(int[] nums, int target) {
        int n=nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,target,dp,nums);   
    }
    public boolean f(int ind,int target,int[][] dp,int[] nums){
        if(target==0) return true;
        if(ind==0) return (nums[ind]==target);
        if(dp[ind][target]!=-1) return dp[ind][target];
        boolean not_take=f(ind-1,target,dp,nums);
        boolean take=false;
        if(target>=nums[ind]){
            take=f(ind-1,target-nums[ind],dp,nums);
        }
        return dp[ind][target]=take || not_take;
    }
}
