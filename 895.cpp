class FreqStack {
public:
    FreqStack() {
        
    }
    
    void push(int x) {
        maxFreq = max(maxFreq, ++freq[x]);
        st[freq[x]].push_back(x);
    }
    
    int pop() {
        int res = st[maxFreq].back();
        st[maxFreq].pop_back();
        --freq[res];
        if(st[maxFreq].size()==0) --maxFreq;
        return res;
    }
private:
    int maxFreq = 0;
    unordered_map<int, int> freq;
    unordered_map<int, vector<int>> st;
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 */
