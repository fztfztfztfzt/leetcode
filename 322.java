class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        Arrays.sort(coins);
        if(amount<coins[0]) return -1;
        int[] result = new int[amount+1];
        Arrays.fill(result,-1);
        result[0]=0;
        int j;
        for(int i=coins[0];i<amount+1;i++){
            int temp = Integer.MAX_VALUE;
            for(int k=0;k<coins.length;k++){
                j=coins[k];
                if(j>i) break;
                if(result[i-j]!=-1){
                    temp = Math.min(temp,result[i-j]+1);
                    result[i] = temp;
                }
            }
            //System.out.printf("%d:%d\n",i,result[i]);
        }
        return result[amount];
    }
}