class Solution {
    public int[] singleNumber(int[] nums) {
        int flag = 0;
        int[] result = new int[2];
        result[0]=0;
        result[1]=0;
        for(int i : nums) flag^=i;
        flag = (flag&(flag-1))^flag;
        for(int i : nums){
            if((i&flag)==0) result[0]^=i;
            else result[1]^=i;
        }
        return result;
    }
}