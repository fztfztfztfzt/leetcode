class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] dig = new int[10];
        for(int i=0;i<nums.length;i++){
            dig[nums[i]-'0']=i;
        }
        for(int i=0;i<nums.length;i++){
            for(int k=9;k>nums[i]-'0';k--){
                if(dig[k]>i){
                    char temp = nums[i];
                    nums[i] = (char)(k+'0');
                    nums[dig[k]] = temp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}