class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int n = startTime.size();
        vector<vector<int>> data(n,vector<int>(3,0));
        vector<int> dp(n,0);
        for(int i=0;i<n;++i){
            data[i][0] = startTime[i];
            data[i][1] = endTime[i];
            data[i][2] = profit[i];
        }
        auto cmp = [&](vector<int>& x, vector<int>& y){
            return x[1]<y[1];
        };
        sort(data.begin(),data.end(),cmp);
        dp[0] = data[0][2];
        for(int i=1;i<n;++i){
            int l=0,r=i-1;
            while(l<r){
                int mid = (r-l)/2+l;
                if(data[mid+1][1]<=data[i][0]) l=mid+1; 
                else r=mid;
            }
            if(data[l][1]<=data[i][0]) dp[i] = max(dp[i-1],dp[l]+data[i][2]);
            else dp[i]=max(dp[i-1],data[i][2]);
        }
        return dp[n-1];
    }
};
