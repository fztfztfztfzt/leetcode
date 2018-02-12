class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        int[] dp = new int[A.length];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                if(dp[i-1]==0&&dp[i-2]==0) dp[i]=3;
                else dp[i] = dp[i-1]+1;
            }
        }
        int res = 0;
        for(int i : dp){
            if(i>2) res+=(i-2);
        }
        return res;
    }
}