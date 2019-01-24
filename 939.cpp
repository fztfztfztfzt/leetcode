static int x = []() {std::ios::sync_with_stdio(false); cin.tie(0); return 0; }();
class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        unordered_set<int> map;
        int N = points.size();
        for(int i=0;i<N;i++) map.insert(points[i][0]*40001+points[i][1]);
        int res = INT_MAX;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1==x2||y1==y2) continue;
                if(map.find(x1*40001+y2)==map.end()) continue;
                if(map.find(x2*40001+y1)==map.end()) continue;
                int m = (x1-x2)*(y1-y2);
                if(m<0) m = -m;
                if(m<res) res=m;
            }
        }
        return res==INT_MAX?0:res;
    }
};
