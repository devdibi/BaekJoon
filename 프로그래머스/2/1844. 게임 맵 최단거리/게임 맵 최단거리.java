/*
    풀이
        BFS를 활용해서 최단거리를 구한다.
*/

import java.util.*;

class Solution {
    // 위치 저장 클래스
    public class Loc{
        int r, c; // 행, 렬
        int d; // 이동 거리
        
        public Loc(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    // BFS를 위한 큐
    Queue<Loc> queue = new LinkedList<>();
    
    // 상, 하, 좌, 우
    int[] r = {-1,0,0,1}; 
    int[] c = {0,-1,1,0};
    
    
    int[][] map; // 지도 정보
    boolean[][] visited; // 방문배열
    int n, m; // 지도 크기
    public int solution(int[][] maps) {
        map = maps;
        n = map.length;
        m = map[0].length;
        visited = new boolean[n][m];
        
        // 이동하지 못하는 위치 표시
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 1){
                    visited[i][j] = true;
                }
            }
        }
        
        // BFS 수행
        int result = bfs().d;
        
        return result;
    }
    public Loc bfs(){
        // 최초 시작 위치
        queue.offer(new Loc(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Loc temp = queue.poll(); // 이동 전 위치
            for(int i = 0; i < 4; i++){
                // 이동 후 위치
                int nr = temp.r + r[i];
                int nc = temp.c + c[i];
                
                // 범위 밖
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                
                // 방문 여부 확인
                if(visited[nr][nc]) continue;
                
                // 종료 여부 확인
                if(nr == n-1 && nc == m-1) return new Loc(nr,nc,temp.d+1);
                
                visited[nr][nc] = true; // 방문 체크
                queue.offer(new Loc(nr,nc,temp.d + 1)); // 다음 위치 등록
            }
        }
        return new Loc(0,0,-1);
    }
}