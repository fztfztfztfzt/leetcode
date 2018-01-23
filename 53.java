class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int last = nums[0];
        for(int i=1;i<nums.length;i++){
            last = Math.max(nums[i],nums[i]+last);
            sum = Math.max(sum,last);
        }
        return sum;
    }
}