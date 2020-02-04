class Solution {
public:
    Solution(){
        std::ios::sync_with_stdio(false);
        std::cin.tie(NULL);
    }
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        unordered_set<uint64_t> s;
        int m[] = {INT_MAX, INT_MAX, INT_MIN, INT_MIN};
        const int dir[4][2] = {{0,1},{0,3},{2,1},{2,3}};
        uint64_t tmp;
        int area = 0;
        for(const auto& rec : rectangles){
            m[0] = min(m[0], rec[0]);
            m[1] = min(m[1], rec[1]);
            m[2] = max(m[2], rec[2]);
            m[3] = max(m[3], rec[3]);
            area += (rec[2]-rec[0])*(rec[3]-rec[1]);
            for(const auto& d : dir){
                tmp = ((uint64_t)rec[d[0]]<<32)|(uint32_t)rec[d[1]];
                if(s.count(tmp)) s.erase(tmp);
                else s.insert(tmp);
            }
        }
        for(const auto& d : dir){
            tmp = ((uint64_t)m[d[0]]<<32)|(uint32_t)m[d[1]];
            if(!s.count(tmp)) return false; 
        }
        return s.size()==4&&(area==(m[2]-m[0])*(m[3]-m[1]));
    }
};
