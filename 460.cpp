class LFUCache {
public:
    LFUCache(int capacity) {
        cap = capacity;
        minf = 1;
    }
    
    int get(int key) {
        if(kvf.count(key)==0) return -1;
        fks[kvf[key].second].erase(ki[key]);
        ++kvf[key].second;
        fks[kvf[key].second].push_back(key);
        ki[key] = --fks[kvf[key].second].end();
        if(fks[minf].size()==0) ++minf;
        return kvf[key].first;
    }
    
    void put(int key, int value) {
        if(cap<=0) return;
        if(get(key)!=-1){
            kvf[key].first = value;
            return;
        }
        if(kvf.size()==cap){
            int k = fks[minf].front();
            kvf.erase(k);
            ki.erase(k);
            fks[minf].pop_front();
        }
        kvf[key] = {value,1};
        fks[1].push_back(key);
        ki[key] = --fks[1].end();
        minf = 1;
    }
private:
    unordered_map<int,pair<int,int>> kvf;
    unordered_map<int,list<int>> fks;
    unordered_map<int,list<int>::iterator> ki;
    int cap,minf;
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
