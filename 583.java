class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[2][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i%2][j] = (word1.charAt(i-1)==word2.charAt(j-1))?dp[(i-1)%2][j-1]+1:Math.max(dp[(i-1)%2][j],dp[i%2][j-1]);
            }
        }
        return n+m-2*dp[n%2][m];
    }
}