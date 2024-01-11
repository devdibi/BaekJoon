class Solution {
    public int solution(String my_string, String target) {
        boolean status = false;
        for(int i = 0; i <= my_string.length() - target.length(); i++){
            for(int j = 0; j < target.length(); j++){
                if(my_string.charAt(i+j) == target.charAt(j)){
                    status = true;
                    continue;
                }else{
                    status = false;
                    break;
                }
            }
            if(status){
                return 1;
            }
        }
        return 0;
    }
}