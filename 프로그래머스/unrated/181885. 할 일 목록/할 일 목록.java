class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < finished.length; i++){
            if(!finished[i]){
                sb.append(todo_list[i]).append(" ");
            }
        }
        
        return sb.toString().split(" ");
    }
}