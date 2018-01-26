class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int result=Integer.MIN_VALUE;
        int[][] data = new int[m][n];
        for(int i=0;i<n;i++){
            data[0][i] = matrix[0][i]-'0';
            result = Math.max(result,data[0][i]);
        }
        for(int i=0;i<m;i++){
            data[i][0] = matrix[i][0]-'0';
            result = Math.max(result,data[i][0]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='0') data[i][j]=0;
                else{
                    if(data[i-1][j]>0&&data[i][j-1]>0&&data[i-1][j-1]>0)
                        data[i][j] = Math.min(Math.min(data[i-1][j],data[i][j-1]),data[i-1][j-1])+1;
                    else data[i][j] = 1;
                    result = Math.max(result,data[i][j]);
                }
            }
        }
        return result*result;
    }
}