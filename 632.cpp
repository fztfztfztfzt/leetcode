class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        vector<int> res;
        vector<pair<int,int>> data;
        unordered_map<int,int> m;
        for(int i=0;i<nums.size();i++){
            for(int num : nums[i]){
                data.push_back(make_pair(num,i));
            }
        }
        sort(data.begin(),data.end());
        int left = 0, right;
        int cnt = 0;
        int k = nums.size();
        int diff = INT_MAX;
        for(right=0;right<data.size();++right){
            if(m[data[right].second]++==0) ++cnt;
            while(cnt==k&&left<=right){
                if(diff>data[right].first-data[left].first){
                    diff=data[right].first-data[left].first;
                    res = {data[left].first,data[right].first};
                }
                if(--m[data[left].second]==0) --cnt;
                ++left;
            }
        }
        return res;
    }
};