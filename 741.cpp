class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> dp(n,vector<int>(n,-1));
        dp[0][0] = grid[0][0];
        for(int k=1;k<(n<<1)-1;++k){
            for(int x1=min(n-1,k);x1>=0&&x1>=k-n+1;--x1){
                for(int x2=min(n-1,k);x2>=0&&x2>=k-n+1;--x2){
                    int y1 = k-x1, y2 = k-x2;
                    if(grid[x1][y1]==-1||grid[x2][y2]==-1){
                        dp[x1][x2]=-1;
                        continue;
                    }
                    if(x1>0&&x2>0) dp[x1][x2] = max(dp[x1][x2],dp[x1-1][x2-1]);
                    if(x1>0&&y2>0) dp[x1][x2] = max(dp[x1][x2],dp[x1-1][x2]);
                    if(y1>0&&x2>0) dp[x1][x2] = max(dp[x1][x2],dp[x1][x2-1]);
                    if(dp[x1][x2]==-1) continue;
                    dp[x1][x2] += grid[x1][y1]+(x1==x2?0:grid[x2][y2]);
                }
            }
        }
        return max(dp[n-1][n-1],0);
    }
};