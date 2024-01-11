class Solution {
    public int solution(String myString, String pat) {
        
        return compare(change(myString),pat);
    }
    public String change(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c == 'A'){
                sb.append('B');
            }else{
                sb.append('A');
            }
        }
        return sb.toString();
    }
    public Integer compare(String str, String pat){
        boolean status = false;
        for(int i = 0; i < str.length() - pat.length() + 1; i++){
            for(int j = 0; j < pat.length(); j++){
                if(str.charAt(i+j) == pat.charAt(j)){
                    status = true;
                    continue;
                }else{
                    status = false;
                    break;
                }
            }
            if(status) return 1;
        }
        return 0;
    }
}