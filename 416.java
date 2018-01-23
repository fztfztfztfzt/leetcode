class Solution {
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0) return false;
        int sum=0;
        for(int i : nums) sum+=i;
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] result = new boolean[target+1];
        Arrays.fill(result,false);
        result[0]=true;
        for(int i : nums){
            for(int j=target;j>=i;j--){
                result[j]=result[j]||result[j-i];
            }
        }
        return result[target];
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        return help(nums, nums.length - 1, target, target);
    } 

    public boolean help(int[] nums, int index, int set1, int set2) {
        if(set1 < 0 || set2 < 0 || index < -1) return false;
        if(set1 == 0 && set2 == 0) return true;
        return help(nums, index - 1, set1 - nums[index], set2) || help(nums, index - 1, set1, set2 - nums[index]);
    }
}