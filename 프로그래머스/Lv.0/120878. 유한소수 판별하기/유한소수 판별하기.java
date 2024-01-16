import java.util.*;
class Solution {
    public int solution(int a, int b) {
        // 분자의 약수를 먼저 구한다.
        List<Integer> list = new ArrayList();
        for(int i = 1; i <= a; i++){
            if(a % i == 0) list.add(i);
        }
        
        for(int i : list){
            if(b % i == 0 && a % i == 0){
                a /= i;
                b /= i;    
            }
        }
        
        
        while(true){
            if(b % 2 == 0){
                b /= 2;
                continue;
            }
            
            if(b % 5 == 0){
                b /= 5;
                continue;
            }
            
            if(b == 1){
                return 1;
            }else{
                return 2;
            }
            
        }         
    }
}