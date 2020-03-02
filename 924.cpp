class Solution {
public:
    int minMalwareSpread(vector<vector<int>>& graph, vector<int>& initial) {
        int n = graph.size();
        vector<int> root(n,-1);
        for(int i=0;i<n;++i) root[i]=i;
        for(int i=0;i<n-1;++i){
            for(int j=i+1;j<n;++j){
                if(graph[i][j]==1) root[findRoot(root,j)]=root[findRoot(root,i)]; 
            }
        }
        vector<int> malware(n,0);
        vector<int> area(n,0);
        for(int i=0;i<n;i++) ++area[findRoot(root,i)];
        for(const auto& i : initial) ++malware[findRoot(root,i)];
        pair<int,int> res = {1,0};
        for(const auto& i : initial){
            int r = findRoot(root,i);
            res = min(res,{(malware[r]==1)*-area[r],i});
        }
        return res.second;
    }
private:
    int findRoot(vector<int>& root, int i) {
        if(root[i]==i) return i;
        int tmp = findRoot(root, root[i]);
        //root[i]=tmp;
        return tmp;
    }
};
