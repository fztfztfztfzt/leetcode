class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& D, int N) {
        int n[10] = {0};
        int size = 0;
        while(N>0){
            n[size++] = N%10;
            N /= 10;
        }
        bool d[10] = {false};
        int dsize = D.size();
        for(string c : D){
            d[c[0]-'0']=true;
        }
        int res = 0;
        for(int i=1;i<size;i++) res+=pow(dsize,i);
        res += helper(d,dsize,n,size-1);
        return res;
    }
private:
    int helper(bool d[10],int dsize,int n[10],int size){
        int small = 0;
        for(int i=n[size]-1;i>0;--i) if(d[i]) ++small;
        if(size==0) return small+(d[n[size]]?1:0);
        if(!d[n[size]]) return small*pow(dsize,size);
        return small*pow(dsize,size)+helper(d,dsize,n,size-1);
    }
    int pow(int base,int e){
        int res = 1;
        for(int i=0;i<e;i++) res*=base;
        return res;
    }
};