class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i = 1;
        int k = 0;
        int n = s.length();
        int[] dp = new int[n+1];
        while (i < n) {
            if (s.charAt(i) == s.charAt(k)) dp[++i] = ++k;
            else if (k == 0) ++i;
            else k = dp[k];
        }
        return (dp[n]!=0)&&(dp[n] % (n - dp[n]) == 0);
    }
}