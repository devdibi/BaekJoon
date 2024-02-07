/*
    풀이
        BFS를 활용해서 최단거리를 구한다.
*/

import java.util.*;

class Solution {
    public class Loc{
        int r, c;
        int d;
        
        public Loc(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    Queue<Loc> queue = new LinkedList<>();
    
    int[] r = {-1,0,0,1};
    int[] c = {0,-1,1,0};
    
    int[][] map;
    boolean[][] visited;
    
    int n, m;
    public int solution(int[][] maps) {
        map = maps;
        
        n = map.length;
        m = map[0].length;
        
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 1){
                    visited[i][j] = true;
                }
            }
        }
        
        int result = move().d;
        
        return result;
    }
    public Loc move(){
        queue.offer(new Loc(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Loc temp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = temp.r + r[i];
                int nc = temp.c + c[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                
                if(visited[nr][nc]) continue;
                
                if(nr == n-1 && nc == m-1) return new Loc(nr,nc,temp.d+1);
                
                visited[nr][nc] = true;
                queue.offer(new Loc(nr,nc,temp.d + 1));
            }
        }
        return new Loc(0,0,-1);
    }
}