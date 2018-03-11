class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}


public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[n];
        char[] ch = s.toCharArray();
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            int len = 0;
            for (int j = i - 1; j >= 0; j--) {
                int tmp = dp[j];
                if (ch[j] == ch[i]) {
                    dp[j] = len + 2;
                }
                len = Math.max(len,tmp);
            }
        }
        for (int i : dp){
           res = Math.max(res, i); 
        }

        return res;
    }
}