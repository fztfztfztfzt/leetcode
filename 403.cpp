class Solution {
public:
    bool canCross(vector<int>& stones) {
        unordered_map<int,int> poses;
        unordered_map<int,bool> cache;
        for(int i=0;i<stones.size();i++) poses[stones[i]] = i;
        return helper(stones,0,0,cache,poses);
    }
private:
    bool helper(vector<int>& stones, int pos, int jump, unordered_map<int,bool>& cache, unordered_map<int,int>& poses){
        int n = stones.size();
        if(pos>=n-1) return true;
        int key = (jump<<11)|pos;
        if(cache.count(key)) return cache[key];
        for(int dist=max(jump-1,1);dist<=jump+1;++dist){
            int nextpos = stones[pos]+dist;
            if(poses.count(nextpos)){
                if(helper(stones,poses[nextpos],dist,cache,poses)) return cache[key] = true;
            }
        }
        return cache[key] = false;
    }
};