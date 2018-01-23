class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int temp;
        int right = nums.length-1;
        for(int i=0;i<=right;i++){
            if(nums[i]==0 && i!=left){
                temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i--;
                left++;
            }else if(nums[i]==2 && i!=right){
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                i--;
                right--;
            }
        }
    }
}