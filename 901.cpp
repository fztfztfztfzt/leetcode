class StockSpanner {
public:
    stack<pair<int,int>> s;
    StockSpanner() {
    }
    
    int next(int price) {
        int num = 1;
        while(!s.empty()&&price>=s.top().first){
            num+=s.top().second;
            s.pop();
        }
        //printf("%d %d",price,num);
        s.push(make_pair(price,num));
        return num;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
