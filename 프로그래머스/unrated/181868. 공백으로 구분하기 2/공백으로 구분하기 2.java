class Solution {
    public String[] solution(String my_string) {
//         StringBuilder result = new StringBuilder();
//         StringBuilder sb = new StringBuilder();
        
//         for(char c : my_string.toCharArray()){
//             if(c == ' '){
//                 if(sb.length() != 0){
//                     result.append(sb).append(" ");
//                     sb = new StringBuilder();
//                 }
//                 continue;
//             }
//             sb.append(c);    
//         }
//         if(sb.length() != 0){
//             result.append(sb);
//         }
        
//         return result.toString().split(" ");
        
        
        String[] str = my_string.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : str){
            if(s.length() != 0){
                sb.append(s).append(" ");
            }
        }
        return sb.toString().split(" ");
    }
}