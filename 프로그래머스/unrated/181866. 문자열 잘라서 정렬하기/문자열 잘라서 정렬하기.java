import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] result = myString.split("x");
        
        Arrays.sort(result);
        
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < result.length; i++){
            if(result[i].length() != 0){
                list.add(result[i]);    
            }
        }
        
        return list.toArray(new String[0]);
    }
}