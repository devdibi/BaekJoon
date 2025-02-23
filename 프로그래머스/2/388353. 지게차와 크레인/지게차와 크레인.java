import java.util.*;

class Solution {
    int[][] map;
    int rows;
    int cols;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    
    
    public int solution(String[] storage, String[] requests) {
        rows = storage.length;
        cols = storage[0].length();
        map = new int[rows + 2][cols + 2];
        
        for(int i = 1; i < rows + 1; i++) {
            char[] line = storage[i-1].toCharArray();
            for(int j = 1; j < cols + 1; j++) {
                map[i][j] = line[j-1];
            }
        }
        
        int result = rows * cols;
        
        for(String t : requests) {
            if(t.length() > 1) {
                result -= crain((int) t.charAt(0));
                
            } else {
                result -= lift((int) t.charAt(0));
                
            }
        }
        
        return result;
    }
    
    public int crain(int t) {
        int cnt = 0;
        for(int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < cols + 1; j++){
                if(map[i][j] == t) {
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }

    public int lift(int t) {
        int cnt = 0;

        int[][] temp = new int[rows + 2][cols + 2];
        for(int i = 0; i < rows + 2; i++) {
            temp[i] = Arrays.copyOf(map[i], cols + 2);
        }

        for(int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < cols + 1; j++) {
                if(map[i][j] == t) {
                    boolean isAccessible = false;
                    for(int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(temp[nx][ny] == 0 && isConnectedToOutside(nx, ny, temp)) {
                            isAccessible = true;
                            break;
                        }
                    }
                    if(isAccessible) {
                        map[i][j] = 0;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private boolean isConnectedToOutside(int x, int y, int[][] temp) {
        if(x == 0 || x == rows + 1 || y == 0 || y == cols + 1) return true;

        boolean[][] visited = new boolean[rows + 2][cols + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == 0 || current[0] == rows + 1 || 
               current[1] == 0 || current[1] == cols + 1) {
                return true;
            }

            for(int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if(nx >= 0 && nx <= rows + 1 && ny >= 0 && ny <= cols + 1 
                   && temp[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return false;
}
}