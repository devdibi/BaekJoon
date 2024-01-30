import java.util.*;

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    
    public int[] solution(String[] keymap, String[] targets) {
        // 결과
        int[] result = new int[targets.length];
        
        // 자판 생성
        for(int i = 0; i < keymap.length; i++){
            char[] str = keymap[i].toCharArray();
            for(int j = 0; j < str.length; j++){
                if(map.get(str[j]) != null){
                    map.replace(str[j], Math.min(map.get(str[j]),j+1));
                }else{
                    map.put(str[j], j+1);
                }
            }
        }
        
        // 비교
        for(int i = 0; i < targets.length; i++){
            char[] target = targets[i].toCharArray();
            
            for(int j = 0; j < target.length; j++){
                if(map.get(target[j]) == null){
                    result[i] = -1;
                    break;
                }else{
                    result[i] += map.get(target[j]);
                }
            }
        }
        
        return result;
    }
}