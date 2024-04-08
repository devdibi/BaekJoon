import java.util.*;

class Solution {
    public class Loc{
        int r,c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // 2차원 배열로 변경
        map = new int[m][n];
        int idx = 0;
        
        for(String s : board){
            char[] temp = s.toCharArray();
            
            for(int i = 0; i < n; i++){
                map[idx][i] = (int)temp[i];
            }
            idx++;
        }
        
        while(true){
            // 왼쪽 상단 index로 완전탐색
            Queue<Loc> queue = new LinkedList<>();

            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    if(map[i][j] == 0) continue;
                    if(map[i][j] - map[i+1][j] != 0) continue;
                    if(map[i][j] - map[i][j+1] != 0) continue;
                    if(map[i][j] - map[i+1][j+1] != 0) continue;

                    queue.offer(new Loc(i,j));
                }
            }

            // 변경 X
            if(queue.isEmpty()) return answer;

            // 지우기
            while(!queue.isEmpty()){
                Loc loc = queue.poll();
                int r = loc.r;
                int c = loc.c;
                
                if(map[r][c] != 0) answer++;
                if(map[r+1][c] != 0) answer++;
                if(map[r][c+1] != 0) answer++;
                if(map[r+1][c+1] != 0) answer++;
                
                map[r][c] = 0;
                map[r+1][c] = 0;
                map[r][c+1] = 0;
                map[r+1][c+1] = 0;

            }

            // 당기기
            for(int i = 0; i < n; i++){
                Stack<Integer> stack = new Stack<>();
                for(int j = 0; j < m; j++){
                    if(map[j][i] != 0) stack.push(map[j][i]);
                }

                idx = m - 1;

                while(!stack.isEmpty()){
                    map[idx--][i] = (int)stack.pop();
                }

                while(idx >= 0){
                    map[idx--][i] = 0;
                }
            }
        }
    }
    
    
}