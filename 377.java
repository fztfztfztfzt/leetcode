class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target+1];
        res[0] = 1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                    res[i]+=res[i-nums[j]];
                }
            }
        }
        return res[target];
    }
}