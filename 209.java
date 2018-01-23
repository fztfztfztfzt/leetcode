class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end<nums.length){
            sum+=nums[end++];
            while(sum>=s){
                len = Math.min(len,end-start);
                sum-=nums[start++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}