class Solution {
    
    public int solution(String before, String after) {
        return compare(before, after);
    }
    public int compare(String before, String after){
        int len = before.length();
        boolean[] visited = new boolean[len];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(visited[j]) continue;        
                if(before.charAt(i) == after.charAt(j)){
                    visited[j] = true;
                    break;
                }
            }
        }
        
        for(boolean v : visited){
            if(!v){
                return 0;
            }
        }
        return 1;
    }
}