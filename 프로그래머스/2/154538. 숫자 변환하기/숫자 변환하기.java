import java.util.*;

class Solution {
    class Data{
        int y;
        int cnt;
        
        public Data(int y, int cnt){
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    Queue<Data> queue = new LinkedList<>();
    
    public int solution(int x, int y, int n) {
        queue.offer(new Data(y, 0));
        
        while(!queue.isEmpty()){
            Data temp = queue.poll();
            
            if(temp.y == x) return temp.cnt;
            
            if(temp.y % 2 == 0 && temp.y * 2 >= x) queue.offer(new Data(temp.y / 2, temp.cnt+1));
            
            if(temp.y % 3 == 0 && temp.y / 3 >= x) queue.offer(new Data(temp.y / 3, temp.cnt+1));
                
            if(temp.y - n >= x) queue.offer(new Data(temp.y - n, temp.cnt+1));
        }
        
        return -1;
    }
}