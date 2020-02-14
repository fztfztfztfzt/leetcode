class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        int x,y;
        n = grid.size();
        m = grid[0].size();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]==1){
                    x=i;y=j;
                }else if(grid[i][j]==0) ++num;
            }
        }
        grid[x][y]=-1;
        return dfs(grid,x,y,0);
    }
private:
    const int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
    int n,m,num;
    int dfs(vector<vector<int>>& grid,int x,int y,int deep){
        //printf("%d %d %d\n",x,y,deep);
        int res = 0;
        for(const auto& d : dir){
            int nx = d[0]+x;
            int ny = d[1]+y;
            if(nx>=0&&nx<n&&ny>=0&&ny<m&&grid[nx][ny]!=-1){
                int tmp = grid[nx][ny];
                if(tmp==2){
                    res += num==deep?1:0;
                }else{
                    grid[nx][ny] = -1;
                    res += dfs(grid,nx,ny,deep+1);
                    grid[nx][ny] = tmp;
                }
            }
        }
        return res;
    }
};
