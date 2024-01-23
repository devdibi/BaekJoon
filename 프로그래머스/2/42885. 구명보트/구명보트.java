import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 모든 사람을 구출해야한다.
        // 그러면 결국에는 한 보트도 낭비해서는 안된다.
        // 한번 태울때 최대 두명

        // 정렬하고
        
        // 혼자 태울지 두명 태울지 정하는건 어떤가
        // 그리고 일정 수준이 되면 무조건 두명씩 탈 수 있으므로 거기는 최종 계산
        
        // 1. 정렬
        Arrays.sort(people);
        
        // 2. 가장 무거운 사람부터 확인
        int backIdx = people.length - 1;
        int frontIdx = 0;
        int cnt = 0;
        while(frontIdx <= backIdx){
            if(people[backIdx] + people[frontIdx] > limit){
                cnt++;
                backIdx--;
            }else{
                cnt++;
                backIdx--;
                frontIdx++;
            }
        }
        return cnt;
        
    }
}