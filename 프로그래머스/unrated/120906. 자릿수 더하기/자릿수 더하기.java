class Solution {
    public int solution(int n) {
        String[] number = Integer.toString(n).split("");
        
        int answer = 0;
        
        for(String s : number){
             answer += Integer.parseInt(s);
        }
        
        return answer;
    }
}