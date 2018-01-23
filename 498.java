class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if(n==0) return new int[0];
        int m = matrix[0].length;
        int[] result = new int[n*m];
        int type = 1;
        int x = 0;
        int y = 0;
        for(int i=0;i<n*m;i++){
            //System.out.printf("%d %d\n",x,y);
            result[i]=matrix[x][y];
            if(type==1){
                if((x-1>=0)&&(y+1<m)){
                    x = x-1; y = y+1;
                }else{
                    type=0;
                    if(y==m-1){
                        x=x+1;
                    }else{
                        y=y+1;
                    }
                }
            }else{
                if((x+1<n)&&(y-1>=0)){
                    x = x+1; y=y-1;
                }else{
                    type=1;
                    if(x==n-1){
                        y=y+1;
                    }else{
                        x=x+1;
                    }
                }
            }
        }
        return result;
    }
}