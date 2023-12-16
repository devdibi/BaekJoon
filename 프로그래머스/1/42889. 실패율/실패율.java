import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(int N, int[] stages) {
        int player = stages.length;
        
        // 모든 스테이지 map 추가
        for(int i = 1; i <= N+1; i++){
            map.put(i,0);
        }
        
        for(int stage: stages){
            map.put(stage, map.get(stage) + 1);
        }
        
        double[][] pers = new double[N+1][2];
        
        int played = 0;
        pers[0][1] = Double.MAX_VALUE;
        
        for(int i = 1; i <= N; i++){
            if(map.get(i) == 0){
                pers[i][0] = i;
                pers[i][1] = 0;
                continue;
            }
            
            double per = (double)map.get(i) / (double)(player-played);
            played += map.get(i);
            
            pers[i][0] = i;
            pers[i][1] = per;
        }
        
        // score 정렬 기준 -> 실패율(내림차순) -> 스테이지 번호(오름차순)
        Arrays.sort(pers, Comparator
                .comparingDouble((double[] arr) -> arr[1]).reversed()
                .thenComparingDouble(arr -> arr[0]));
        
        int[] answer = new int[N];
        for(int i = 1; i <= N; i++){
            answer[i-1] = (int)pers[i][0];
        }
        
        return answer;
    }
}