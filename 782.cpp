class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        int n = board.size();
        for(int i=0;i<n;++i)
            for(int j=0;j<n;++j)
                if((board[0][0]^board[i][0]^board[0][j]^board[i][j])!=0) return -1;
        int rowSum=0,colSum=0,rowDiff=0,colDiff=0;
        for(int i=0;i<n;++i){
            rowSum+=board[0][i];
            colSum+=board[i][0];
            rowDiff+=(board[0][i]==i%2);
            colDiff+=(board[i][0]==i%2);
        }
        if(rowSum<n/2||rowSum>(n+1)/2) return -1;
        if(colSum<n/2||colSum>(n+1)/2) return -1;
        //printf("%d %d\n",colDiff,rowDiff);
        if(n%2){
            if(rowDiff%2) rowDiff=n-rowDiff;
            if(colDiff%2) colDiff=n-colDiff;
        }else{
            rowDiff = min(n-rowDiff,rowDiff);
            colDiff = min(n-colDiff,colDiff);
        }
        //printf("%d %d\n",colDiff,rowDiff);
        return (colDiff+rowDiff)/2;
    }
};
