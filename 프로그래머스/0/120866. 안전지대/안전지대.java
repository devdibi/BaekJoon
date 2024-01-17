import java.util.*;

class Solution {
    public class Loc{
        int r,c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    int[][] map;
    public int solution(int[][] board) {
        map = board;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1){
                    queue.offer(new Loc(i,j));
                }
            }
        }
        
        change();
        
        int cnt = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    Queue<Loc> queue = new ArrayDeque<>();
    int[] r = {-1,-1,0,1,1,1,0,-1};
    int[] c = {0,1,1,1,0,-1,-1,-1};
    public void change(){
        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            
            for(int i = 0; i < 8; i++){
                if(loc.r + r[i] < 0 || loc.c + c[i] < 0 || loc.r + r[i] >= map.length || loc.c + c[i] >= map.length) continue;
                map[loc.r + r[i]][loc.c + c[i]] = 1;
            }
        }
   }
}