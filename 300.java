class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<Integer>();
        for(int num : nums){
            int left = 0;
            int right = dp.size();
            while(left<right){
                int mid = left+(right-left)/2;
                if(dp.get(mid)<num) left=mid+1;
                else right=mid;
            }
            if(right==dp.size()) dp.add(num);
            else dp.set(right,num);
        }
        return dp.size();
    }
}