class Solution {
public:
    string toGoatLatin(string S) {
        S+=" ";
        string res = "";
        string temp = "";
        int words = 0;
        for(int i=0;i<S.size();i++){
            if(S[i]==' '){
                res+=wordToGoatLatin(temp,words++);
                if(i!=S.size()-1) res+=" ";
                temp = "";
            }else{
                temp += S[i];
            }
        }
        return res;
    }
private:
    string wordToGoatLatin(string S,int index){
        char s = S[0];
        if(!(s=='a'||s=='A'||s=='e'||s=='E'||s=='i'||s=='I'||s=='o'||s=='O'||s=='u'||s=='U')){
            S = S.substr(1)+S[0];
        }
        S+="ma";
        for(int i=0;i<=index;i++){
            S+='a';
        }
        return S;
    }
};