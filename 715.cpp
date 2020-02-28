class RangeModule {
public:
    RangeModule() {
        
    }
    
    void addRange(int left, int right) {
        auto it = find(left, right);
        m[it.first] = it.second;
    }
    
    bool queryRange(int left, int right) {
        auto it = m.upper_bound(left);
        return it!=m.begin()&&(--it)->second>=right;
    }
    
    void removeRange(int left, int right) {
        auto it = find(left, right);
        if(left>it.first) m[it.first] = left;
        if(right<it.second) m[right] = it.second;
    }
private:
    map<int, int> m;
    pair<int, int> find(int left, int right) {
        auto l = m.upper_bound(left), r = m.upper_bound(right);
        if(l!=m.begin()&&(--l)->second<left) ++l;
        if(l==r) return {left, right};
        int ll = min(l->first, left);
        int rr = max(right, (--r)->second);
        m.erase(l,++r);
        return {ll, rr};
    }
};

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule* obj = new RangeModule();
 * obj->addRange(left,right);
 * bool param_2 = obj->queryRange(left,right);
 * obj->removeRange(left,right);
 */
