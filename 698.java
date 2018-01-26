class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] data = new int[k];
        Arrays.sort(nums);
        int sum=0;
        for(int num : nums) sum+=num;
        if(sum%k!=0) return false;
        return helper(nums,sum/k,nums.length-1,data);
    }
    private boolean helper(int[] nums,int target,int index,int[] data){
        if(index==-1){
            for(int d : data) if(d!=target) return false;
            return true;
        }
        int num = nums[index];
        for(int i=0;i<data.length;i++){
            if(data[i]+num>target) continue;
            data[i]+=num;
            if(helper(nums,target,index-1,data)) return true;
            data[i]-=num;
        }
        return false;
    }
}