class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length<4) return false;
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%4!=0) return false;
        //System.out.println(Arrays.toString(nums));
        quicksort(nums);
        //System.out.println(Arrays.toString(nums));
        int[] stack = new int[4];
        return makesquare(nums,0,stack,sum/4);
    }
    private boolean makesquare(int[] nums,int index,int[] stack,int top){
        if(index==nums.length){
            return stack[0]==top&&stack[1]==top&&stack[2]==top&&stack[3]==top;
        }
        for(int i=0;i<4;i++){
            if(stack[i]+nums[index]>top) continue;
            stack[i]+=nums[index];
            if(makesquare(nums,index+1,stack,top)) return true;
            stack[i]-=nums[index];
        }
        return false;
    }
    private void quicksort(int[] nums){
        quicksort(nums,0,nums.length-1);
    }
    private void quicksort(int[] nums,int start,int end){
        if(start>=end) return;
        int key = nums[start];
        int i=start;
        int j=end;
        while(i<j){
            while(i<j&&nums[j]<=key) j--;
            nums[i] = nums[j];
            while(i<j&&nums[i]>key) i++;
            nums[j] = nums[i];
        }
        nums[i] = key;
        quicksort(nums,start,i-1);
        quicksort(nums,i+1,end);
    }
}