class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> res;
        for(auto asteroid : asteroids){
            if(asteroid>0) res.push_back(asteroid);
            else{
                for(;;){
                    if(res.size()==0){
                        res.push_back(asteroid);
                        break;
                    }else{
                        int temp = res.back();
                        if(temp<0){
                            res.push_back(asteroid);
                            break;
                        }else if(temp==-asteroid){
                            res.pop_back();
                            break;
                        }else if(temp<-asteroid){
                            res.pop_back();
                        }else{
                            break;
                        }
                    }
                }
                
            }
        }
        return res;
    }
};
