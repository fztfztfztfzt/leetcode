/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class SummaryRanges {
public:
    /** Initialize your data structure here. */
    SummaryRanges() {
        
    }
    
    void addNum(int val) {
        Interval cur(val,val);
        vector<Interval> res;
        int pos = 0;
        for(auto d : data){
            if(cur.end<d.start-1){
                res.push_back(d);
            }else if(cur.start>d.end+1){
                ++pos;
                res.push_back(d);
            }else{
                cur.start = min(cur.start,d.start);
                cur.end   = max(cur.end,d.end);
            }  
        }
        res.insert(res.begin()+pos,cur);
        data = res;
    }
    
    vector<Interval> getIntervals() {
        return data;
    }
private:
    vector<Interval> data;
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * vector<Interval> param_2 = obj.getIntervals();
 */
