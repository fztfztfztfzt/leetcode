class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0) return new ArrayList<String>();
        int start=nums[0];
        int end=nums[0];
        List<String> result = new ArrayList<>();
        for(int i : nums){
            if(i==end) end++;
            else{
                StringBuilder sb = new StringBuilder("");
                if(end-1==start){
                    sb.append(start);
                    result.add(sb.toString());
                }else{
                    sb.append(start);
                    sb.append("->");
                    sb.append(end-1);
                    result.add(sb.toString());
                }
                start = i;
                end = i+1;
            }
        }
        StringBuilder sb = new StringBuilder("");
        if(end-1==start){
            sb.append(start);
            result.add(sb.toString());
        }else{
            sb.append(start);
            sb.append("->");
            sb.append(end-1);
            result.add(sb.toString());
        }
        return result;
    }
}