class Solution {
public:
    bool isAdditiveNumber(string num) {
        if(num.size()<3) return false;
        int len = num.size();
        for(int i=1;i<len-1;i++){
            string num1 = num.substr(0,i);
            for(int j=i+1;j<len;j++){
                string num2 = num.substr(i,j-i);
                string num3 = num.substr(j);
                if(DFS(num1,num2,num3)) return true;
                if(num2[0]=='0') break;
            }
            if(num1[0]=='0') break;
        }
        return false;
    }
private:
    string add(string num1,string num2){
        int len1 = num1.size()-1;
        int len2 = num2.size()-1;
        string sum="";
        int flag=0;
        while(len1>=0||len2>=0){
            int val = 0;
            if(len1>=0){
                val+=num1[len1]-'0';
                len1--;
            }
            if(len2>=0){
                val+=num2[len2]-'0';
                len2--;
            }
            sum+=to_string((flag+val)%10);
            flag=(flag+val)/10;
        }
        if(flag) sum+='1';
        reverse(sum.begin(),sum.end());
        return sum;
    }
    bool DFS(string num1,string num2,string num3){
        if(num3.size()==0) return true;
        string sum = add(num1,num2);
        string str = num3.substr(0,sum.size());
        if(sum==str&&DFS(num2,str,num3.substr(sum.size()))) return true;
        return false;
    }
};