class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for(int i : nums){
            if(i==0) temp=0;
            else{
                temp++;
                max = Math.max(max,temp);
            }
        }
        return max;
    }
}