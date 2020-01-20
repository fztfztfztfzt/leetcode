class Solution {
public:
    struct TrieNode{
        TrieNode* child[26];
        string s;
        TrieNode():s(""){
            for(auto &a : child) a=NULL;
        }
    };
    struct Trie{
        TrieNode* root;
        Trie():root(new TrieNode()){}
        void insert(string s){
            TrieNode* p = root;
            for(char c : s){
                int i = c-'a';
                if(!p->child[i]) p->child[i] = new TrieNode();
                p = p->child[i];
            }
            p->s = s;
        }
    };
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> res;
        if(words.empty()||board.empty()||board[0].empty()) return res;
        n = board.size();
        m = board[0].size();
        Trie T;
        for(string word : words){
            T.insert(word);
        }
        vector<vector<bool>> visited(n,vector<bool>(m,false));
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(T.root->child[board[i][j]-'a']){
                    search(board,T.root->child[board[i][j]-'a'],i,j,visited,res);
                }
            }
        }
        return res;
    }
private:
    int n,m;
    void search(vector<vector<char>>& board, TrieNode* root, int x, int y, vector<vector<bool>>& visited, vector<string>& res){
        if(!root->s.empty()){
            res.push_back(root->s);
            root->s = "";
        }
        int d[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};        
        visited[x][y]=true;
        for(int k=0;k<4;k++){
            int nx = x+d[k][0];
            int ny = y+d[k][1];
            if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]&&root->child[board[nx][ny]-'a'])
                search(board,root->child[board[nx][ny]-'a'],nx,ny,visited,res);
        }
        visited[x][y]=false;
    }
};
