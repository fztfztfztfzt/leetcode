class UnionFind {
public:
    UnionFind(int n):pre(n){
        for(int i=0;i<n;i++){
            pre[i] = i;
        }
    }
    void Union(int a,int b){
        int ar = this->Find(a);
        int br = this->Find(b);
        if(ar!=br){
            pre[ar] = br;
        }
    }
    int Find(int a){
        int res = a;
        while(res!=pre[res]) res = pre[res];
        int tmp = a;
        while(tmp!=pre[tmp]){
            int t = pre[tmp];
            pre[tmp] = res;
            tmp = t;
        }
        return res;
    }
private:
    vector<int> pre;
};

class Solution {
public:
    int largestComponentSize(vector<int>& A) {
        int n = *max_element(A.begin(),A.end());
        UnionFind* uf = new UnionFind(n+1);
        for(const auto& a : A){
            int t = sqrt(a);
            for(int i=2;i<=t;++i){
                if(a%i==0){
                    uf->Union(a,i);
                    uf->Union(a,a/i);
                }
            }
        }
        unordered_map<int,int> m;
        int res = 1;
        for(const auto& a : A){
            res = max(res,++m[uf->Find(a)]);
        }
        return res;
    }
};
