class Solution {
    int n;
    int m;
    public int[][] imageSmoother(int[][] M) {
        if(M==null) return null;
        n=M.length;
        m=M[0].length;
        
        int[][] result = new int[n][m];
        int num=0;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                num=0;
                sum=0;
                for(int a=-1;a<=1;a++){
                    for(int b=-1;b<=1;b++){
                        if(isValid(i+a,j+b)){
                            num++;
                            sum+=M[i+a][j+b];
                        }
                    }
                }
                result[i][j]=sum/num;
            }
        }
        
        return result;
    }
    private boolean isValid(int i,int j){
        return i>=0&&i<n&&j>=0&&j<m;
    }
}