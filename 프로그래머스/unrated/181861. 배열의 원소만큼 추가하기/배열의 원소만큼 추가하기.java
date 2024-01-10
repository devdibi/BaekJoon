import java.util.*;
import java.util.stream.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[] arr) {
        for(int i : arr){
            func(i);
        }
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);   
        }
        return result;
    }
    
    public void func(int a){
        for(int i = 0; i < a; i++){
            list.add(a);
        }
    }
    
}