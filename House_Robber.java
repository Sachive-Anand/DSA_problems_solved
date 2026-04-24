class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        // Arrays.fill(dp,-1);
        //return robMemo(nums.length-1,nums,dp);
        return robTab(dp,nums);
    }
    static int robMemo(int ind,int[] nums,int[] dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick=nums[ind] + robMemo(ind-2,nums,dp);
        int notPick=0+robMemo(ind-1,nums,dp);

        return dp[ind]=Math.max(pick,notPick);
    }
    static int robTab(int[] dp,int[] nums){
        dp[0] = nums[0];
        int take;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(i>1){
                take=nums[i]+dp[i-2];
            }
            else{
                take=nums[i];
            }
            int not_take=dp[i-1];
            dp[i]=Math.max(take,not_take);
        }
        return dp[n-1];

    }
}
