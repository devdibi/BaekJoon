import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for(String[] i : clothes){
            if(map.get(i[1]) != null){
                map.replace(i[1], map.get(i[1]) + 1);
            }else{
                map.put(i[1],1);    
            }
        }    
        
        // 배열로 변환
        Collection<Integer> values = map.values();       
        Integer[] arr = values.toArray(new Integer[0]);
        
        
        
        int answer = 1;
        
        for(Integer i : arr){
            answer *= (i+1);
        }
        return answer-1;
    }
    
    
}