class Solution {
    public String[] solution(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for(String str : strArr){
            if(!compare(str)){
                sb.append(str).append(" ");
            }
        }
        return sb.toString().split(" ");
    }
    
    public boolean compare(String str){
        String ad = "ad";
        boolean status = false;
        
        for(int i = 0; i < str.length() - 1; i++){
            for(int j = 0; j < 2; j++){
                if(str.charAt(i+j) == ad.charAt(j)){
                    status = true;
                    continue;
                }else{
                    status = false;
                    break;
                }
            }
            if(status){
                return true;
            }
        }
        return false;
    }
}