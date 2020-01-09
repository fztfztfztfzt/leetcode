class Solution {
public:
    int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
        int n = arr1.size();
        sort(arr2.begin(),arr2.end());
        vector<vector<int>> dp(n,vector<int>(n+1,INT_MAX));
        dp[0][0] = arr1[0];
        dp[0][1] = arr2[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i+1;j++){
                if(arr1[i]>dp[i-1][j])
                    dp[i][j] = min(dp[i][j],arr1[i]);
                if(j>0){
                    if(dp[i-1][j-1]<INT_MAX){
                        auto it = upper_bound(arr2.begin(),arr2.end(),dp[i-1][j-1]);
                        if(it!=arr2.end()){
                            dp[i][j]=min(dp[i][j],*it);
                        }
                    }
                }
            }
        }
        for(int i=0;i<n+1;i++){
            if(dp[n-1][i]!=INT_MAX) return i;
        }
        return -1;
    }
};
