class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
    
        for(int i=0;i<weights.length;i++){
            low=Math.max(weights[i],low);
            high+=weights[i];
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canShip(weights,days,mid)){
                ans=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return ans; 
    }
    public static boolean canShip(int[] weights,int days,int capacity){
        int dayUsed=1;
        int currLoad=0;
        for(int w:weights){
            if(currLoad+w>capacity){
                dayUsed++;
                currLoad=w;
            }else{
                currLoad+=w;
            }

        }
        return dayUsed<=days;

    }
}
