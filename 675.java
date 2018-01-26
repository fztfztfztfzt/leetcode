class Solution {
    int m;
    int n;
    int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        Heap heap = new Heap(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp = forest.get(i).get(j);
                if(temp!=0){
                    heap.add(new Tree(temp,i,j));
                }
            }
        }
        int x1 = 0;
        int y1 = 0;
        int x2,y2;
        int count=0;
        while(!heap.isEmpty()){
            Tree dis = heap.get();
            //System.out.printf("%d %d %d %d %d\n",dis.height,x1,y1,dis.x,dis.y);
            x2 = dis.x;
            y2 = dis.y;
            int r = distance(forest,x1,y1,x2,y2);
            if(r==Integer.MAX_VALUE) return -1;
            count += r;
            x1 = x2;
            y1 = y2;
        }
        return count;
    }
    private int distance(List<List<Integer>> forest,int x1,int y1,int x2,int y2){
        if(x1==x2&&y1==y2) return 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) dist[i][j]=Integer.MAX_VALUE;
        dist[x1][y1] = 0;
        queue.add(new int[]{x1,y1});
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int[] dir : dirs){
                int x = p[0];
                int y = p[1];
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&forest.get(nx).get(ny)!=0&&dist[nx][ny]>dist[x][y]+1){
                    dist[nx][ny] = dist[x][y]+1;
                    queue.add(new int[]{nx,ny});
                }
                if(nx==x2&&ny==y2){
                    return dist[nx][ny];
                }
            }
        }
        return dist[x2][y2];
    }
}

class Heap {
    Tree[] trees;
    int num;
    public Heap(){}
    public Heap(int s){
        trees = new Tree[s];
        num = 0;
    }
    public void add(Tree tree){
        trees[num++]=tree;
        up(num-1);
    }
    private void up(int i){
        if(i==0) return;
        if(trees[i].height<trees[(i-1)/2].height){
            Tree temp = trees[i];
            trees[i] = trees[(i-1)/2];
            trees[(i-1)/2] = temp;
            up((i-1)/2);
        }
    }
    public boolean isEmpty(){
        return num==0;
    }
    public Tree get(){
        Tree temp = trees[0];
        trees[0] = trees[--num];
        down(0);
        return temp;
    }
    private void down(int i){
        if((2*i+1>=num)&&(2*i+2>=num)) return;
        int h1 = trees[2*i+1].height;
        int h2;
        if(2*i+2==num) h2=Integer.MAX_VALUE; 
        else h2=trees[2*i+2].height;
        if(h1<h2){
            if(trees[i].height>h1){
                Tree temp = trees[i];
                trees[i] = trees[2*i+1];
                trees[2*i+1] = temp;
                down(2*i+1);
            }
        }else{
            if(trees[i].height>h2){
                Tree temp = trees[i];
                trees[i] = trees[2*i+2];
                trees[2*i+2] = temp;
                down(2*i+2);
            }
        }
    }
}

class Tree {
    int height;
    int x;
    int y;
    public Tree(int h,int i,int j){
        height = h;
        x = i;
        y = j;
    }
}