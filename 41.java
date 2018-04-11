class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for(int j=0;j<nums.length;j++) if(nums[j]-1!=j) return j+1;
        return nums.length+1;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}