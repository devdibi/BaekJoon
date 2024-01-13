import java.util.*;
class Solution {
    
    public int solution(String before, String after) {
        return compare(before, after);
    }
    public int compare(String before, String after){
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        
        Arrays.sort(b);
        Arrays.sort(a);
        
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) return 0;
        }
        return 1;
    }
}