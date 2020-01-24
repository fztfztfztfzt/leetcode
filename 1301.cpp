class Solution {
public:
    vector<int> pathsWithMaxScore(vector<string>& board) {
        int pathmax[2][101];
        long long pathnum[2][101];
        const int M = 1000000007;
        int n = board.size();
        pathnum[(n-1)&1][n-1] = 1;
        pathmax[(n-1)&1][n-1] = 0;
        for(int i=n-2;i>=0;--i){
            char c = board[n-1][i];
            if(c=='X'){
                pathnum[(n-1)&1][i] = 0;
                pathmax[(n-1)&1][i] = 0;
            }else{
                pathnum[(n-1)&1][i] = pathnum[(n-1)&1][i+1];
                pathmax[(n-1)&1][i] = pathmax[(n-1)&1][i+1]+(c-'0');
            }
        }
        for(int i=n-2;i>=0;--i){
            for(int j=n-1;j>=0;--j){
                char c = board[i][j];
                if(c=='X'){
                    pathnum[i&1][j] = 0;
                    pathmax[i&1][j] = 0;
                }else{
                    pathnum[i&1][j] = pathnum[(i+1)&1][j];
                    pathmax[i&1][j] = pathmax[(i+1)&1][j]+(c-'0');
                    if(j!=n-1){
                        int tmp = pathmax[i&1][j+1]+(c-'0');
                        if(tmp>pathmax[i&1][j]){
                            pathmax[i&1][j] = tmp;
                            pathnum[i&1][j] = pathnum[i&1][j+1];
                        }else if(tmp==pathmax[i&1][j]) pathnum[i&1][j]=(pathnum[i&1][j]+pathnum[i&1][j+1])%M;
                        tmp = pathmax[(i+1)&1][j+1]+(c-'0');
                        if(tmp>pathmax[i&1][j]){
                            pathmax[i&1][j] = tmp;
                            pathnum[i&1][j] = pathnum[(i+1)&1][j+1];
                        }else if(tmp==pathmax[i&1][j]) pathnum[i&1][j]=(pathnum[i&1][j]+pathnum[(i+1)&1][j+1])%M;
                    }
                }
            }
        }
        return vector<int>({pathnum[0][0]==0?0:pathmax[0][0]-21,pathnum[0][0]});
    }
};
