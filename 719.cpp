class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int left = 0;
        int right = nums.back()-nums[0];
        while(left<right){
            int mid = (right-left)/2+left;
            int cnt = 0;
            for(int end=0,start=0;end<nums.size();++end){
                while(start<end&&nums[end]-nums[start]>mid) ++start;
                cnt += end-start;
            }
            if(cnt<k) left=mid+1;
            else right=mid;
        }
        return left;
    }
};
