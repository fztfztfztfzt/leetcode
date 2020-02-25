class Solution {
public:
    bool isGoodArray(vector<int>& nums) {
        int n = nums.size();
        if(n==1) return nums[0]==1;
        int res = __gcd(nums[0], nums[1]);
        for(int i=2;i<n;++i) res = __gcd(res,nums[i]);
        return res==1;
    }
};
