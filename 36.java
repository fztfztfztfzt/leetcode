class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] cell = new int[9];
        int[] col = new int[9];
        int temp;
        for(int i=0;i<9;i++){
            Arrays.fill(row,0);Arrays.fill(col,0);Arrays.fill(cell,0);
            for(int j=0;j<9;j++){
                //row
                temp = (int)(board[i][j]-48)-1;
                if((temp>=0)&&(temp<9)){
                    if(row[temp]==1) return false;
                    row[temp] = 1;
                }
                //System.out.println("col");
                temp = (int)(board[j][i]-48)-1;
                if((temp>=0)&&(temp<9)){
                    if(col[temp]==1) return false;
                    col[temp] = 1;
                }
                //System.out.println("cell");
                temp = (int)(board[(i/3)*3+j/3][(i%3)*3+j%3]-48)-1;
                if((temp>=0)&&(temp<9)){
                    if(cell[temp]==1) return false;
                    cell[temp] = 1;
                }
            }
        }
        return true;
    }
}