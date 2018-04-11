class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 0;
        int pos = -1;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            count[i]=1;
            pre[i]=-1;
            int stop = -1;
            for(int j=i-1;j>stop;j--){
                if(nums[i]%nums[j]==0){
                    if(count[j]+1>count[i]){
                        count[i]=count[j]+1;
                        pre[i]=j;
                        stop=pre[j];
                    }
                }
            }
            if(count[i]>max){
                max=count[i];
                pos=i;
            }
        }
        //System.out.println(Arrays.toString(count));
        //System.out.println(Arrays.toString(pre));
        List<Integer> res = new ArrayList<>();
        while(pos>=0){
            res.add(nums[pos]);
            pos = pre[pos];
        }
        return res;
    }
}