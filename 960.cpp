class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        int n = A.size();
        int m = A[0].size();
        int res = 1;
        vector<int> dp(m+1,1);
        for(int i=0;i<m;++i){
            for(int k=0;k<i;++k){
                bool flag = true;
                for(int j=0;j<n;++j){
                    if(A[j][i]<A[j][k]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    dp[i] = max(dp[i],dp[k]+1);
                    res = max(res,dp[i]);
                }
            }
        }
        return m-res;
    }
};
