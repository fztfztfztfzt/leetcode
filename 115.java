class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[2][t.length()+1];
        dp[0][0]=1;
        dp[1][0]=1;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i%2][j]=dp[(i-1)%2][j-1]+dp[(i-1)%2][j];
                }else{
                    dp[i%2][j]=dp[(i-1)%2][j];
                }
            }
        }
        return dp[s.length()%2][t.length()];
    }
}