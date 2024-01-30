import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        // 연속해서 사용은 불가능하다
        int result = 0;
        // 발음은 왼쪽부터 시작한다.
        
        String[] bab = {"aya","ye","woo","ma"};
        
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < 4; j++){
                babbling[i] = babbling[i].replace(bab[j], String.valueOf(j));
            }
        }
        boolean status = false;
        for(int i = 0; i < babbling.length; i++){
            char[] temp = babbling[i].toCharArray();
            for(int j = 0; j < temp.length; j++){
                // 안되는 경우
                if(temp[j] > 58){
                    status = true; 
                    break;
                }
                
                // 연속된 발음
                if(j < temp.length -1 && temp[j] == temp[j+1]){
                    status = true;
                    break;
                }
            }
            if(status){
                status = false;
                continue;
            }else{
                result++;
            }
            
        }
        
        return result;
    }
}

//   boolean status = false;
        
//         for(int i = 0; i < babbling.length; i++){
//             boolean[] visited = new boolean[4];
            
//             while(true){
//                 // 발음 가능한 모든 옹알이를 체크
//                 for(int j = 0; j < bab.length; j++){
//                     // 바로 전에 진행한 옹알이
//                     if(visited[j]){
//                         visited[j] = false;
//                         continue;
//                     }
                    
//                     // 시작하는게 겹치는 경우 제거
//                     if(babbling[i].startsWith(bab[j])){
//                         visited[j] = true;
//                         babbling[i] = babbling[i].substring(bab[j].length());
//                         status = true;
//                         break;
//                     }
//                 }
                
//                 if(status){
//                     status = false;
//                 }else{
//                     break;
//                 }
//             }
//             if(babbling[i].equals("")) result++;
//         }