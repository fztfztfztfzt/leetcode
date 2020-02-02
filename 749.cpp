class Solution {
public:
    int containVirus(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();
        this->grid = grid;
        this->igrid = grid;
        while(buildWall()){}
        return res;
    }
private:
    vector<vector<int>> grid,igrid;
    int n,m,res=0;
    void initIgrid(){
        for(auto& row : igrid)
            for(auto& val : row)
                val = 0;
    }
    int dfs(int i,int j,int k,int* wall){
        if(i<0||i>=n||j<0||j>=m||grid[i][j]<0) return 0;
        if(grid[i][j]==k){
            if(igrid[i][j]>0) (*wall)++;
            return 0;
        }else if(grid[i][j]==1){
            grid[i][j] = k;
            return dfs(i+1,j,k,wall)+dfs(i,j+1,k,wall)+dfs(i-1,j,k,wall)+dfs(i,j-1,k,wall);
        }
        igrid[i][j]++;
        (*wall)++;
        grid[i][j] = k;
        return 1;
    }
    bool buildWall(){
        initIgrid();
        int imax = -1,addWall = -1,kmax = -1,k=1;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]==1){
                    int wall = 0;
                    int infected = dfs(i,j,++k,&wall);
                    if(infected>imax){
                        imax = infected;
                        addWall = wall;
                        kmax = k;
                    }
                }
            }
        }
        if(k==1) return false;
        res += addWall;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]>0){
                    grid[i][j] = (grid[i][j]==kmax&&igrid[i][j]<=1)?igrid[i][j]-1:1;
                }
            }
        }
        return true;
    }
};
