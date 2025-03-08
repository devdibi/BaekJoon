import java.util.*;

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        int aGcd = a[0];
        for (int i = 1; i < a.length; i++) {
            aGcd = gcd(aGcd, a[i]);
        }
        
        int bGcd = b[0];
        for (int i = 1; i < b.length; i++) {
            bGcd = gcd(bGcd, b[i]);
        }
        
        if(check(aGcd, b)) {
            answer = Math.max(answer, aGcd);
        } 
        
        if(check(bGcd, a)) {
            answer = Math.max(answer, bGcd);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    private boolean check(int gcd, int[] arr) {
        if (gcd == 1) return false; 
        
        for (int num : arr) {
            if (num % gcd == 0) {
                return false; 
            }
        }
        
        return true; 
    }
}