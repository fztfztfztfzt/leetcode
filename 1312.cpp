class Solution {
public:
    int minInsertions(string s) {
        int n = s.size();
        vector<int> dp(n,0);
        for(int start=n-2;start>=0;--start){
            int pre = 0;
            for(int end=start+1;end<n;++end){
                int tmp = dp[end];
                dp[end] = (s[start]==s[end]?pre:1+min(dp[end],dp[end-1]));
                pre = tmp;
            }
        }
        return dp[n-1];
    }
};
