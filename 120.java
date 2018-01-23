class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) return 0;
        int n = triangle.size();
        if(n==0) return 0;
        int[] result = new int[n];
        result[0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            result[i]=result[i-1]+triangle.get(i).get(i);
            for(int j=i-1;j>0;j--){
                result[j]=Math.min(result[j],result[j-1])+triangle.get(i).get(j);
            }
            result[0] = result[0]+triangle.get(i).get(0);
            //System.out.println(Arrays.toString(result));
        }
        //System.out.println(Arrays.toString(result));
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,result[i]);
        }
        return min;
    }
}