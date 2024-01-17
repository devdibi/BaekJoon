class Solution {
    int step = 0;
    int count = 0;
    public int[] solution(String s) {
        while(true){
            s = count(s);
            if(s.equals("1")){
                break;
            }
        }
        
        int[] result = {step,count};
        
        return result;
    }
    public String count(String str){
        step++; // 횟수 추가
        StringBuilder sb = new StringBuilder();
    
        for(char c : str.toCharArray()){
            if(c == '0'){
                count++;
            }else{
                sb.append(c);
            }
        }
        return String.valueOf(Integer.toBinaryString(sb.toString().length()));
        
    }
}