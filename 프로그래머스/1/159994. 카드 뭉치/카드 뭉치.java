class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int oneIdx = 0;
        int twoIdx = 0;
        
        boolean status = false;
        
        for(int i = 0; i < goal.length; i++){
            if(oneIdx < cards1.length && cards1[oneIdx].equals(goal[i])){
                oneIdx++;
                continue;
            }
            if(twoIdx < cards2.length && cards2[twoIdx].equals(goal[i])){
                twoIdx++;
                continue;
            }
            
            return "No";
            
        }
        return "Yes";
    }
    
}