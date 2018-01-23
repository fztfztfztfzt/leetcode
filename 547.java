import java.util.Arrays;
class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int[] s = new int[N];
        Arrays.fill(s,0);
        int count = 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        int temp;
        s[0]=count;
        while(true){
            while(queue.peek()!=null){
                temp = queue.poll();
                for(int i=0;i<N;i++){
                    if((i!=temp)&&(M[temp][i]==1)&&(s[i]==0)){
                        queue.offer(i);
                        s[i]=count;
                    }
                }
            }
            temp = -1;
            for(int i=0;i<N;i++){
                if(s[i]==0){
                    temp = i;
                    break;
                }
            }
            if(temp==-1) return count;
            else{
                queue.offer(temp);
                count++;
                s[temp]=count;
            }
        }
    }
}


class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0] == null || M[0].length == 0){
            return 0;
        }
        int peoNum = M[0].length;
        boolean[] visited = new boolean[peoNum];
        int cc = 0;
        for(int i = 0; i < peoNum; i++){
            if(!visited[i]){
                explore(M, visited, i);
                cc += 1;
            }
        }
        return cc;
    }
    private void explore(int[][]M, boolean[] visited, int person){
        visited[person] = true;
        for(int j = 0; j < M[0].length; j++){
            if(M[person][j] == 1 && !visited[j]){
                explore(M, visited, j);
            }
        }
    }
    
}