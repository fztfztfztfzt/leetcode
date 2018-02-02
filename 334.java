class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = small;
        for(int num : nums){
            if(num<=small) small = num;
            else if(num<=big) big = num;
            else return true;
        }
        return false;
    }
}