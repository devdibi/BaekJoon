/*
    풀이
        Data(index, 우선순위) 클래스를 활용하여 객체를 생성
        Queue<Data> 객체 생성 및 값을 순서대로 넣는다.
        하나씩 추출하며 우선순위를 비교하여 큐의 순서에 맞게 값을 정리
        
*/
import java.util.*;

class Solution {
    
    public class Data{
        int i;
        int p;
        
        public Data(int i, int p){
            this.i = i;
            this.p = p;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Data> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Data(i, priorities[i]));
        }
        
        // 오름차순 정렬
        Arrays.sort(priorities);
        
        // 우선순위가 큰 끝 인덱스부터 시작
        int idx = priorities.length - 1;
        
        // 결과가 저장될 배열
        List<Data> list = new ArrayList<>();
        
        
        while(!queue.isEmpty()){
            Data temp = queue.poll();
            
            // 우선순위가 일치하는 경우 리스트에 추가
            if(temp.p == priorities[idx]){
                idx--;
                list.add(temp);
                continue;
            }
            
            // 우선순위가 낮은 경우 로테이션
            if(temp.p < priorities[idx]){
                queue.offer(temp);
                continue;
            }   
        }
        
        // 위치 계산
        int cnt = 0;
        for(Data d : list){
            cnt++;
            if(d.i == location) return cnt;
        }
        
        return cnt;
    }
}