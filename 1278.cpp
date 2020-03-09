class Solution {
public:
    int palindromePartition(string s, int k) {
        int n = s.size();
        vector<vector<int>> cost(n,vector<int>(n));
        for(int l=2;l<=n;++l)
            for(int i=0,j=l-1;j<n;++j,++i)
                cost[i][j] = (s[i]!=s[j])+cost[i+1][j-1];
        vector<vector<int>> dp(n,vector<int>(k+1,INT_MAX>>1));
        for(int i=0;i<n;++i){
            dp[i][1] = cost[0][i];
            for(int kk=2;kk<=k;++kk){
                for(int j=0;j<i;++j){
                    dp[i][kk] = min(dp[i][kk],dp[j][kk-1]+cost[j+1][i]);
                }
            }
        }
        return dp[n-1][k];
    }
};
