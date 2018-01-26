class Solution {
    private int[] data;
    private Random rand;
    public Solution(int[] nums) {
        data = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int result = 0;
        for(int i=0;i<data.length;i++){
            if(data[i]!=target) continue;
            if(rand.nextInt(++count)==0) result = i;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */