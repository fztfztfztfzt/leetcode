class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        int sum = 0;
        for(int i=0;i<stones.size();i++) sum+=stones[i];
        vector<bool> dp(sum/2+1,false);
        dp[0] = true;
        for(int i=0;i<stones.size();i++){
            for(int j=sum/2;j>=stones[i];j--){
                dp[j] = dp[j]|dp[j-stones[i]];
            }
        }
        for(int i=sum/2;i>=0;i--){
            if(dp[i]) return sum-i-i;
        }
        return sum;
    }
};
