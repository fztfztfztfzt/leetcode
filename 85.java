class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        if(n==0) return 0;
        int m=matrix[0].length;
        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        int curLeft,curRight;
        int retMax = 0;
        Arrays.fill(height,0);
        Arrays.fill(left,0);
        Arrays.fill(right,m);
        for(int i=0;i<n;i++){
            curLeft = 0;
            curRight = m;
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                    left[j] = Math.max(left[j],curLeft);
                }else{
                    height[j]=0;
                    curLeft=j+1;
                    left[j]=0;
                }
            }
            for(int j=m-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j] = Math.min(right[j],curRight);
                    retMax = Math.max(retMax,(right[j]-left[j])*height[j]);
                    //System.out.printf("%d,%d\n",(right[j]-left[j])*height[j],retMax);
                }else{
                    right[j]=m;
                    curRight=j;
                }
            }
            //System.out.print(Arrays.toString(left));
            //System.out.print(Arrays.toString(right));
            //System.out.println(Arrays.toString(height));
        }
        return retMax;
        
    }
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
     if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n+1];
        int res = 0;
        for(int row=0; row<m; row++) {
            updateHeights(matrix, row, heights);
            res = Math.max(res, maxArea(heights));
        }
        return res;
    }
    
    private void updateHeights(char[][] matrix, int row, int[] heights) {
        for(int col=0; col<matrix[0].length; col++) {
            if(matrix[row][col]=='1') {
                heights[col]++;
            } else {
                heights[col] = 0;
            }
        }
    }
    
    private int maxArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n+1];
        int top = 0;
        stack[top] = -1;
        int res = 0;
        for(int i=0; i<n; i++) {
            while(top>0 && heights[i]<heights[stack[top]]) {
                int h = heights[stack[top--]];
                res = Math.max(res, h*(i-stack[top]-1));
            }
            stack[++top] = i;
        }
        return res;
    }
}