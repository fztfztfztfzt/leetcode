class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] pos = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count+=4;
                    for(int[] p : pos){
                        int x = i+p[0];
                        int y = j+p[1];
                        if(valid(n,m,x,y)&&grid[x][y]==1) count--; 
                    }
                }
            }
        }
        return count;
    }
    private boolean valid(int n,int m,int i,int j){
        return (i>=0)&&(i<n)&&(j>=0)&&(j<m);
    }
}