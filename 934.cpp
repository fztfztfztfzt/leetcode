class Solution {
public:
    int shortestBridge(vector<vector<int>>& A){
        queue<pair<int,int>> q;
        int i,j;
        helper(A,q);
        int level = 3;
        int x,y;
        while(!q.empty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                i = q.front().first;
                j = q.front().second;
                q.pop();
                x = i-1;
                y = j;
                if(ok(A,x,y)){
                    if(A[x][y]==1) return level-3;
                    if(A[x][y]==0){
                        A[x][y] = level;
                        q.push(make_pair(x,y));
                    }
                }
                x = i;
                y = j-1;
                if(ok(A,x,y)){
                    if(A[x][y]==1) return level-3;
                    if(A[x][y]==0){
                        A[x][y] = level;
                        q.push(make_pair(x,y));
                    }
                }
                x = i+1;
                y = j;
                if(ok(A,x,y)){
                    if(A[x][y]==1) return level-3;
                    if(A[x][y]==0){
                        A[x][y] = level;
                        q.push(make_pair(x,y));
                    }
                }
                x = i;
                y = j+1;
                if(ok(A,x,y)){
                    if(A[x][y]==1) return level-3;
                    if(A[x][y]==0){
                        A[x][y] = level;
                        q.push(make_pair(x,y));
                    }
                }
            }
            level++;
        }
    }
private:
    void helper(vector<vector<int>>& A,queue<pair<int,int>>& q){
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A[i].size();j++){
                if(A[i][j]==1){
                    dfs(A,i,j,q);
                    return;
                }
            }
        }
    }
    bool ok(vector<vector<int>>& A,int i,int j){
        return (i>=0)&&(i<A.size())&&(j>=0)&&(j<A[0].size());
    }
    void dfs(vector<vector<int>>& A,int i,int j,queue<pair<int,int>>& q){
        if(ok(A,i,j)){
            if(A[i][j]==1){
                A[i][j]=2;
                q.push(make_pair(i,j));
                dfs(A,i+1,j,q);
                dfs(A,i,j+1,q);
                dfs(A,i-1,j,q);
                dfs(A,i,j-1,q);
            }
        }
    }
};
