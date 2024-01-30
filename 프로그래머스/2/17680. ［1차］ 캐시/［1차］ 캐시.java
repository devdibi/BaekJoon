import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 대소문자 구분을 하지 않음 => lowercase로 적용하자
        int cnt = 0;
        
        List<String> list = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++){
            String temp = cities[i].toLowerCase();
            
            // 캐싱 되어 있는 경우
            if(list.contains(temp)){
                // 캐싱 순서의 최신화가 필요
                list.remove(temp);
                // 새로 캐싱
                list.add(temp);
                cnt++;
            }else{
                if(cacheSize == 0){
                }
                else if(list.size() != 0 && list.size() >= cacheSize){
                    // 가장 오래된 문자열 제거
                    list.remove(0);
                    // 새로운 문자열 캐싱
                    list.add(temp);
                }else{
                    // 
                    list.add(temp);
                }
                cnt += 5;
            }
        }
        return cnt;
    }
}