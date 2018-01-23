class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        k++;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<k&&i<nums.length;i++){
            if(!set.add(nums[i])) return true;
        }
        for(int i=k;i<nums.length;i++){
            set.remove(nums[i-k]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}