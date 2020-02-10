class Solution {
public:
    int catMouseGame(vector<vector<int>>& graph) {
        n = graph.size();
        vector<vector<vector<int>>> cache(2*n,vector<vector<int>>(n,vector<int>(n,-1)));
        return dfs(0,1,2,cache,graph);
    }
private:
    int n;
    int dfs(int turn,int mouse,int cat,vector<vector<vector<int>>>& cache, vector<vector<int>>& graph){
        if(turn>=2*n) return 0;
        if(mouse==0) return cache[turn][mouse][cat] = 1;
        if(cat==mouse) return cache[turn][mouse][cat] = 2;
        if(cache[turn][mouse][cat]!=-1) return cache[turn][mouse][cat];
        if((turn&1)==0){
            //mouse
            bool catWin = true;
            for(const auto& n : graph[mouse]){
                int next = dfs(turn+1,n,cat,cache,graph);
                if(next==1) return cache[turn][mouse][cat]=1;
                else if(next!=2) catWin=false;
            }
            if(catWin) return cache[turn][mouse][cat]=2;
            return cache[turn][mouse][cat]=0;
        }else{
            //cat
            bool mouseWin = true;
            for(const auto& n : graph[cat]){
                if(n==0) continue;
                int next = dfs(turn+1,mouse,n,cache,graph);
                if(next==2) return cache[turn][mouse][cat]=2;
                else if(next!=1) mouseWin=false;
            }
            if(mouseWin) return cache[turn][mouse][cat]=1;
            return cache[turn][mouse][cat]=0;
        }
    }
};
