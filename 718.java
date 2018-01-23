class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[] dp = new int[m+1];
        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=m;j>0;j--){
                if(A[i-1]==B[j-1]){
                    dp[j]=dp[j-1]+1;
                }else dp[j]=0;
                max = Math.max(max,dp[j]);
            }
        }
        return max;
    }
}