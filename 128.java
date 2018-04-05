class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)) continue;
            boolean l = map.containsKey(num-1);
            boolean r = map.containsKey(num+1);
            if(l&&r){
                int ll = map.get(num-1);
                int rr = map.get(num+1);
                map.put(num-ll,ll+rr+1);
                map.put(num+rr,ll+rr+1);
                map.put(num,1);
            }else if((!l)&&r){
                int rr = map.get(num+1);
                map.put(num+rr,rr+1);
                map.put(num,rr+1);
            }else if(l&&(!r)){
                int ll = map.get(num-1);
                map.put(num-ll,ll+1);
                map.put(num,ll+1);
            }else{
                map.put(num,1);
            }
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            //System.out.printf("%d %d\n",entry.getKey(),entry.getValue());
            if(entry.getValue()>max) max=entry.getValue();
        }
        return max;
    }
}