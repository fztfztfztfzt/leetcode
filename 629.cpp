class Solution {
public:
    int kInversePairs(int n, int k) {
        const int M = 1000000007;
        vector<vector<int>> dp(2,vector<int>(k+1,0));
        dp[0][0] = 1;
        for(int i=1;i<=n;++i){
            dp[i&1][0] = 1;
            for(int j=1;j<=k;++j){
                dp[i&1][j] = ((dp[i&1][j-1]+dp[(i-1)&1][j])%M-(i>j?0:(dp[(i-1)&1][j-i]-M)))%M;
            }
        }
        return dp[n&1][k];
    }
};
