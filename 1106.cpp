class Solution {
public:
    bool parseBoolExpr(string expression) {
        stack<char> data;
        stack<char> op;
        for(char c : expression){
            if(c=='t'||c=='f'||c=='(') data.push(c);
            else if(c=='!'||c=='|'||c=='&') op.push(c);
            else if(c==')'){
                char o = op.top();op.pop();
                if(o=='!'){
                    char tmp = data.top();data.pop();data.pop();
                    if(tmp=='t') data.push('f');
                    else data.push('t');
                }else if(o=='|'){
                    char res = 'f';
                    char tmp = 'a';
                    while(tmp!='('){
                        tmp = data.top();data.pop();
                        if(tmp=='t') res = 't';
                    }
                    data.push(res);
                }else{
                    char res = 't';
                    char tmp = 'a';
                    while(tmp!='('){
                        tmp = data.top();data.pop();
                        if(tmp=='f') res = 'f';
                    }
                    data.push(res);
                }
            }else continue;
        }
        return data.top()=='t';
    }
};