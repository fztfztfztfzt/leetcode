class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        if(nums.length==0) this.nums = nums;
        else{
            this.nums = new int[nums.length];
            this.nums[0] = nums[0];
            for(int i=1;i<nums.length;i++) this.nums[i] = this.nums[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return this.nums[j];
        return this.nums[j]-this.nums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */