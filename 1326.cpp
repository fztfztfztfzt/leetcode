class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        vector<int> dp(n+1,INT_MAX-1);
        dp[0] = 0;
        for(int i=0;i<ranges.size();++i){
            int left = max(0, i-ranges[i]);
            int right = min(n, i+ranges[i]);
            for(int j = left;j<=right;++j){
                dp[j] = min(dp[j],dp[left]+1);
            }
        }
        if(dp[n]==INT_MAX-1) return -1;
        return dp[n];
    }
};
