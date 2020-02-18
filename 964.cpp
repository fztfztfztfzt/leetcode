class Solution {
public:
    int leastOpsExpressTarget(int x, int target) {
        int a[30];
        memset(a,0,sizeof(a));
        int t = target;
        int n = 0;
        while(t>0){
            a[n++] = t%x;
            t/=x;
        }
        int dp[30][2];
        dp[0][0] = 2*a[0];
        dp[0][1] = 2*abs(a[0]-x);
        for(int i=1;i<=n;i++){
            dp[i][0] = min(dp[i-1][0]+a[i]*i,dp[i-1][1]+(a[i]+1)*i);
            dp[i][1] = min(dp[i-1][0]+abs(a[i]-x)*i,dp[i-1][1]+abs(a[i]+1-x)*i);
        }
        return dp[n][0]-1;
    }
};
