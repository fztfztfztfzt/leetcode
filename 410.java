class Solution {
    public int splitArray(int[] nums, int m) {
        long sum=0;
        int max=0;
        for(int num : nums){
            if(num>max) max=num;
            sum+=num;
        } 
        if(m==1) return (int)sum;
        if(m==nums.length) return (int)max;
        long l=max;
        long r=sum;
        while(l<r){
            long mid = (r-l)/2+l;
            if(valid(nums,m,mid)) r=mid;
            else l=mid+1;
        }
        return (int)l;
    }
    private boolean valid(int[] nums,int m,long target){
        int count = 1;
        long total = 0;
        for(int num : nums){
            total+=num;
            if(total>target){
                total=num;
                count++;
                if(count>m) return false;
            }
        }
        return true;
    }
}