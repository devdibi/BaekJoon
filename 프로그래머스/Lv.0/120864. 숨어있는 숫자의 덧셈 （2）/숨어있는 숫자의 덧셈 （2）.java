import java.util.*;

class Solution {
    public int solution(String my_string) {
        return cal(my_string);
    }
    public int cal(String str){
        int sum = 0;
        
        for(int i = 'A'; i < 'z'; i++){
            str = str.replace(String.valueOf((char)i),".");
        }
        
        String[] nums = str.split("\\.");
        
        for(String i : nums){
            if(i.length() != 0) sum+= Integer.parseInt(i);
        }
        
        return sum;
    }
}