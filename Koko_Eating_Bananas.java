class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans=0;
        int n=piles.length;
        if(n>h){
            return 0;
        }
        int minSpeed=1;
        int maxSpeed=-1;
        for(int i=0;i<=n-1;i++){
            maxSpeed=Math.max(maxSpeed,piles[i]);
        }
        while(minSpeed<=maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            int totTime=0;
            for(int i=0;i<=n-1;i++){
                totTime+=Math.ceil((double)piles[i]/mid);
            }
            //time takes is more than given time so speed up for that move the low
            if(totTime>h)minSpeed=mid+1;
            else{
                ans=mid;
                maxSpeed=mid-1;
            }

        }
        return ans;
        
    }
}
