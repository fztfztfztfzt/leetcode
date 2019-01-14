class Solution {
public:
    double knightProbability(int N, int K, int r, int c) {
        double ***map = new double**[N];
        for(int i=0;i<N;i++){
            map[i] = new double*[N];
            for(int j=0;j<N;j++){
                map[i][j] = new double[K];
                for(int k=0;k<K;k++){
                    map[i][j][k] = -1;
                }
            }
        }
        return knightProbability(N,K,r,c,map);
    }
    double knightProbability(int N, int K, int r, int c, double*** map){
        if(!inBoard(N,r,c)) return 0;
        if(K==0) return 1;
        if(map[r][c][K-1]>=0) return map[r][c][K-1];
        double res = 0;
        res += knightProbability(N,K-1,r-1,c-2,map);
        res += knightProbability(N,K-1,r-2,c-1,map);
        res += knightProbability(N,K-1,r+1,c-2,map);
        res += knightProbability(N,K-1,r+2,c-1,map);
        res += knightProbability(N,K-1,r-1,c+2,map);
        res += knightProbability(N,K-1,r-2,c+1,map);
        res += knightProbability(N,K-1,r+1,c+2,map);
        res += knightProbability(N,K-1,r+2,c+1,map);
        res /= 8.0;
        //printf("%d %d %d %f",K,r,c,res);
        map[r][c][K-1] = res;
        return res;
    }
private:
    int inBoard(int N,int r,int c){
        if(r<0||c<0||r>=N||c>=N) return 0;
        else return 1;
    }
};
