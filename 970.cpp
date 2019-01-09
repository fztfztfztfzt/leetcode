class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        int a,b;
        unordered_set<int> set;
        for(a=1;a<bound;a*=x){
            for(b=1;b+a<=bound;b*=y){
                set.insert(a+b);
                if(y==1) break;
            }
            if(x==1) break;
        }
        vector<int> res;
        for(auto tmp = set.begin();tmp!=set.end();tmp++){
            res.push_back(*tmp);
        }
        return res;
    }
};
