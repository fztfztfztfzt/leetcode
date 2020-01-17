class Solution {
public:
    string numberToWords(int num) {
        if(num==0) return "Zero";
        string res = hundredToWords(num%1000);
        vector<string> v = {"Thousand", "Million", "Billion"};
        for(int i=0;i<3;i++){
            num/=1000;
            if(num==0) break;
            if(num%1000!=0) res = hundredToWords(num%1000)+" "+v[i]+" "+res;
        }
        while(res.back()==' ') res.pop_back();
        return res;
    }
private:
    string hundredToWords(int num) {
        vector<string> v1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> v2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        string res = "";
        int a = num/100;
        int bc = num%100;
        int b = bc/10;
        int c = num%10;
        if(a!=0) res = v1[a]+" Hundred"+(bc==0?"":" ");
        if(bc<20) res += v1[bc];
        else if(c!=0) res += v2[b]+" "+v1[c];
        else res += v2[b];
        return res;
    }
};
