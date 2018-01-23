class Solution {
    char[][] board;
    int n;int m;
    boolean result;
    boolean[][] visit;
    char[] word;
    int l; 
    public boolean exist(char[][] b, String w) {
        board=b;
        if(board==null)  return false;
        n = board.length;
        if(n==0) return false;
        m = board[0].length;   
        l=w.length();word=w.toCharArray();
        result=false;
        visit = new boolean[n][m];
        for(int i=0;i<n;i++) Arrays.fill(visit[i],false);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word[0]){
                    visit[i][j]=true;
                    dfs(i,j,0);
                    visit[i][j]=false;
                }
                if(result) return result;
            }
        }
        return result;
    }
    private void dfs(int i,int j,int k){
        if(result) return;
        if(k==l-1){
            result=true;
            return;
        }
        if(ok(i-1,j,word[k+1])){
            //System.out.println("1");
            visit[i-1][j]=true;
            dfs(i-1,j,k+1);
            visit[i-1][j]=false;
        }
        if(result) return;
        if(ok(i+1,j,word[k+1])){
            //System.out.println("2");
            visit[i+1][j]=true;
            dfs(i+1,j,k+1);
            visit[i+1][j]=false;
        }
        if(result) return;
        if(ok(i,j-1,word[k+1])){
            //System.out.println("3");
            visit[i][j-1]=true;
            dfs(i,j-1,k+1);
            visit[i][j-1]=false;
        }
        if(result) return;
        if(ok(i,j+1,word[k+1])){
            //System.out.println("4");
            visit[i][j+1]=true;
            dfs(i,j+1,k+1);
            visit[i][j+1]=false;
        }
    }
    private boolean ok(int i,int j,char t){
        if(i>=0&&i<n&&j>=0&&j<m&&visit[i][j]==false&&board[i][j]==t) return true;
        return false;
    }
}

class Solution { 
    char[][] board;
    int n;
    int m;
    char[] word;
    int l;
    public boolean exist(char[][] b, String w) {
        n = b.length;
        m = b[0].length;
        l = w.length();
        word = w.toCharArray();
        board = b;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,int k){
        if(k==l) return true;
        if(i<0||i>=n||j<0||j>=m) return false;
        if(board[i][j]!=word[k]) return false;
        board[i][j]^=256;
        boolean temp = dfs(i-1,j,k+1)||dfs(i+1,j,k+1)||dfs(i,j-1,k+1)||dfs(i,j+1,k+1);
        board[i][j]^=256;
        return temp;
    }
}