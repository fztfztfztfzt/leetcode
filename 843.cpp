/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Master {
 *   public:
 *     int guess(string word);
 * };
 */
class Solution {
public:
    void findSecretWord(vector<string>& wordlist, Master& master) {
        for(int i=0;i<10;i++){
            if(wordlist.size()==0) return;
            string target = wordlist[rand()%wordlist.size()];
            int res = master.guess(target);
            vector<string> wd2;
            for(int j=0;j<wordlist.size();j++){
                if(match(target,wordlist[j])==res){
                    wd2.push_back(wordlist[j]);
                }
            }
            wordlist = wd2;
        }
    }
    int match(string a, string b){
        int res = 0;
        for(int i=0;i<a.size();i++){
            if(a[i]==b[i]) res++;
        }
        return res;
    }
};
