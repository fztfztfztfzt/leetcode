class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int res = 0;
        for(int i=1;i<grid.size()-1;++i){
            for(int j=1;j<grid[i].size()-1;++j){
                if(grid[i][j]==5){
                    if(isMagic(grid,i,j)) res++;
                }
            }
        }
        return res;
    }
private:
    int data[16] = {43816729, 38167294, 81672943, 16729438, 67294381, 72943816, 29438167, 94381672,27618349, 76183492, 61834927, 18349276, 83492761, 34927618, 49276183, 92761834};
    bool isMagic(vector<vector<int>>& grid, int i, int j){
        int cmp = grid[i-1][j-1];
        cmp = cmp*10+grid[i-1][j];
        cmp = cmp*10+grid[i-1][j+1];
        cmp = cmp*10+grid[i][j+1];
        cmp = cmp*10+grid[i+1][j+1];
        cmp = cmp*10+grid[i+1][j];
        cmp = cmp*10+grid[i+1][j-1];
        cmp = cmp*10+grid[i][j-1];
        //printf("%d\n",cmp);
        for(int i=0;i<16;i++){
            if(data[i]==cmp) return true;
        }
        return false;
    }
};
