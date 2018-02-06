class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums,new boolean[nums.length],result,new ArrayList<Integer>());
        return result;
    }
    private void permute(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> temp){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(nums[i]);
                permute(nums,visited,result,temp);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}