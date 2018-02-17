class NumMatrix {
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return;
        preSum = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                preSum[i+1][j+1]=preSum[i][j+1]+preSum[i+1][j]-preSum[i][j]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row2+1][col1]-preSum[row1][col2+1]+preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */