class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int res = 0;
        int l = 0;
        int sum = 1;
        for(int r = 0;r<nums.length;r++){
            sum*=nums[r];
            while(sum>=k) sum/=nums[l++];
            res+=(r-l+1);
        }
        return res;
    }
}