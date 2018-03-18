class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int[] r1 = parse(eq[0]);
        int[] r2 = parse(eq[1]);
        int a = r1[0]-r2[0];
        int b = r2[1]-r1[1];
        System.out.println(Arrays.toString(r1));
        System.out.println(Arrays.toString(r2));
        if(a==0&&b!=0) return "No solution";
        else if(a==0&&b==0) return "Infinite solutions";
        else return "x="+(b/a);
    }
    private int[] parse(String eq){
        int[] res = new int[2];
        int i=0;
        int num = 0;
        int flag = 1;
        boolean bx=true;
        while(i<eq.length()){
            char c = eq.charAt(i);
            if(c=='x'){
                if(bx) num=1;
                res[0]+=(flag*num);
                num=0;
                if(i==eq.length()-1) break;
                flag=(eq.charAt(i+1)=='-')?-1:1;
                i++;
                bx=true;
            }else if(c=='+'){
                res[1]+=(flag*num);
                num=0;
                flag=1;
                bx=true;
            }else if(c=='-'){
                res[1]+=(flag*num);
                num=0;
                flag = -1;
                bx=true;
            }else{
                bx=false;
                num = 10*num+(c-'0');
            }
            i++;
        }
        if(num!=0) res[1]+=(flag*num);
        return res;
    }
}

public String solveEquation(String equation) {
    int[] res = evaluateExpression(equation.split("=")[0]),  
  	  res2 = evaluateExpression(equation.split("=")[1]);
    res[0] -= res2[0];
    res[1] = res2[1] - res[1];
    if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
    if (res[0] == 0) return "No solution";
    return "x=" + res[1]/res[0];
}  

public int[] evaluateExpression(String exp) {
    String[] tokens = exp.split("(?=[-+])"); 
    int[] res =  new int[2];
    for (String token : tokens) {
        if (token.equals("+x") || token.equals("x")) res[0] += 1;
	else if (token.equals("-x")) res[0] -= 1;
	else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
	else res[1] += Integer.parseInt(token);
    }
    return res;
}
