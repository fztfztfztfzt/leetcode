class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return new ArrayList<Integer>();
        int n = matrix[0].length;
        Integer[] result = new Integer[n*m];
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m-1;
        int turn = 0;
        int i=0;
        int x=0;
        int y=0;
        while(i<n*m){
            result[i]=matrix[x][y];
            i++;
            if(turn==0){
                y++;
                if(y>right){
                    turn = 1;
                    up++;y--;x++;
                }
            }else if(turn==1){
                x++;
                if(x>down){
                    turn=2;
                    right--;x--;y--;
                }
            }else if(turn==2){
                y--;
                if(y<left){
                    turn=3;
                    down--;y++;x--;
                }
            }else if(turn==3){
                x--;
                if(x<up){
                    turn=0;
                    left++;x++;y++;
                }
            }
        }
        List<Integer> temp = Arrays.asList(result);
        return temp;
    }
}