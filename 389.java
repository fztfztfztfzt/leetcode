class Solution {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int result=0;
        for(int i=0;i<n;i++) result = result + (int)t.charAt(i) - (int)s.charAt(i);
        return (char)(result+t.charAt(n));
    }
}