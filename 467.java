class Solution {
    public int findSubstringInWraproundString(String p) {
        int sum = 0;
        int[] count = new int[26];
        char[] c = p.toCharArray();
        int len = 0;
        for(int i=0;i<c.length;i++){
            if(i>0&&(c[i]==c[i-1]+1||c[i]==c[i-1]-25)) len++;
            else len=1;
            count[c[i]-'a'] = Math.max(len,count[c[i]-'a']);
        }
        for(int i : count) sum+=i;
        return sum;
    }
}