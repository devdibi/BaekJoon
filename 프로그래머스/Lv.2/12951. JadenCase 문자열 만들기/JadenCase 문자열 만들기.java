class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        boolean status = true;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                status = true;
                sb.append(" ");
                continue;
            }
            
            if(status){
                status = false;
                sb.append(Character.toUpperCase(s.charAt(i)));
                continue;
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}