class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int n = points.size();
        if(n<2) return n;
        int maxpoints = 0;
        unordered_map<string,int> m;
        for(int i=0;i<n-1;++i){
            int curmax=0,overlap=0,vertical=0;
            for(int j=i+1;j<n;++j){
                if(points[i][0]==points[j][0]){
                    if(points[i][1]==points[j][1]) ++overlap;
                    else ++vertical;
                    continue;
                }
                int xdiff = points[i][0]-points[j][0];
                int ydiff = points[i][1]-points[j][1];
                int g = __gcd(xdiff,ydiff);
                xdiff /= g;
                ydiff /= g;
                string tmp = to_string(xdiff)+","+to_string(ydiff);
                m[tmp]++;
                curmax = max(curmax,m[tmp]);
            }
            curmax = max(curmax,vertical);
            maxpoints = max(maxpoints,curmax+overlap+1);
            m.clear();
        }
        return maxpoints;
    }
};
