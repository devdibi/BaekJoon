import java.util.*;

class Solution {    
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        
        List<Integer> list = new ArrayList<>();
        
        int idx = 0;
        
        while(idx < tangerine.length){
            int s = tangerine[idx++]; // 새로운 종류 선택
            int cnt = 1; // 1개 선택한 상황
            
            while(true){
                if(idx == tangerine.length) break; // 마지막 인덱스를 넘었음
                
                // 처음 값과 현재 값이 같을 경우
                if(s == tangerine[idx]){
                    idx++;
                    cnt++;
                    if(idx == tangerine.length) break; // 지금 확인한게 마지막인 경우
                }else{
                    break;
                }
            }
            
            list.add(cnt);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int result = 0;
        for(int i : list){
            k -= i;
            result++;
            if(k <= 0) return result;
        }
        
        return 0;   
    }
}