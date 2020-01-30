class Solution {
public:
    Solution(int N, vector<int>& blacklist) {
        len = N-blacklist.size();
        unordered_set<int> s;
        for(int i=len;i<N;++i) s.insert(i);
        for(const auto& b : blacklist) if(b>=len) s.erase(b);
        auto it = s.begin();
        for(const auto& b : blacklist){
            if(b<len){
                m[b] = *it++;
            }
        }
    }
    
    int pick() {
        int tmp = rand()%len;
        return m[tmp]?m[tmp]:tmp;
    }
private:
    unordered_map<int,int> m;
    int len;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(N, blacklist);
 * int param_1 = obj->pick();
 */
