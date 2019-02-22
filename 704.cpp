class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size()-1;
        while(right>=left){
            int mid = (right-left)/2+left;
            //printf("%d %d %d\n",mid,right,left);
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
};
