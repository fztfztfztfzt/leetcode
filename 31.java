class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]) break;
        }
        if(i==0){
            reverseSort(nums,0,nums.length-1);
            return;
        }
        int j;
        int val = nums[i-1];
        for(j = nums.length-1;j>=i;j--){
            if(nums[j]>val) break;
        }
        nums[i-1] = nums[j];
        nums[j] = val;
        reverseSort(nums,i,nums.length-1);
    }
    private void reverseSort(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;end--;
        }
    }
}