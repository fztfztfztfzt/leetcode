class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] alpha = new int[26];
        for(char c : tasks){
            alpha[c-'A']++;
        }
        Arrays.sort(alpha);
        int i = 25;
        while(i>=0&&alpha[i]==alpha[25]) i--;
        return Math.max(tasks.length,(alpha[25]-1)*(n+1)+25-i);
    }
}