class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        int m = grid.size(), n = grid[0].size(), res = 0, keyCnt = 0;
        unordered_set<int> visited;
        queue<int> q;
        int dirX[4] = {-1, 0, 1, 0};
        int dirY[4] = {0, 1, 0, -1};
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]=='@'){
                    int tmp = encode(i,j,0);
                    q.push(tmp);
                    visited.insert(tmp);
                }
                if(grid[i][j]>='a'&&grid[i][j]<='f') keyCnt++;
            }
        }
        while(!q.empty()){
            for(int i=q.size();i>0;--i){
                int key,x,y;
                decode(q.front(),x,y,key);
                q.pop();
                //printf("%d %d %d %d\n",x,y,key,res);
                if(key==(1<<keyCnt)-1) return res;
                for(int k=0;k<4;++k){
                    int nx = x+dirX[k];
                    int ny = y+dirY[k];
                    int nkey = key;
                    if(nx<0||nx>=m||ny<0||ny>=n) continue;
                    char t = grid[nx][ny];
                    if(t=='#') continue;
                    if(t>='A'&&t<='F'&&((nkey&(1<<(t-'A')))==0)) continue;
                    if(t>='a'&&t<='f') nkey|=(1<<(t-'a'));
                    int ncode = encode(nx,ny,nkey);
                    if(!visited.count(ncode)){
                        visited.insert(ncode);
                        q.push(ncode);
                    }
                }
            }
            ++res;
        }
        return -1;
    }
private:
    int encode(int x, int y, int key) {
        return (((x<<5)+y)<<6)+key;
    }
    void decode(int data, int &x, int &y, int& key) {
        key = data&0b111111;
        y = (data>>6)&0b11111;
        x = (data>>11)&0b11111;
    }
};
