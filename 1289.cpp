class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& arr) {
        int top2[2][2] = {{0, -1}, {0, -1}};
        int n = arr[0].size();
        vector<int> dp(n,0);
        for(int i=0;i<arr.size();++i){
            for(int j=0;j<n;++j){
                if(j==top2[0][1]) dp[j]=top2[1][0]+arr[i][j];
                else dp[j]=top2[0][0]+arr[i][j];
            }
            top2[0][0] = INT_MAX;
            top2[1][0] = INT_MAX;
            //for(int j=0;j<n;++j) printf("%d ",dp[j]);
            //printf("\n");
            for(int j=0;j<n;++j){
                if(dp[j]<top2[0][0]){
                    top2[1][0] = top2[0][0];
                    top2[1][1] = top2[0][1];
                    top2[0][0] = dp[j];
                    top2[0][1] = j;
                }else if(dp[j]<top2[1][0]){
                    top2[1][0] = dp[j];
                    top2[1][1] = j;
                }
            }
        }
        return top2[0][0];
    }
};
