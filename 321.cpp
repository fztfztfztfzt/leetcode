class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        vector<int> res;
        for(int i=max(0,k-n2);i<=min(n1,k);++i){
            res = max(res,mergeVector(maxVector(nums1,i),maxVector(nums2,k-i)));
        }
        return res;
    }
private:
    vector<int> maxVector(vector<int>& nums, int k) {
        int drop = nums.size()-k;
        vector<int> res;
        for(int num : nums){
            while(drop>0&&!res.empty()&&res.back()<num){
                --drop;
                res.pop_back();
            }
            res.push_back(num);
        }
        res.resize(k);
        return res;
    }
    vector<int> mergeVector(vector<int> nums1, vector<int> nums2) {
        vector<int> res;
        while(!nums1.empty()||!nums2.empty()){
            vector<int>& tmp = nums1>nums2?nums1:nums2;
            res.push_back(tmp[0]);
            tmp.erase(tmp.begin());
        }
        return res;
    }
};
