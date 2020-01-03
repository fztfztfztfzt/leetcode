class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int global[3] = {0};
        int local[3] = {0};
        for(int i=1;i<prices.size();++i){
            int diff = prices[i]-prices[i-1];
            for(int j=2;j>0;--j){
                local[j] = max(global[j-1]+max(diff,0),local[j]+diff);
                global[j] = max(local[j],global[j]);
            }
        }
        return global[2];
    }
};
