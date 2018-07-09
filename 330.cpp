class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        int res = 0;
        long miss = 1;
        int index = 0;
        while(miss<=n){
            if(index<nums.size()&&nums[index]<=miss){
                miss+=nums[index++];
            }else{
                res++;
                miss*=2;
            }
        }
        return res;
    }
};