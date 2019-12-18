class Solution {
public:
    string shortestSuperstring(vector<string>& A) {
        int n = A.size();
        vector<vector<int>> graph(n,vector<int>(n,0));
        for(int i=0;i<n-1;++i){
            for(int j=i+1;j<n;++j){
                graph[i][j] = calCost(A,i,j);
                graph[j][i] = calCost(A,j,i);
            }
        }
        vector<vector<int>> dp(1<<n,vector<int>(n,INT_MAX));
        vector<vector<int>> path(1<<n,vector<int>(n,INT_MAX));
        int min = INT_MAX;
        int last = 0;
        for(int state = 1;state<(1<<n);++state){
            for(int i=0;i<n;++i){
                if((state&(1<<i))!=0){
                    int remain = state-(1<<i);
                    if(remain==0){
                        dp[state][i] = A[i].size();
                    }else{
                        for(int j=0;j<n;j++){
                            if(dp[remain][j]!=INT_MAX && dp[state][i]>dp[remain][j]+graph[j][i]){
                                dp[state][i]=dp[remain][j]+graph[j][i];
                                path[state][i] = j;
                            }
                        }
                    }
                }
                if(state==(1<<n)-1 && dp[state][i]<min){
                    min = dp[state][i];
                    last = i;
                }
            }
        }
        vector<int> nodes;
        int state = (1<<n)-1;
        while(last!=INT_MAX){
            nodes.push_back(last);
            int tmp = state - (1<<last);
            last = path[state][last];
            state = tmp;
        }
        reverse(nodes.begin(),nodes.end());
        string res = "";
        res += A[nodes[0]];
        for(int i=1;i<n;i++){
            int len = graph[nodes[i-1]][nodes[i]];
            res += A[nodes[i]].substr(A[nodes[i]].size()-len,len);
        }
        return res;
    }
private:
    int calCost(vector<string>& A,int i,int j){
        for(int pos=max((int)(A[i].size()-A[j].size()),0);pos<A[i].size();++pos){
            if(A[j].find(A[i].substr(pos))==0){
                return A[j].size()-(A[i].size()-pos);
            }
        }
        return A[j].size();
    }
};