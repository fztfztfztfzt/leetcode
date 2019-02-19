class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int> tmp(nums.size());
        vector<int> res;
        for(auto t : nums){
            if(tmp[t-1]==0) tmp[t-1]=1;
            else res.push_back(t);
        }
        for(int i=0;i<nums.size();i++){
            if(tmp[i]==0){
                res.push_back(i+1);
                break;
            }
        }
        return res;
    }
};
