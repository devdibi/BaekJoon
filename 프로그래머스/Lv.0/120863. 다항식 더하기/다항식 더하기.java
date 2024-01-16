import java.util.*;

class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int num = 0;
        for(String s : polynomial.split(" ")){
            if(s.equals("+")) continue;
            
            if(s.substring(s.length()-1).equals("x")){
                String temp = s.substring(0,s.length()-1);
                
                if(temp.length() == 0){
                    temp = "1";                    
                }
                x += Integer.parseInt(temp);
                continue;
            }
            num += Integer.parseInt(s);    
        }
        StringBuilder sb = new StringBuilder();
        
        if(num == 0 && x >= 1){
            if(x == 1){
                sb.append("x");
            }else{
                sb.append(x).append("x");        
            }
        }
        else if(num == 0 && x == 0){
            sb.append(0);
        }
        else if(num != 0 && x == 0){
            sb.append(num);
        }
        else{
            if(x == 1){
                sb.append("x").append(" ").append("+").append(" ").append(num);
            }else{
                sb.append(x).append("x").append(" ").append("+").append(" ").append(num);        
            }
        }
        
        return sb.toString();
    }
}