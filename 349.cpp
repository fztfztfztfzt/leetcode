class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,bool> map;
        unordered_map<int,bool> tmp;
        vector<int> res;
        for(auto num : nums1){
            map[num] = true;
        }
        for(auto num : nums2){
            if(map.count(num)!=0){
                tmp[num]=true;
            }
        }
        for(auto kv : tmp) res.push_back(kv.first);
        return res;
    }
};
