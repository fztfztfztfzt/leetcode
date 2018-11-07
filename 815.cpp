class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int S, int T) {
        unordered_map<int,unordered_set<int>> map;
        for(int i=0;i<routes.size();i++){
            for(int j=0;j<routes[i].size();j++){
                map[routes[i][j]].insert(i);
            }
        }
        unordered_set<int> visited_bus;
        unordered_set<int> visited_station;
        queue<pair<int,int>> bfs;
        bfs.push(make_pair(S,0));
        int res = 0;
        while(!bfs.empty()){
            int station = bfs.front().first;
            int level = bfs.front().second;
            if(station==T) return level;
            bfs.pop();
            //printf("%d %d\n",station,level);
            for(auto bus=map[station].begin();bus!=map[station].end();++bus){
                if(visited_bus.find(*bus)==visited_bus.end()){
                    visited_bus.insert(*bus);
                    for(auto it=routes[*bus].begin();it!=routes[*bus].end();++it){
                        if(visited_station.find(*it)==visited_station.end()){
                            bfs.push(make_pair(*it,level+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
};
