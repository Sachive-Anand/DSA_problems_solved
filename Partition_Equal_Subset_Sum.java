class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totSum=0;
        for(int num:nums){
            totSum+=num;
        }
        if(totSum%2 != 0) return false;
        int newTarget=totSum/2;
        boolean[][] dp = new boolean[n][newTarget + 1];
        //Boolean[][] dp = new Boolean[n][newTarget + 1];

        // return f(n-1,newTarget,dp,nums);   
        for(int i=0;i<n;i++){
            //Base Case1 1: target == 0 → true
            dp[i][0]=true;
        }
            //Base Case 2: ind == 0 → (nums[0] == target)
        if(nums[0]<=newTarget){
            dp[0][nums[0]]=true;
        }
        
        for(int i=1;i<n;i++){
            for(int t=1;t<newTarget+1;t++){
                boolean not_take=dp[i-1][t];
                boolean take=false;

                if(t>=nums[i]){
                    take=dp[i-1][t-nums[i]];
                }
                dp[i][t]=take || not_take;

            }
        }
        return dp[n-1][newTarget];

    }
    public boolean f(int ind,int target,Boolean[][] dp,int[] nums){
        if(target==0) return true;
        if(ind==0) return (nums[ind]==target);
        if(dp[ind][target]!=null) return dp[ind][target];
        boolean not_take=f(ind-1,target,dp,nums);
        boolean take=false;
        if(target>=nums[ind]){
            take=f(ind-1,target-nums[ind],dp,nums);
        }
        return dp[ind][target]=take || not_take;
    }
}
