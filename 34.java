class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = firstLargerEqual(nums,target);
        if(start==nums.length||nums[start]!=target) return new int[]{-1,-1};
        return new int[]{start,firstLargerEqual(nums,target+1)-1};
    }
    private int firstLargerEqual(int[] nums,int target){
        int low=0;
        int high = nums.length;
        while(low<high){
            int mid = (low+high)>>1;
            if(nums[mid]<target){
                low = mid+1;
            }else high = mid;
        }
        return low;
    }
}