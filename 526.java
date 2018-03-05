class Solution {
    private int count;
    public int countArrangement(int N) {
        if(N==0) return 0;
        int[] nums = new int[N+1];
        for(int i=0;i<=N;i++) nums[i]=i;
        count = 0;
        countArrangement(nums,N);
        return count;
    }
    private void countArrangement(int[] nums,int N){
        if(N==0){
            count++;
            return;
        }
        for(int i=N;i>0;i--){
            swap(nums,i,N);
            if(nums[N]%N==0||N%nums[N]==0) countArrangement(nums,N-1);
            swap(nums,i,N);
        }
    }
    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}