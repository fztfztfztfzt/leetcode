class Solution {
public:
    int knightDialer(int N) {
        int res[] = {1,1,1,1,1,1,1,1,1,1};
        int tmp[10];
        vector<vector<int>> map(10);
        init(map);
        for(int i=1;i<N;i++){
            for(int j=0;j<10;j++){
                tmp[j]=0;
                for(auto next : map[j]){
                    tmp[j]=(tmp[j]+res[next])%1000000007;
                }
            }
            for(int j=0;j<10;j++) res[j]=tmp[j];
            //for(int j=0;j<10;j++) printf("%d %d\n",j,res[j]);
        }
        int sum = 0;
        for(int i=0;i<10;i++) sum=(sum+res[i])%1000000007;
        return sum;
    }
private:
    
    void init(vector<vector<int>>& map){
        map[0].push_back(4);
        map[0].push_back(6);
        map[1].push_back(6);
        map[1].push_back(8);
        map[2].push_back(7);
        map[2].push_back(9);
        map[3].push_back(4);
        map[3].push_back(8);
        map[4].push_back(3);
        map[4].push_back(9);
        map[4].push_back(0);
        map[6].push_back(1);
        map[6].push_back(7);
        map[6].push_back(0);
        map[7].push_back(2);
        map[7].push_back(6);
        map[8].push_back(1);
        map[8].push_back(3);
        map[9].push_back(2);
        map[9].push_back(4);

    }
};
