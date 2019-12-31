class Solution {
public:
    bool isEscapePossible(vector<vector<int>>& blocked, vector<int>& source, vector<int>& target) {
        unordered_set<long long> blocks;
        for(auto b : blocked) blocks.insert(((long long)b[0]<<20)+b[1]);
        int B = blocked.size();
        int deep = B*(B+1)/2;
        long long ss = ((long long)source[0]<<20)+source[1];
        long long tt = ((long long)target[0]<<20)+target[1];
        int res = canEscape(ss,tt,blocks,deep);
        if(res==2) return true;
        else if(res==1) return canEscape(tt,ss,blocks,deep)!=0;
        return false;
    }
private:
    int delta[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
    int canEscape(long long start, long long end, unordered_set<long long>& blocks, int deep){
        queue<long long> q;
        unordered_set<long long> s;
        q.push(start);
        s.insert(start);
        int i = 0;
        while(i<deep){
            if(q.empty()) return 0;
            long long temp = q.front();
            q.pop();
            ++i;
            long long x = temp>>20;
            long long y = temp&0xfffff;
            for(int j=0;j<4;++j){
                long long nx = x-delta[j][0];
                long long ny = y-delta[j][1];
                if(nx>=0&&nx<1000000&&ny>=0&&ny<1000000){
                    long long nxy = (nx<<20)+ny;
                    if(nxy==end) return 2;
                    if(blocks.find(nxy)==blocks.end()&&s.find(nxy)==s.end()){
                        q.push(nxy);
                        s.insert(nxy);
                    }
                }
            }
        }
        return 1;
    }
};