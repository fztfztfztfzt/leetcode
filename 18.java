class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);
        int sum,m,n,temp;
        for(int i=0;i<len-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target) continue;
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<len-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(nums[i]+nums[j]+nums[len-1]+nums[len-2]<target) continue;
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                temp = nums[i]+nums[j];
                m = j+1;n=len-1;
                while(m<n){
                    sum = temp+nums[m]+nums[n];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while(m<n&&nums[m+1]==nums[m])m++;
                        while(m<n&&nums[n-1]==nums[n])n--;
                        m++;n--;
                    }else if(sum<target) m++;
                    else n--;
                }
            }
        }
        return result;
    }
}