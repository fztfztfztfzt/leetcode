class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int pre = 1;
        int result = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                pre++;
                result = Math.max(result,pre);
            }else pre = 1;
        }
        return result;
    }
}