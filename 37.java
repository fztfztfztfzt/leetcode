class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }
    private boolean dfs(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    boolean[] v = valid(board,i,j);
                    for(int x=0;x<9;x++){
                        if(v[x]){
                            board[i][j]=(char)(x+'1');
                            if(dfs(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean[] valid(char[][] board,int x,int y){
        boolean[] res = new boolean[9];
        Arrays.fill(res,true);
        for(int i=0;i<9;i++){
            char c = board[x][i];
            if(c!='.') res[c-'1']=false;
            c = board[i][y];
            if(c!='.') res[c-'1']=false;
        }
        int xx = x/3;
        int yy = y/3;
        for(int i=0;i<3;i++){
            int py = yy*3+i;
            for(int j=0;j<3;j++){
                int px = xx*3+j;
                char c = board[px][py];
                if(c!='.') res[c-'1']=false;
            }
        }
        return res;
    }
}