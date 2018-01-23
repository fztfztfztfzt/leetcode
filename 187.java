class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set result = new HashSet();
        if(s.length()<10) return new ArrayList(result);
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int v = 0;
        for(int i=0;i<s.length()-9;i++){
            if(i==0){
                for(int j=0;j<10;j++) {
                    v <<= 2;
                    v |= map[s.charAt(j)-'A'];
                }
            }else{
                v = (v&0x3ffff);
                v <<= 2;
                v |= map[s.charAt(i+9)-'A'];
            }
            if(!words.add(v)) {
                result.add(s.substring(i,i+10));
            }
        }
        return new ArrayList(result);
    }
}