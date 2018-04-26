class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        int x=0,o=0;
        bool xwin=false,owin=false;
        getNum(board,x,o);
        //printf("x:%d o:%d",x,o);
        if(!(x==o||x==o+1)) return false;
        getWin(board,xwin,owin);
        //printf("x:%d o:%d",x,o);
        //printf("xwin: %d owin:%d",xwin,owin);
        if(xwin) return x==o+1;
        if(owin) return x==o;
        return true;
    }
private:
    void getNum(vector<string>& board,int &x,int &o){
        for(string s : board){
            for(char r : s){
                //printf(&r);
                if(r=='X') x++;
                if(r=='O') o++;
            }
        }
    }
    void getWin(vector<string>& board,bool &xwin,bool &owin){
        for(string s : board){
            if(s=="XXX") xwin=true;
            if(s=="OOO") owin=true;
        }
        for(int i=0;i<3;i++){
            if(board[0][i]=='X'&&board[1][i]=='X'&&board[2][i]=='X') xwin=true;
            if(board[0][i]=='O'&&board[1][i]=='O'&&board[2][i]=='O') owin=true;
        }
        if(board[0][0]=='X'&&board[1][1]=='X'&&board[2][2]=='X') xwin=true;
        if(board[0][0]=='O'&&board[1][1]=='O'&&board[2][2]=='O') owin=true;
        if(board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]=='X') xwin=true;
        if(board[0][2]=='O'&&board[1][1]=='O'&&board[2][0]=='O') owin=true;
    }
};