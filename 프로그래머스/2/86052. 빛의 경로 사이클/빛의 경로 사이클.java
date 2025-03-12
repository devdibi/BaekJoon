import java.util.*;

public class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        
        boolean[][][] visited = new boolean[rows][cols][4];
        
        List<Integer> cycles = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (visited[i][j][dir]) continue;
                    
                    int cycleLength = 0;
                    int x = i, y = j, direction = dir;
                    
                    while (!visited[x][y][direction]) {
                        visited[x][y][direction] = true;
                        cycleLength++;
                        
                        x = (x + dx[direction] + rows) % rows;
                        y = (y + dy[direction] + cols) % cols;
                        
                        char ch = grid[x].charAt(y);
                        if (ch == 'L') {
                            direction = (direction + 3) % 4;
                        } else if (ch == 'R') {
                            direction = (direction + 1) % 4; 
                        }
                    }
                    
                    if (cycleLength > 0) {
                        cycles.add(cycleLength);
                    }
                }
            }
        }
        
        return cycles.stream().sorted().mapToInt(i -> i).toArray();
    }
}