class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n-1;
        int up=0;
        int down = n-1;
        int turn=0;
        int x=0;
        int y=0;
        int i=1;
        while(i<=n*n){
            result[x][y]=i;i++;
            if(turn==0){
                y++;
                if(y>right){
                    y--;x++;up++;turn=1;
                }
            }else if(turn==1){
                x++;
                if(x>down){
                    x--;y--;right--;turn=2;
                }
            }else if(turn==2){
                y--;
                if(y<left){
                    y++;x--;down--;turn=3;
                }
            }else if(turn==3){
                x--;
                if(x<up){
                    x++;y++;left++;turn=0;
                }
            }
        }
        return result;
    }
}