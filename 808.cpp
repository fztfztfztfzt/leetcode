class Solution {
public:
    double soupServings(int N) {
        int n = ceil(N/25.0);
        return N>=4800?1:soupServings(n,n);
    }
private:
    double cache[200][200];
    double soupServings(int a,int b){
        if(a<=0&&b<=0) return 0.5;
        if(a<=0) return 1;
        if(b<=0) return 0;
        if(cache[a][b]>0) return cache[a][b];
        cache[a][b] = 0.25*(soupServings(a-4,b)+soupServings(a-3,b-1)+soupServings(a-2,b-2)+soupServings(a-1,b-3));
        return cache[a][b];
    }
}