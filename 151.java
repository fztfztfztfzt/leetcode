public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] a = s.trim().split(" +");
        for(int i=a.length-1;i>=0;i--){
            sb.append(a[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}