class Solution {
    public String solution(int n) {
        char[] temp = Integer.toString(n,3).toCharArray();
        
        for(int i = temp.length - 1; i > 0; i--){
            if(temp[i] == '0'){
                temp[i] = '4';
                if(temp[i-1] == '2'){
                    temp[i-1] = '1';
                }
                else if(temp[i-1] == '1'){
                    temp[i-1] = '0';
                }
                else{
                    temp[i-1] = '*';
                }
            }
            else if(temp[i] == '*'){
                temp[i] = '2';
                if(temp[i-1] == '2'){
                    temp[i-1] = '1';
                }
                else if(temp[i-1] == '1'){
                    temp[i-1] = '0';
                }
                else{
                    temp[i-1] = '*';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        if(temp[0] != '0') sb.append(temp[0]);
        
        for(int i = 1; i < temp.length; i++){
            sb.append(temp[i]);
        }
        
        return sb.toString();
        
    }
}