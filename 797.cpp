class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<vector<int>>> path(graph.size());
        path.back().push_back(vector<int>(1,graph.size()-1));
        return allPathsSourceTarget(graph,0,graph.size()-1,path);
    }
private:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph, int from, int to, vector<vector<vector<int>>>& path){
        if(!path[from].empty()) return path[from];
        vector<vector<int>> res;
        for(auto next : graph[from]){
            vector<vector<int>> tmp = allPathsSourceTarget(graph,next,to,path);
            //printf("from %d to %d\n",from,next);
            for(auto t : tmp){
                vector<int> tt(1,from);
                tt.insert(tt.end(),t.begin(),t.end());
                res.push_back(tt);
            }
        }
        path[from]=res;
        return res;
    }
};
