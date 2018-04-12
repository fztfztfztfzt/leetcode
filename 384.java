class Solution {
    private int[] data;
    private Random random;
    public Solution(int[] nums) {
        data = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return data;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(data==null||data.length==0) return data;
        int[] res = new int[data.length];
        res[0]=data[0];
        for(int i=1;i<data.length;i++){
            res[i]=data[i];
            int s = random.nextInt(i+1);
            swap(res,i,s);
        }
        return res;
    }
    private void swap(int[] res,int i,int j){
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */