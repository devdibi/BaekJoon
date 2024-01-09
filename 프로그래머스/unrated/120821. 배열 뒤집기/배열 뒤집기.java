class Solution {
    public int[] solution(int[] num_list) {
        int idx = num_list.length;
        
        int[] answer = new int[idx--];    
        
        for(int i : num_list) answer[idx--] = i;
        
        return answer;
    }
}