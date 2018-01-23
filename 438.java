class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0||p==null||p.length()==0) return result;
        int[] hash = new int[26];
        for(char c : p.toCharArray()){
            hash[(int)(c-'a')]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while(right<s.length()){
            if(hash[(int)(s.charAt(right++)-'a')]-->=1) count--;
            if(count==0) result.add(left);
            if(right-left==p.length() && hash[s.charAt(left++)-'a']++>=0) count++;
        }
        return result;
    }
}