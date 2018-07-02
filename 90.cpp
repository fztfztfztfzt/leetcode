class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> t;
        res.push_back(t);
        int size;
        int start,end;
        for(int index=0;index<nums.size();index++){
            start = 0;
            if(index>0&&nums[index]==nums[index-1])
                start = size;
            size = res.size();
            end = size;
            for(int i=start;i<end;i++){
                vector<int> temp(res[i]);
                temp.push_back(nums[index]);
                res.push_back(temp);
            }
        }
        return res;
    }
};