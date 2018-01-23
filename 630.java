class Solution {
    void qsort(int l , int r , int[][] courses){   
        int i = l, j = r, mid = courses[(l+r)/2][1];
        while (i<j){
            while (courses[i][1]<mid) i++;
            while (courses[j][1]>mid) j--;
            if (i<=j){
                int[] tmp = courses[i];
                courses[i] = courses[j];
                courses[j] = tmp;
                i++;
                j--;
            }
        }
        if (i<r) qsort(i,r,courses);
        if (j>l) qsort(l,j,courses);
    }
    public int scheduleCourse(int[][] courses) {
        //Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        int len = courses.length;
        qsort(0,len-1,courses);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int time=0;
        for(int[] c : courses){
            time+=c[0];
            queue.offer(c[0]);
            if(time>c[1]) time-=queue.poll();
        }
        return queue.size();
    }
}

class Solution {
    void qsort(int l , int r , int[][] courses){   
        int i = l, j = r, mid = courses[(l+r)/2][1];
        while (i<j){
            while (courses[i][1]<mid) i++;
            while (courses[j][1]>mid) j--;
            if (i<=j){
                int[] tmp = courses[i];
                courses[i] = courses[j];
                courses[j] = tmp;
                i++;
                j--;
            }
        }
        if (i<r) qsort(i,r,courses);
        if (j>l) qsort(l,j,courses);
    }
    public int scheduleCourse(int[][] courses) {
        int len = courses.length;
        qsort(0,len-1,courses);
        //Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        int[] queue = new int[len];
        int sum = 0;
        int mark = 0;
        for (int i = 0;i<len;i++){
            if (sum+courses[i][0]<=courses[i][1]){
                sum+=courses[i][0];
                queue[mark++] = courses[i][0];
                int now = mark-1;
                while ((now+1)/2-1>=0&&queue[now]>queue[(now+1)/2-1]){
                    int tmp = queue[now];
                    queue[now] = queue[(now+1)/2-1];
                    queue[(now+1)/2-1] = tmp;
                    now = (now+1)/2-1;
                }
            }else{
                if (queue[0]>courses[i][0]){
                    sum+=courses[i][0]-queue[0];
                    queue[0] = courses[i][0];
                    int now = 0;
                    while (((now+1)*2<mark&&queue[now]<queue[(now+1)*2])||((now+1)*2-1<mark&&queue[now]<queue[(now+1)*2-1])){
                        if ((now+1)*2<mark){
                            if (queue[(now+1)*2-1]>queue[(now+1)*2]){
                                int tmp = queue[(now+1)*2-1];
                                queue[(now+1)*2-1] = queue[now];
                                queue[now] = tmp;
                                now = (now+1)*2-1;
                            }else{
                                int tmp = queue[(now+1)*2];
                                queue[(now+1)*2] = queue[now];
                                queue[now] = tmp;
                                now = (now+1)*2;
                            }
                        }else{
                            int tmp = queue[(now+1)*2-1];
                                queue[(now+1)*2-1] = queue[now];
                                queue[now] = tmp;
                                now = (now+1)*2-1;
                        }
                    }
                }
            }
        }
        return mark;
    }
}