class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        /*
        int[][] result = new int[people.length][2];
        for(int i=0;i<people.length;i++){
            for(int j=i-1;j>=people[i][1];j--){
                result[j+1]=result[j];
            }
            result[people[i][1]]=people[i];
        }
        return result;
        */
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[result.size()][]);
    }
}