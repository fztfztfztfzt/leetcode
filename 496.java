class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int[] next = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            next[i]=map.getOrDefault(nums1[i],-1);
        }
        return next;
    }
}