import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] split = myStr.split("[abc]");
        
        List<String> list = new ArrayList<>();
        
        for(String s : split){
            if(s.length() == 0){
                continue;
            }
            list.add(s);
        }
        if(list.size() != 0){
            return list.toArray(new String[0]);
        }else{
            String[] empty = {"EMPTY"};
            return empty;
        }
    }
}