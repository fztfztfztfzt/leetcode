class Solution {
public:
    int numSimilarGroups(vector<string>& A) {
        int n = A.size();
        vector<int> root(n);
        for(int i=0;i<n;++i) root[i]=i;
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(isSimilar(A[i],A[j])){
                    root[getRoot(root,j)]=i;
                }
            }
        }
        int res = 0;
        for(int i=0;i<n;++i) if(root[i]==i) res++;
        return res;
    }
private:
    int getRoot(vector<int>& root,int i){
        return root[i]==i?i:getRoot(root,root[i]);
    }
    bool isSimilar(string& a, string& b){
        int diff = 0;
        for(int i=0;i<a.size();i++){
            if(a[i]!=b[i]) diff++;
            if(diff>2) return false;
        }
        return true;
    }
};

class Solution {
public:
    int numSimilarGroups(vector<string>& A) {
        int n = A.size(),res = 0;
        vector<bool> visited(n);
        queue<int> q;
        for(int i=0;i<n;++i){
            if(visited[i]) continue;
            visited[i]=true;
            ++res;
            q.push(i);
            while(!q.empty()){
                string a = A[q.front()];
                q.pop();
                for(int j=0;j<n;j++){
                    if(visited[j]) continue;
                    int diff = isSimilar(a,A[j]);
                    if(diff==0) visited[j]=true;
                    else if(diff==2){
                        visited[j]=true;
                        q.push(j);
                    }
                }
            }
        }
        return res;
    }
private:
    int isSimilar(string& a, string& b){
        int diff = 0;
        for(int i=0;i<a.size();i++){
            if(a[i]!=b[i]) diff++;
            if(diff>2) return 3;
        }
        return diff;
    }
};