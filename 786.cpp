class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& A, int K) {
        priority_queue<pair<double,pair<int,int>>> q;
        for(int i=0;i<A.size();i++){
            q.push({-1.0*A[i]/A.back(),{i,A.size()-1}});
        }
        for(int i=0;i<K-1;i++){
            auto t = q.top().second;
            q.pop();
            q.push({-1.0*A[t.first]/A[t.second-1],{t.first,t.second-1}});
        }
        return {A[q.top().second.first],A[q.top().second.second]};
    }
};

class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& A, int K) {
        double left = 0, right = 1;
        int cnt = 0, p = 0, q = 1, n = A.size();
        while(true){
            double mid = left + (right-left)/2.0;
            cnt = 0; p = 0;
            for(int i=0,j=0;i<n;++i){
                while(j<n&&A[i]>mid*A[j]) ++j;
                cnt += (n-j);
                if(j<n&&A[i]*q>A[j]*p){
                    p = A[i];
                    q = A[j];
                }
            }
            if(cnt==K) return {p,q};
            if(cnt<K) left = mid;
            else right = mid;
        }
    }
};
