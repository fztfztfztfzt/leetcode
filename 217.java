class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> result = new HashSet<Integer>();
        for(int i : nums){
            if(!result.add(i))
                return true;
        }
        return false;
    }
}