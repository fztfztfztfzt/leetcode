class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        int n = positions.size();
        vector<int> heights(n, 0), res;
        for(int i=0;i<n;++i){
            int len = positions[i][1];
            int left = positions[i][0];
            int right = left+len;
            heights[i] += len;
            for(int j=i+1;j<n;++j){
                int l = positions[j][0];
                int r = positions[j][1]+l;
                if(l<right && r>left)
                    heights[j] = max(heights[j],heights[i]);
            }
        }
        int m = 0;
        for(int cur : heights){
            m = max(m, cur);
            res.push_back(m);
        }
        return res;
    }
};

class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        vector<int> res;
        map<pair<int,int>,int> m;
        int curmax = 0;
        for(int i=0;i<positions.size();++i){
            int left = positions[i][0], height = positions[i][1], right = left+height;
            int h = 0;
            vector<vector<int>> tmp;
            auto it = m.upper_bound({left,left});
            if(it!=m.begin()&&(--it)->first.second<=left) ++it;
            while(it!=m.end()&&it->first.first<right){
                if(left>it->first.first) tmp.push_back({it->first.first,left,it->second});
                if(right<it->first.second) tmp.push_back({right,it->first.second,it->second});
                h = max(h,it->second);
                it = m.erase(it);
            }
            m[{left,right}] = h+height;
            for(auto t : tmp) m[{t[0],t[1]}] = t[2];
            curmax = max(curmax,h+height);
            res.push_back(curmax);
        }
        return res;
    }
};
