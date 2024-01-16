class Solution {
    public String solution(String code) {
        int mode = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(String s : code.split("")){
            if(s.equals("1")){
                mode = (mode == 1 ? 0 : 1);
                idx++;
                continue;
            }
            
            if(mode == 0){
                if(idx % 2 == 0){
                    sb.append(s);
                }    
            }else{
                if(idx % 2 != 0){
                    sb.append(s);
                }
            }
            idx++;
        }
        if(sb.length() == 0) return "EMPTY";
        return sb.toString();
    }
}