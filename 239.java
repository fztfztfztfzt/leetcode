class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] idx = new int[nums.length];
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(left<right && nums[idx[right-1]]<=nums[i]) right--;
            idx[right++]=i;
        }
        int n = 0;
        for(int i=k;i<nums.length;i++){
            result[n++] = nums[idx[left]];
            while(left<right && nums[idx[right-1]]<=nums[i]) right--;
            if(left<right && idx[left]<=i-k) left++;
            idx[right++]=i;
        }
        result[n++] = nums[idx[left]];
        return result;
    }
}