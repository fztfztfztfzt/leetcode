class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        unordered_map<int,int> map;
        for(int i=0;i<deck.size();i++) map[deck[i]]++;
        int res = INT_MAX;
        for(auto i=map.begin();i!=map.end();i++){
            if(i->second<res) res=i->second;
        }
        if(res<2) return false;
        for(auto i=map.begin();i!=map.end();i++){
            res = GCD(i->second,res);
            if(res<2) return false;
        }
        return true;
    }
private:
    int GCD(int m, int n){
        int r=m;
        while(r!=0){
            r=m%n;
            m=n;
            n=r;         
        }
        return m;
    }
};
