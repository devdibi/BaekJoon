class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int l = food[i] / 2;
            for(int j = 0; j < l; j++){
                sb.append(i);    
            }
        }
        
        String right = sb.toString();
        
        sb.append(0);
        
        for(int i = right.length() - 1 ; i >= 0; i--){
            sb.append(right.charAt(i));
        }
        
        return sb.toString();
    }
}