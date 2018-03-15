class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            String s = words[i];
            for(char c : s.toCharArray()){
                value[i]|=(1<<(c-'a'));
            }
        }
        int max = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((value[i]&value[j])==0&&words[i].length()*words[j].length()>max)
                    max = words[i].length()*words[j].length();
            }
        }
        return max;
    }
}