class Solution {
    String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words){
            String morse = morseCode(word);
            if(!set.contains(morse)) set.add(morse);
        }
        return set.size();
    }
    private String morseCode(String word){
        String res = "";
        for(char c : word.toCharArray()){
            res+=table[c-'a'];
        }
        return res;
    }
}