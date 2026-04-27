class Solution {
    public int numDecodings(String s) {

       int n = s.length();
       int[] dp = new int[n + 1];

       dp[n] = 1; // base case

       for (int i = n - 1; i >= 0; i--) {

           if (s.charAt(i) == '0') {
               dp[i] = 0;
               continue;
           }

           // take one digit
           dp[i] = dp[i + 1];

           // take two digits
           if (i + 1 < n &&
               Integer.parseInt(s.substring(i, i + 2)) <= 26) {

               dp[i] += dp[i + 2];
           }
       }

       return dp[0];
   }

}
