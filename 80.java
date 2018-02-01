class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int read = 0;
        int last = Integer.MAX_VALUE;
        int time = 0;
        while(read<nums.length){
            if(nums[read]==last){
                if(time==2){
                    read++;
                    continue;
                }else{
                    time++;
                }
            }else{
                last = nums[read];
                time = 1;
            }
            nums[write++]=nums[read++];
        }
        return write;
    }
}