class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int N = rooms.size();
        bool* visited = new bool[N];
        int n = 1;
        for(int i=0;i<N;i++) visited[i]=false;
        visited[0] = true;
        unordered_set<int> cur;
        cur.insert(0);
        unordered_set<int> cur2;
        while(!cur.empty()){
            cur2.clear();
            for(const auto& i: cur){
                for(int j=0;j<rooms[i].size();j++){
                    if(!visited[rooms[i][j]]){
                        cur2.insert(rooms[i][j]);
                        visited[rooms[i][j]] = true;
                        n++;
                    }
                }
            }
            cur = cur2;
        }
        if(n==N) return true;
        else return false;
    }
};
