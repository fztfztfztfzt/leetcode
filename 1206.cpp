#define MAXLEVEL 16
class Skiplist {
public:
    Skiplist() {
        head = new Skipnode(0);
        level = -1;
    }
    
    bool search(int target) {
        Skipnode* node = head;
        for(int i=level;i>=0;--i){
            while(node->next[i]!=nullptr&&node->next[i]->val<target)
                node = node->next[i];
        }
        node = node->next[0];
        if(node!=nullptr&&node->val==target) return true;
        return false;
    }
    
    void add(int num) {
        Skipnode* update[MAXLEVEL];
        Skipnode* node = head;
        for(int i=level;i>=0;--i){
            while(node->next[i]!=nullptr&&node->next[i]->val<num)
                node = node->next[i];
            update[i] = node;
        }
        node = node->next[0];
        if(node!=nullptr&&node->val==num){
            node->count++;
            return;
        }
        int randlevel = rand()%MAXLEVEL;
        if(randlevel>level){
            randlevel = ++level;
            update[randlevel] = head;
        }
        Skipnode* newnode = new Skipnode(num);
        for(int i=level;i>=0;--i){
            newnode->next[i] = update[i]->next[i];
            update[i]->next[i] = newnode;
        }
    }
    
    bool erase(int num) {
        Skipnode* update[MAXLEVEL];
        Skipnode* node = head;
        for(int i=level;i>=0;--i){
            while(node->next[i]!=nullptr&&node->next[i]->val<num)
                node = node->next[i];
            update[i] = node;
        }
        node = node->next[0];
        if(node==nullptr||node->val!=num) return false;
        if(node->count>1){
            node->count--;
            return true;
        }
        for(int i=0;i<=level;++i){
            if(update[i]->next[i]!=node) break;
            update[i]->next[i] = node->next[i];
        }
        delete node;
        while(level>=0&&head->next[level]==nullptr) --level;
        return true;
    }
private:
    struct Skipnode{
        int val;
        int count;
        Skipnode* next[MAXLEVEL];
        Skipnode(int a){
            val = a;
            count = 1;
            for(int i=0;i<MAXLEVEL;++i) next[i]=nullptr;
        }
    };
    int level;
    Skipnode* head;
};

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist* obj = new Skiplist();
 * bool param_1 = obj->search(target);
 * obj->add(num);
 * bool param_3 = obj->erase(num);
 */
