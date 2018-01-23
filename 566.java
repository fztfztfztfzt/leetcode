class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n=nums.length;
        int m=nums[0].length;
        if(n*m!=r*c) return nums;
        int[][] result = new int[r][c];
        for(int i=0;i<m*n;i++){
            result[i/c][i%c] = nums[i/m][i%m];
        }
        
        return result;
    }
}