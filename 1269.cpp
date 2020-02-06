class Solution {
public:
    int numWays(int steps, int arrLen) {
        int l = min(steps, arrLen);
        const int M = 1000000007;
        vector<vector<long long>> dp(2,vector<long long>(l,0));
        dp[0][0] = 1;
        for(int s=1;s<steps;++s){
            dp[s&1][0] = (dp[(s-1)&1][0]+dp[(s-1)&1][1])%M;
            for(int j=1;j<l-1;++j){
                dp[s&1][j] = (dp[(s-1)&1][j-1]+dp[(s-1)&1][j]+dp[(s-1)&1][j+1])%M;
            }
            dp[s&1][l-1] = (dp[(s-1)&1][l-1]+dp[(s-1)&1][l-2])%M;
        }
        return (dp[(steps-1)&1][0]+dp[(steps-1)&1][1])%M;
    }
};
