class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int result = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int s=0;s<N;s++){
            int[][] temp = new int[m][n];
            for(int l=0;l<m;l++){
                for(int k=0;k<n;k++){
                    for(int[] dir : dirs){
                        int nl = l+dir[0];
                        int nk = k+dir[1];
                        if(nl<0||nk<0||nl>=m||nk>=n){
                            result = (result+dp[l][k])%MOD;
                        }else{
                            temp[nl][nk] = (temp[nl][nk]+dp[l][k])%MOD;
                        }
                    }
                }
            }
            dp = temp;
        }
        return result;
    }
}