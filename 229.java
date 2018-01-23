class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num0=0;int count0 = 0;
        int num1=1;int count1 = 0;
        for(int d : nums){
            if(d==num0){
                count0++;
            }else if(d==num1){
                count1++;
            }else if(count0==0){
                num0 = d;
                count0++;
            }else if(count1==0){
                num1 = d;
                count1++;
            }else{
                count0--;
                count1--;
            }
        }
        count0 = 0;
        count1 = 0;
        for(int d : nums){
            if(d==num0) count0++;
            if(d==num1) count1++;
        }
        List<Integer> result = new ArrayList<>();
        if(count0>nums.length/3) result.add(num0);
        if(count1>nums.length/3) result.add(num1);
        return result;
    }
}