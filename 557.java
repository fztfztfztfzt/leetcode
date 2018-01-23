class Solution {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(String item : array){
            if(first) first = false;
            else sb.append(" ");
            String temp = new StringBuffer(item).reverse().toString();
            sb.append(temp);
        }
        return sb.toString();
    }
}