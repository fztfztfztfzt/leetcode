class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums) sum+=i;
        return n*(n+1)/2-sum;
    }
}