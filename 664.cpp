class Solution {
public:
    int strangePrinter(string s) {
        int n = s.size();
        vector<vector<int>> memo(n, vector<int>(n, 0));
        return helper(s, 0, n-1, memo);
    }
private:
    int helper(string s, int start, int end, vector<vector<int>>& memo){
        if(start>end) return 0;
        if(start==end) return 1;
        if(memo[start][end]) return memo[start][end];
        memo[start][end] = helper(s, start+1, end, memo)+1;
        for(int i=start+1;i<=end;i++){
            if(s[i]==s[start])
                memo[start][end] = min(memo[start][end], helper(s, start+1, i-1, memo)+helper(s, i, end, memo));
        }
        return memo[start][end];
    }
};

class Solution {
public:
    int strangePrinter(string s) {
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for(int i=n-1;i>=0;--i){
            for(int j=i;j<n;j++){
                dp[i][j] = ((i==j)?1:(dp[i+1][j]+1));
                for(int k=i+1;k<=j;++k){
                    if(s[i]==s[k]){
                        dp[i][j] = min(dp[i][j],dp[i+1][k-1]+dp[k][j]);
                    }
                }
            }
        }
        return n==0?0:dp[0][n-1];
    }
};
