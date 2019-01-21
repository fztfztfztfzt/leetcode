class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int res = 100000;
        int N = A.size();
        vector<int> dp(N);
        vector<int> tmp(N);
        for(int i=0;i<N;i++) dp[i]=A[N-1][i];
        for(int i=N-2;i>=0;i--){
            for(int j=0;j<N;j++){
                if(j==0) tmp[j] = A[i][j]+min(dp[0],dp[1]);
                else if(j==N-1) tmp[j] = A[i][j]+min(dp[N-1],dp[N-2]);
                else tmp[j] = A[i][j]+min(dp[j-1],dp[j],dp[j+1]);
            }
            dp.assign(tmp.begin(), tmp.end());
        }
        for(int i=0;i<N;i++){
            if(res>dp[i]) res = dp[i];
        }
        return res;
    }
private:
    int min(int a, int b){
        return (a > b ? b : a);
    }
    int min(int a, int b, int c){
        return (a > b ? (b > c ? c : b) : (a > c ? c : a));
    }
};
