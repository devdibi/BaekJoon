/*
    풀이
        모든 경우를 탐색하고 가장 많은 던전을 탐험할 수 있는 경우의 수를 구한다.
        

*/

import java.util.*;

class Solution {
    int[][] d;
    int t;
    int[] select;
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        // 전역변수화
        d = dungeons;
        t = k;
        
        select = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        
        dfs(0);
        return answer;
    }
    
    public void dfs(int cnt){
        if(cnt == d.length){
            int result = 0;
            int total = t;
            
            for(int i : select){
                if(total < d[i][0]) continue;
                
                total -= d[i][1];
                result++;
            }
            answer = Math.max(answer, result);
            return;
        }
        
        for(int i = 0; i < select.length; i++){
            if(visited[i]) continue;
            select[cnt] = i;
            visited[i] = true;
            dfs(cnt+1);
            select[cnt] = 0;
            visited[i] = false;
        }
    }
}