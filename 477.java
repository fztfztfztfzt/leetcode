class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int n = nums.length;
        for(int i=0;i<32;i++){
            int k = 0;
            for(int num : nums)
                k+=((num>>>i)&1);
            result+=k*(n-k);
        }
        return result;
    }
}