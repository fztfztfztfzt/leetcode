class Solution {
public:
    int kthGrammar(int N, int K) {
        if(N<=2) return K-1;
        return (kthGrammar(N-1,((K-1)>>1)+1)==0)?(K-1)%2:K%2;
    }
};
