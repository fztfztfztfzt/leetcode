class KthLargest {
public:
    KthLargest(int k, vector<int> nums) {
        data = new int[k];
        tempData = nums;
        len = k;
        flag = true;
    }
    void adjust(int i) {
        int l = (i<<1)+1;
        int r = ((i+1)<<1);
        int min = i;
        if(l<len&&data[l]<data[min]) min=l;
        if(r<len&&data[r]<data[min]) min=r;
        if(min==i) return;
        int temp = data[i];
        data[i] = data[min];
        data[min] = temp;
        adjust(min);
    }
    
    int add(int val) {
        if(flag){
            flag=false;
            tempData.push_back(val);
            sort(tempData.begin(),tempData.end());
            for(int i=0;i<len;i++)
                data[i] = tempData[tempData.size()-len+i];
        }else{
            if(val>data[0]){
                data[0] = val;
                adjust(0);
            }
        }
        return data[0];
    }
private:
    int *data;
    vector<int> tempData;
    int len;
    bool flag;
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
