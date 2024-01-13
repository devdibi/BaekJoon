import java.util.*;
class Solution {
    Map<String, String> morse = new HashMap<>();
    
    public String solution(String letter) {
        make();
        
        String[] sign = letter.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : sign){
            sb.append(morse.get(s));
        }
        return sb.toString();
    }
    public void make(){
        String[] temp = {".-","a","-...","b","-.-.","c","-..","d",".","e","..-.","f",
                            "--.","g","....","h","..","i",".---","j","-.-","k",".-..","l",
                            "--","m","-.","n","---","o",".--.","p","--.-","q",".-.","r",
                            "...","s","-","t","..-","u","...-","v",".--","w","-..-","x",
                            "-.--","y","--..","z"};
        for(int i = 0; i < temp.length; i+=2){
            morse.put(temp[i], temp[i+1]);
        }
    }
}