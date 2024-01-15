import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // 문자열 비교
        Arrays.sort(spell);
        
        boolean status = true;
        
        for(String d : dic){
            if(d.length() < spell.length){
                continue;
            }
            
            status = true;
            String[] temp = d.split("");
            
            Arrays.sort(temp);
            int idx = 0;
            for(String s : spell){
                if(!s.equals(temp[idx])){
                    status = false;
                    break;
                }
                idx++;
                status = true;
            }
            
            if(status) return 1;
            
        }
        
        return 2;
    }
}