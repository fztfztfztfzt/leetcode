class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        return sum<S||(sum+S)%2==1?0:find(nums,(S+sum)/2);   
    }
    private int find(int[] nums,int sum){
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j-nums[i]>=0;j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
}

/** 
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        return sum<S||(sum + S)%2==1?0:findTargetSumWays(nums,S,0,sum);   
    }
    private int findTargetSumWays(int[] nums,int S,int start,int sum){
        if(sum<S) return 0;
        if(start>nums.length) return 0;
        if(start==nums.length){
            if(sum==S) return 1;
            else return 0;
        }
        return findTargetSumWays(nums,S,start+1,sum)+findTargetSumWays(nums,S,start+1,sum-2*nums[start]);
    }
}
*/