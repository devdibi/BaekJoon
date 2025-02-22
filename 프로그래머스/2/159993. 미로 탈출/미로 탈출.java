import java.util.*;

class Solution {
    
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};
    
    public class Cur {
        int x, y, d;
        
        public Cur(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int solution(String[] maps) {
        Cur start = null, end = null, key = null;
        int rows = maps.length;
        int cols = maps[0].length();
        int[][] map = new int[rows][cols];
        
        // 지도
        for(int i = 0; i < rows; i++) {
            char[] line = maps[i].toCharArray();
            for(int j = 0; j < cols; j++) {
                switch(line[j]) {
                    case 'O' : map[i][j] = 0; break; 
                    case 'X' : map[i][j] = -1; break;
                    case 'L' : {
                        map[i][j] = 0; 
                        key = new Cur(i, j, 0);
                        break;
                    }
                    case 'E' : {
                        map[i][j] = 0; 
                        end = new Cur(i, j, 0);
                        break;
                    }
                    case 'S' : {
                        map[i][j] = 0;
                        start = new Cur(i, j, 0);
                        break;
                    }
                }
            }
        }
        
        int lever = bfs(start, key, map, rows, cols);
        if(lever == -1) return -1;
        
        int exit = bfs(key, end, map, rows, cols);
        if(exit == -1) return -1;
        
        return lever + exit;
    }
    
    public int bfs(Cur start, Cur target, int[][] map, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cur> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            Cur cur = queue.poll();
            
            if(cur.x == target.x && cur.y == target.y) {
                return cur.d;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;
                
                if(map[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Cur(nx, ny, cur.d + 1));
                }
            }
        }
        return -1;
    }
}