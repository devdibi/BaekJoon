import java.util.*;

class Solution {
    String[] w;
    int[] n;
    String[] d;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        
        w = want;
        n = number;
        d = discount;
        
        int l = 0; int r = 9;
        
        // 초기확인
        for(int i = l; i <= r; i++){
            int idx = search(d[i]);

            if(idx >= 0){
                n[idx]--;
            }
        }
        
        if(check()) result++;
        
        // 이동 탐색
        while(r < d.length-1){
            // 맨앞 인덱스
            int idx = search(d[l]);
            
            if(idx >= 0){
                n[idx]++;
            }
            
            // 새로 추가할 인덱스
            r++;
            idx = search(d[r]);
            
            if(idx >= 0){
                n[idx]--;
            }
            
            if(check()) result++;  
            
            l++;
        }
        
        return result;
    }
    
    // 체크 메서드
    public boolean check(){
        for(int i : n){
            if(i > 0) return false;
        }
        return true;
    }
    
    // 인덱스 탐색 메서드
    public int search(String str){
        for(int i = 0; i < w.length; i++){
            if(str.equals(w[i])) return i;
        }
        return -1;
    }
}