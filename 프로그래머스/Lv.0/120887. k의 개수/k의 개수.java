class Solution {
    public int solution(int i, int j, int k) {
        int cnt = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(i <= j){
            sb.append(i++);
        }
        char t = (char)(k + 48);
        
        for(char c : sb.toString().toCharArray()){
            if(t == c) cnt++;
        }
        
        return cnt;
    }
}