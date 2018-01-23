class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] temp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j] = numNeighbors(board,i,j);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1){
                    if(temp[i][j]==2||temp[i][j]==3) continue;
                    else board[i][j]=0;
                }else{
                    if(temp[i][j]==3) board[i][j]=1;
                }
            }
        }
    }
    private int numNeighbors(int[][] board,int x,int y){
        int n = board.length;
        int m = board[0].length;
        int sum = 0;
        if(ok(x-1,y-1,n,m)&&board[x-1][y-1]==1) sum++;
        if(ok(x-1,y,n,m)&&board[x-1][y]==1) sum++;
        if(ok(x-1,y+1,n,m)&&board[x-1][y+1]==1) sum++;
        if(ok(x,y-1,n,m)&&board[x][y-1]==1) sum++;
        if(ok(x,y+1,n,m)&&board[x][y+1]==1) sum++;
        if(ok(x+1,y-1,n,m)&&board[x+1][y-1]==1) sum++;
        if(ok(x+1,y,n,m)&&board[x+1][y]==1) sum++;
        if(ok(x+1,y+1,n,m)&&board[x+1][y+1]==1) sum++;
        return sum;
    }
    private boolean ok(int x,int y,int n,int m){
        if(x>=0&&x<n&&y>=0&&y<m) return true;
        return false;
    }
}