class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int nextEnd = 0;
        int res = 0;
        for(int i=0;i<nums.length-1;i++){
            nextEnd = Math.max(nextEnd,i+nums[i]);
            if(i==end){
                end = nextEnd;
                res++;
            }
        }
        return res;
    }
}