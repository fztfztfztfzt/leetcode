class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length()/(2*k);
        int m = s.length()%(2*k);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=k-1;j>=0;j--) sb.append(s.charAt(i*2*k+j));
            for(int j=k;j<=2*k-1;j++) sb.append(s.charAt(i*2*k+j));
        }
        if(m<=k) for(int i=m-1;i>=0;i--) sb.append(s.charAt(n*2*k+i));
        else{
            for(int i=k-1;i>=0;i--) sb.append(s.charAt(n*2*k+i));
            for(int i=k;i<m;i++) sb.append(s.charAt(n*2*k+i));
        }
        return sb.toString();
    }
}