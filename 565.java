class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        int sum;
        int temp;
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=0;
            temp = i;
            while(flag[temp]==false){
                flag[temp] = true;
                sum++;
                temp = nums[temp];
            }
            result = Math.max(sum,result);
        }
        return result;
    }
}