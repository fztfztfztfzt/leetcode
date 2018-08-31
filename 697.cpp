class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        unordered_map<int,pair<int,int>> pos;
        unordered_map<int,int> count;
        int maxCount = 0;
        for(int i=0;i<nums.size();i++){
            int num = nums[i];
            if(pos.count(num)==0){
                pos[num]=make_pair(i,i);
                count[num]=1;
            }else{
                ++count[num];
                pos[num].second = i;
            }
            maxCount = max(maxCount,count[num]);
        }
        int minLen = INT_MAX;
        for(auto &item : count){
            if(item.second==maxCount){
                minLen = min(minLen,pos[item.first].second-pos[item.first].first);
            }
        }
        return minLen+1;
    }
};