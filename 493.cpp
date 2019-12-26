class Solution {
public:
    int reversePairs(vector<int>& nums) {
        int n = nums.size();
        vector<int> v(nums),bit(n+1,0);
        sort(v.begin(),v.end());
        unordered_map<int,int> m;
        for(int i=0;i<n;++i) m[v[i]]=i+1;
        int res = 0;
        for(int i=n-1;i>=0;--i) {
            res += preSum(lower_bound(v.begin(),v.end(),nums[i]/2.0)-v.begin(),bit);
            update(m[nums[i]],bit);
        }
        return res;
    }
private:
    int preSum(int n,vector<int>& bit) {
        int res = 0;
        while(n>0){
            res += bit[n];
            n -= (n&(-n));
        }
        return res;
    }
    void update(int n,vector<int>& bit) {
        while(n<bit.size()){
            bit[n]+=1;
            n+=(n&(-n));
        }
    }
};