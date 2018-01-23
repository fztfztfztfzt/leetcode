class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if(p.length!=s.length) return false;
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        for(int i=0;i<p.length;i++){
            String t1 = map1.get(p[i]);
            Character t2 = map2.get(s[i]);
            if(t1==null&&t2==null){
                map1.put(p[i],s[i]);
                map2.put(s[i],p[i]);
            }else if(t1!=null&&t1.equals(s[i])&&t2!=null&&t2==p[i]){
                continue;
            }else return false;
        }
        return true;
    }
}