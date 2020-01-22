const int maxn = 100001;
class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<vector<int>> map(n,vector<int>());
        for(const auto& con : connections){
            map[con[0]].push_back(con[1]);
            map[con[1]].push_back(con[0]);
        }
        memset(dfn,-1,sizeof(dfn));
        memset(low,-1,sizeof(low));
        level = 0;
        Tarjan(map,0);
        return res;
    }
private:
    int dfn[maxn];
    int low[maxn];
    int level;
    vector<vector<int>> res;
    void Tarjan(vector<vector<int>>& map, int u, int pre=-1){
        if(dfn[u]!=-1) return;
        dfn[u] = low[u] = level++;
        for(const auto& v : map[u]){
            if(v==pre) continue;
            Tarjan(map,v,u);
            low[u] = min(low[u],low[v]);
            if(low[v]>dfn[u]){
                res.push_back({u,v});
            }
        }
    }
};
