import java.util.*;

class Solution {
    public static class Loc{
        int x;
        int y;
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] map;
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    
    int rows;
    int cols;
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList();
        
        rows = maps.length;
        cols = maps[0].length();
        
        map = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            char[] line = maps[i].toCharArray();
            for(int j = 0; j < cols; j++) {
                if(line[j] == 'X') {
                    map[i][j] = 0;
                } else {                
                    map[i][j] = Integer.valueOf(line[j]) - 48;
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                if(map[i][j] == 0) continue;
                list.add(bfs(i, j));
            }
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        if(result.length == 0) return new int[]{-1};
        Arrays.sort(result);
        return result;
    }
    
    public int bfs(int x, int y) {
        int result = 0;
        
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(x,y));
        
        result += map[x][y];
        map[x][y] = 0;
        
        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            
            for(int i = 0; i < 4; i ++) {
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                    continue;
                }
                
                if(map[nx][ny] == 0) {
                    continue;
                }
                
                result += map[nx][ny];
                map[nx][ny] = 0;
                queue.add(new Loc(nx, ny));
            }
        }
        return result;
    }
}