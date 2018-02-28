class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int init = 0;
        for(int i=0;i<2;i++) for(int j=0;j<3;j++) init = init*10+board[i][j];
        set.add(init);
        queue.offer(init);
        int result = 0;
        int zero = 0;
        int[] poses = {1,-1,3,-3};
        while(!queue.isEmpty()){
            int d = queue.size();
            for(int i=0;i<d;i++){
                int data = queue.poll();
                if(data==123450) return result;
                zero = whereIsZero(data);
                for(int pos : poses){
                    int x = zero+pos;
                    if(x<0||x>5||zero==2&&x==3||zero==3&&x==2) continue;
                    int c = (data/pow(5-x))%10;
                    int n = data+pow(5-zero)*c-c*pow(5-x);
                    if(set.add(n)) queue.offer(n);
                }
            }
            result++;
        }
        return -1;
    }
    private int whereIsZero(int data){
        int i = 5;
        int d = data%10;
        while(d!=0){
            data/=10;
            d = data%10;
            i--;
        }
        return i;
    }

    private int pow(int p){
        int i = 1;
        while(p>0){
            p--;
            i*=10;
        }
        return i;
    }
}