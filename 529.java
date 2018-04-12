class Solution {
    private int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    private int n;
    private int m;
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        n = board.length;
        m = board[0].length;
        if(board[x][y]=='M'){
            board[x][y]='X';
            return board;
        }else{
            flow(board,x,y);
            return board;
        }
    }
    private boolean valid(int x,int y){
        return (x>=0)&&(x<n)&&(y>=0)&&(y<m);
    }
    private void flow(char[][] board,int x,int y){
        int c = count(board,x,y);
        if(c==0){
            for(int[] p : pos){
                board[x][y]='B';
                int x2 = x+p[0];
                int y2 = y+p[1];
                if(valid(x2,y2)&&board[x2][y2]=='E'){
                    flow(board,x2,y2);
                }
            }
        }else{
            board[x][y]=(char)(c+'0');
        }
    }
    private int count(char[][] board,int x,int y){
        int c = 0;
        for(int[] p : pos){
            int x2=x+p[0];
            int y2=y+p[1];
            if(valid(x2,y2)&&board[x2][y2]=='M') c++;
        }
        return c;
    }
}