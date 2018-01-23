class Solution {
    public int maxProduct(int[] nums) {
        int lastmax = nums[0];
        int lastmin = nums[0];
        int temp;
        int product = nums[0];
        for(int i=1;i<nums.length;i++){
            temp = lastmax;
            lastmax = Math.max(Math.max(nums[i],lastmax*nums[i]),nums[i]*lastmin);
            lastmin = Math.min(Math.min(nums[i],temp*nums[i]),nums[i]*lastmin);
            product = Math.max(product,lastmax);
        }
        return product;
    }
}