class Solution {
    public int minSwapsCouples(int[] row) {
        int[] pos = new int[row.length];
        int res = 0;
        for(int i=0;i<row.length;i++) pos[row[i]]=i;
        for(int i=0;i<row.length;i+=2){
            //System.out.println(Arrays.toString(row));
            //System.out.println(Arrays.toString(pos));
            int dest = 0;
            if((row[i]&1)==0) dest = row[i]+1;
            else dest = row[i]-1;
            if(dest==row[i+1]) continue;
            res++;
            int temp  = row[i+1];
            row[i+1]=dest;
            row[pos[dest]] = temp;
            int temp2 = pos[temp];
            pos[temp] = pos[dest];
            pos[dest] = temp2;
        }
        return res;
    }
}