class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        if(nums.size()==0) return 0;
        int N = nums.size();
        int* dp = new int[N];
        int* dpc = new int[N];
        int res = 1;
        for(int i=0;i<N;i++){dp[i]=1;dpc[i]=1;}
        for(int i=1;i<N;i++){
            int count = 0;
            int longest = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    int tmp = dp[j]+1;
                    if(tmp>longest) longest=tmp;
                }
            }
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]&&longest-1==dp[j]) count+=dpc[j];
            }
            dp[i] = longest;
            dpc[i] = max(count,dpc[i]);
            if(dp[i]>res) res = dp[i];
        }
        int count = 0;
        for(int i=0;i<N;i++) if(dp[i]==res) count+=dpc[i];
        return count;
    }
};

class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        if(nums.size()==0) return 0;
        vector<vector<pair<int,int>>> dp(nums.size()+1);
        int len = 0;
        for(auto num : nums){
            int l=0, r=len;
            while(l<r){
                int mid = l+(r-l)/2;
                if(dp[mid].back().first<num) l=mid+1;
                else r = mid;
            }
            
            int pre = l-1;
            int count = 1;
            if(pre>=0){
                int ll=0,rr=dp[pre].size();
                while(ll<rr){
                    int mid = ll+(rr-ll)/2;
                    if(dp[pre][mid].first<num) rr=mid;
                    else ll=mid+1;
                }
                count = dp[pre].back().second;
                count -= (ll==0)?0:dp[pre][ll-1].second;
            }
            dp[l].push_back({num,dp[l].empty()?count:dp[l].back().second+count});
            if(l==len) len++;
        }
        return dp[len-1].back().second;
    }
};
