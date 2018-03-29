class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            tmp.add(nums[i]);
            dfs(res,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}