class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        n = grid.size();
        int res = 0;
        vector<vector<bool>> visited(n,vector<bool>(n,false));
        int cur = 0;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1&&!visited[i][j]){
                    vs.push_back(0);
                    dfs(grid,visited,cur,i,j);
                    res = max(res,vs[cur++]);
                }
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==0){
                    vector<int> tmp;
                    for(int k=0;k<4;++k){
                        int di = dir[k][0];
                        int dj = dir[k][1];
                        int ni = i+di;
                        int nj = j+dj;
                        if(ni>=0&&ni<n&&nj>=0&&nj<n&&grid[ni][nj]==1){
                            int c = m[ni*n+nj];
                            if(find(tmp.begin(),tmp.end(),c)==tmp.end()){
                                tmp.push_back(c);
                            }
                        }
                    }
                    int tmpsize = 1;
                    for(const auto& c : tmp){
                        tmpsize+=vs[c];
                    }
                    res = max(res,tmpsize);
                }
            }
        }
        return res;
    }
private:
    vector<int> vs;
    unordered_map<int,int> m;
    int n;
    const int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited,int cur,int i,int j){
        if(visited[i][j]) return;
        visited[i][j] = true;
        int ij = i*n+j;
        m[ij] = cur;
        vs[cur]++;
        for(int k=0;k<4;++k){
            int di = dir[k][0];
            int dj = dir[k][1];
            int ni = i+di;
            int nj = j+dj;
            if(ni>=0&&ni<n&&nj>=0&&nj<n&&!visited[ni][nj]&&grid[ni][nj]==1){
                dfs(grid,visited,cur,ni,nj);
            }
        }
    }
};
