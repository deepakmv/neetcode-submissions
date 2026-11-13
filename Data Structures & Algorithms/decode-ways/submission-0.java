class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        char ch[] = s.toCharArray();
        int dp[] = new int[n+1];
        dp[n] = 1;

        if(n==0)
          return 0;
        
        
        for(int i=n-1; i>=0; i--) {

            if(ch[i] == '0') {
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i+1];
                if(i+1<n && 
                    (ch[i] == '1' || 
                    (ch[i] == '2' && ch[i+1] < '7')))          {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
