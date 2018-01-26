class Solution {
    char[][] data;
    boolean[][] flag;
    int m,n;
    public void solve(char[][] board) {
        if(board==null||board.length==0) return;
        m = board.length;
        n = board[0].length;
        data = board;
        flag = new boolean[m][n];
        for(int i=0;i<m;i++){
            if(data[i][0]=='O') find(i,0);
            if(data[i][n-1]=='O') find(i,n-1);
        }
        for(int i=0;i<n;i++){
            if(data[0][i]=='O') find(0,i);
            if(data[m-1][i]=='O') find(m-1,i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&&(!flag[i][j])) board[i][j]='X'; 
            }
        }
    }
    private void find(int x,int y){
        if(x<0||y<0||x>=m||y>=n) return;
        if(flag[x][y]) return;
        if(data[x][y]=='O'){
            flag[x][y]=true;
            find(x-1,y);
            find(x,y-1);
            find(x+1,y);
            find(x,y+1);
        }
        return;
    }
}