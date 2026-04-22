class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int resLen=0;
        for(int i=0;i<s.length();i++){
            //odd length
            int l=i;
            int r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(resLen<r-l+1){
                    res=s.substring(l,r+1);
                    resLen=r-l+1;
                }
                //moving left
                l--;
                //moving right
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(resLen<r-l+1){
                    res=s.substring(l,r+1);
                    resLen=r-l+1;
                }
                //moving left
                l--;
                //moving right
                r++;
            }

        }
        return res;
        
    }
}
